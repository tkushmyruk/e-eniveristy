package ua.taras.kushmyruk.service.impl;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.taras.kushmyruk.model.*;
import ua.taras.kushmyruk.repository.*;
import ua.taras.kushmyruk.service.StudentService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private final FacultyRepository facultyRepository;
    private final StudentOrderRepository studentOrderRepository;
    private final AddressRepository addressRepository;
    private final PassportRepository passportRepository;
    private final CertificateRepository certificateRepository;
    private final StudentRepository studentRepository;
    private final DisciplineRepository disciplineRepository;


    private StudentOrder studentOrder;
    private Student student;
    private Address address;
    private Passport passport;
    private Certificate certificate;
    private Faculty faculty;
    private List<Discipline> disciplines = new ArrayList<>();



    public StudentServiceImpl(FacultyRepository facultyRepository, StudentOrderRepository studentOrderRepository, AddressRepository addressRepository, PassportRepository passportRepository, CertificateRepository certificateRepository, StudentRepository studentRepository, DisciplineRepository disciplineRepository) {
        this.facultyRepository = facultyRepository;
        this.studentOrderRepository = studentOrderRepository;
        this.addressRepository = addressRepository;
        this.passportRepository = passportRepository;
        this.certificateRepository = certificateRepository;
        this.studentRepository = studentRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public void addStudentOrder(Long studentId, String facultyName, String educationForm) {
        faculty = facultyRepository.findByFacultyName(facultyName);
        Hibernate.initialize(faculty.getRequiredDisciplines());
        studentOrder = new StudentOrder();
        studentOrder.setIssuDate(LocalDate.now());
        studentOrder.setEducationFrom(EducationFrom.valueOf(educationForm));
        faculty.setStudentOrder(studentOrder);
    }

    @Override
    public void AddStudentInfo(String firstName, String middleName, String lastName, String nationality,
                               String gender, LocalDate birthDay){
        student = new Student();
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setNationality(nationality);
        student.setGender(gender);
        student.setDateOfBirth(birthDay);
        student.setStudentOrder(studentOrder);
    }

    @Override
    public void addAddressInfo(String city, String street, String building, String apartment, String postCode){
        address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setBuilding(building);
        address.setApartment(apartment);
        address.setPostCode(postCode);
        address.setStudent(student);


    }

    @Override
    public void addPassport(String passportSeria, String passportNumber, String registrationOffice, LocalDate issueDate){
       passport = new Passport();
        passport.setPassportSeria(passportSeria);
        passport.setPassportNumber(passportNumber);
        passport.setRegistrationOfficeName(registrationOffice);
        passport.setIssueDate(issueDate);
        passport.setStudent(student);
    }

    @Override
    public void addCertificate(String schoolName, String certificateNumber,
                               LocalDate endSchoolDate, String[] scores){
        certificate = new Certificate();
        certificate.setSchoolName(schoolName);
        certificate.setCertificateNumber(certificateNumber);
        certificate.setEndSchoolDate(endSchoolDate);
        faculty.getRequiredDisciplines();
        List<Discipline> disciplinesFromFaculty = faculty.getRequiredDisciplines();
        for (int i = 0; i <disciplinesFromFaculty.size() ; i++) {
           Discipline discipline = disciplinesFromFaculty.get(i);
           discipline.setScore(Integer.parseInt(scores[i]));
           disciplines.add(discipline);
        }
        certificate.setStudentOrder(studentOrder);
    }

    @Override
    public String addCertificateAndPassportPhoto( MultipartFile passportFile, MultipartFile certificateFile){
        String uploadPath = "/Users/roman/IdeaProjects/university/studentPhotoFiles";
        try {
            if (passportFile != null && !passportFile.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + passportFile.getOriginalFilename();
                passportFile.transferTo(new File(uploadPath + "/" + resultFilename));

                studentOrder.setPassportFilename(resultFilename);

            }
            if (certificateFile != null && !certificateFile.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + certificateFile.getOriginalFilename();
                passportFile.transferTo(new File(uploadPath + "/" + resultFilename));

                studentOrder.setCertificateFilename(resultFilename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Files was saved";
    }

    @Override
    @Transactional
    public String submitStudentOrder(){
        studentOrderRepository.save(studentOrder);
        studentRepository.save(student);
        addressRepository.save(address);
        passportRepository.save(passport);
        certificateRepository.save(certificate);
        disciplines.forEach(discipline -> disciplineRepository.save(discipline));
        facultyRepository.save(faculty);
        return "Student order was accepted";
    }



}

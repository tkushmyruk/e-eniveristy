package ua.taras.kushmyruk.service.impl;

import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.model.*;
import ua.taras.kushmyruk.repository.*;
import ua.taras.kushmyruk.service.StudentService;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {
    private final FacultyRepository facultyRepository;
    private final StudentOrderRepository studentOrderRepository;
    private final AddressRepository addressRepository;
    private final PassportRepository passportRepository;
    private final CertificateRepository certificateRepository;


    private StudentOrder studentOrder;
    private Student student;


    public StudentServiceImpl(FacultyRepository facultyRepository, StudentOrderRepository studentOrderRepository, AddressRepository addressRepository, PassportRepository passportRepository, CertificateRepository certificateRepository) {
        this.facultyRepository = facultyRepository;
        this.studentOrderRepository = studentOrderRepository;
        this.addressRepository = addressRepository;
        this.passportRepository = passportRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    public void addStudentOrder(Long studentId, String facultyName, String educationForm) {
            Faculty faculty = facultyRepository.findByFacultyName(facultyName);
            studentOrder = new StudentOrder();
            studentOrder.setIssuDate(LocalDate.now());
            studentOrder.setEducationFrom(EducationFrom.valueOf(educationForm));
            studentOrder.setFaculty(faculty);
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
    }

    @Override
    public void addAddressInfo(String city, String street, String building, String apartment, String postCode){
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setBuilding(building);
        address.setApartment(apartment);
        address.setPostCode(postCode);
        addressRepository.save(address);
        student.setAddress(address);
    }

    @Override
    public void addPassport(String passportSeria, String passportNumber, String registrationOffice, LocalDate issueDate){
        Passport passport = new Passport();
        passport.setPassportSeria(passportSeria);
        passport.setPassportNumber(passportNumber);
        passport.setRegistrationOfficeName(registrationOffice);
        passport.setIssueDate(issueDate);
        passportRepository.save(passport);
        student.setPassport(passport);
    }

    public void addCertificate(String schoolName, String certificateNumber,
                               LocalDate endSchoolDate, String facultyName){
        Certificate certificate = new Certificate();
        certificate.setSchoolName(schoolName);
        certificate.setCertificateNumber(certificateNumber);
        certificate.setEndSchoolDate(endSchoolDate);
        certificateRepository.save(certificate);
        studentOrder.setStudentCertificate(certificate);
    }

    @Override
    public String submitStudentOrder(){
        studentOrderRepository.save(studentOrder);
        studentOrder = null;
        student = null;
        return "Student order was accepted";
    }

}

package ua.taras.kushmyruk.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

public interface StudentService {
    void addStudentOrder(Long userId, String facultyName, String educationForm);

    void AddStudentInfo(String firstName, String middleName, String lastName, String nationality,
                        String gender, LocalDate birthDay);

    void addAddressInfo(String city, String street, String building, String apartment, String postCode);

    void addPassport(String passportSeria, String passportNumber, String registrationOffice, LocalDate issueDate);

    void addCertificate(String schoolName, String certificateNumber,
                        LocalDate endSchoolDate, String[] scores);

    String addCertificateAndPassportPhoto(MultipartFile passportFile, MultipartFile certificateFile);

    String submitStudentOrder();
}

package ua.taras.kushmyruk.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.taras.kushmyruk.model.User;
import ua.taras.kushmyruk.service.FacultyService;
import ua.taras.kushmyruk.service.StudentService;

import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping("/student-order")
public class StudentOrderController {
    private final StudentService studentService ;
    private final FacultyService facultyService;

    public StudentOrderController(StudentService studentService, FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @GetMapping("/{facultyName}")
    public String getStudentOrderPage(@PathVariable String facultyName, Model model) {
        model.addAttribute("facultyName", facultyName);
        return "studentOrder_1";
    }

    @GetMapping("/{facultyName}/1")
    public String getStudentInfoPage(@PathVariable String facultyName, Model model) {
        model.addAttribute("facultyName", facultyName);
        return "studentOrder_2";
    }

    @GetMapping("/{facultyName}/2")
    public String getAddressInfo(@PathVariable String facultyName, Model model) {
        model.addAttribute("facultyName", facultyName);
        return "studentOrder_3";
    }

    @GetMapping("/{facultyName}/3")
    public String getPassportInfo(@PathVariable String facultyName, Model model){
        model.addAttribute("facultyName", facultyName);
        return "studentOrder_4";
    }

    @GetMapping("/{facultyName}/4")
    public String getCertificateInfo(@PathVariable String facultyName, Model model){
        model.addAttribute("facultyName", facultyName);
        model.addAttribute("disciplines", facultyService.getReqiuredDisciplines(facultyName));
        return "studentOrder_5";
    }

    @GetMapping("/{facultyName}/5")
    public String addCerificateAndPassport(@PathVariable String facultyName, Model model){
        model.addAttribute("facultyName", facultyName);
        return "studentOrder_6";
    }
    @GetMapping("/submitStudentOrder")
    public String getEndPage(){
        return "submitStudentOrder";
    }


    @PostMapping("/{facultyName}")
    public String startStudentOrder(@PathVariable String facultyName,
                                     @AuthenticationPrincipal User user,
                                    @RequestParam String educationForm){
     studentService.addStudentOrder(user.getUserId(), facultyName,  educationForm);
     return "redirect:/student-order/" + facultyName + "/1";
    }

    @PostMapping("/{facultyName}/1")
    public String addStudentInfo(@PathVariable String facultyName,
                                 @RequestParam String firstName,
                                 @RequestParam String middleName,
                                 @RequestParam String lastName,
                                 @RequestParam String dateOfBirth,
                                 @RequestParam String nationality,
                                 @RequestParam String gender
    ){
        studentService.AddStudentInfo(firstName, middleName, lastName, nationality, gender,
                LocalDate.parse(dateOfBirth));
    return "redirect:/student-order/" + facultyName + "/2";
    }

    @PostMapping("/{facultyName}/2")
    public String addAddressInfo(@PathVariable String facultyName,
                                 @RequestParam String city,
                                 @RequestParam String street,
                                 @RequestParam String building,
                                 @RequestParam String apartment,
                                 @RequestParam String postCode){
        studentService.addAddressInfo(city, street, building, apartment, postCode);
        return "redirect:/student-order/" + facultyName + "/3";
    }

    @PostMapping ("/{facultyName}/3")
    public  String addPassportInfo(@PathVariable String facultyName,
                                   @RequestParam String passportSeria,
                                   @RequestParam String passportNumber,
                                   @RequestParam String registrationOffice,
                                   @RequestParam String issueDate){
        studentService.addPassport(passportSeria, passportNumber, registrationOffice, LocalDate.parse(issueDate));
        return "redirect:/student-order/" + facultyName + "/4";
    }

    @PostMapping("/{facultyName}/4")
    public String getCertificateInfo(@PathVariable String facultyName,
                                     @RequestParam String certificateNumber,
                                     @RequestParam String schoolName,
                                     @RequestParam String endDate,
                                     @RequestParam String ... scores){

     studentService.addCertificate(certificateNumber, schoolName, LocalDate.parse(endDate), scores);
     return "redirect:/student-order/" + facultyName + "/5";
    }

    @PostMapping("/{faciltyName}/5")
    public String addPhotoAndCertificateAndSubmitSO(@RequestParam MultipartFile passportPhotofile,
                                                    @RequestParam MultipartFile certificatePhotofile){
        studentService.addCertificateAndPassportPhoto(passportPhotofile, certificatePhotofile);
        return "redirect:/student-order/submitStudentOrder";
    }

    @PostMapping("/submitStudentOrder")
    public String submitFullStudentOrder(){
        studentService.submitStudentOrder();
        return "redirect:/";
    }

}

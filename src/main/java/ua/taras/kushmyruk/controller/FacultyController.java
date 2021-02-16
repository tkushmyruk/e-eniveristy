package ua.taras.kushmyruk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.taras.kushmyruk.model.Faculty;
import ua.taras.kushmyruk.service.FacultyService;

import java.util.List;

@Controller
@RequestMapping("/faculties")
public class FacultyController {
   private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public String getListOfFaculty(Model model) {
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "faculty";
    }

    @GetMapping("/redaction")
    public String redactionFaculty(Model model){
        List<Faculty> faculties = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "facultyRedact";
    }

    @GetMapping("/redaction/{facultyName}")
    public String changeFaculty(@PathVariable String facultyName, Model model){
        Faculty faculty =  facultyService.getFacultyByName(facultyName);
        model.addAttribute("faculty", faculty);
        model.addAttribute("disciplines", faculty.getRequiredDisciplines());
        model.addAttribute("address", faculty.getFacultyAddress());
        return "changeFaculty";
    }



    @GetMapping("/{facultyName}")
    public String getFaculty(@PathVariable String facultyName, Model model){
        return "faculty";
    }

    @PostMapping("/redaction")
    public String addFaculty (@RequestParam String facultyName,
                              @RequestParam String disciplines,
                              @RequestParam String freePlaces,
                              @RequestParam String scholarshipPlaces,
                              @RequestParam String city,
                              @RequestParam String street,
                              @RequestParam String building,
                              Model model){
        facultyService.addFaculty(facultyName, Integer.parseInt(freePlaces), Integer.parseInt(scholarshipPlaces),
                city, street, building, disciplines);
        List<Faculty> faculties  = facultyService.getAllFaculties();
        model.addAttribute("faculties", faculties);
        return "facultyRedact";
    }

}

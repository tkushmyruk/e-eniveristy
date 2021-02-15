package ua.taras.kushmyruk.service;

import ua.taras.kushmyruk.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculties();

    Faculty getFacultyByName(String facultyName);

    void addFaculty(String name, int freePlaces, int scholarshipPlaces,
                    String city, String street, String building, String disciplines);
}

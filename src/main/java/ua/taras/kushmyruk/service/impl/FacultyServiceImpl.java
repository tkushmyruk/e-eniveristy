package ua.taras.kushmyruk.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.taras.kushmyruk.model.Address;
import ua.taras.kushmyruk.model.Discipline;
import ua.taras.kushmyruk.model.Faculty;
import ua.taras.kushmyruk.repository.AddressRepository;
import ua.taras.kushmyruk.repository.DisciplineRepository;
import ua.taras.kushmyruk.repository.FacultyRepository;
import ua.taras.kushmyruk.service.FacultyService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final AddressRepository addressRepository;
    private final DisciplineRepository disciplineRepository;



    public FacultyServiceImpl(FacultyRepository facultyRepository, AddressRepository addressRepository, DisciplineRepository disciplineRepository) {
        this.facultyRepository = facultyRepository;
        this.addressRepository = addressRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyByName(String facultyName){
        return facultyRepository.findByFacultyName(facultyName);
    }

    @Override
    @Transactional
    public void addFaculty(String name, int freePlaces, int scholarshipPlaces,
                           String city, String street, String building, String disciplines) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(name);
        faculty.setFreePlaces(freePlaces);
        faculty.setScholarshipPlaces(scholarshipPlaces);
        Set<Discipline> facultyDisciplines = Arrays
                .stream(disciplines.split(";"))
                .distinct()
                .map(s -> {
                    Discipline disciplineFromBd = disciplineRepository.findByDisciplineName(s.trim());
                    if(disciplineFromBd == null) {
                        Discipline discipline = new Discipline();
                        discipline.setDisciplineName(s.trim());
                        disciplineRepository.save(discipline);
                        return discipline;
                    }
                    return disciplineFromBd;
                })
                .collect(Collectors.toSet());
        faculty.setRequiredDisciplines(facultyDisciplines);
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setBuilding(building);
        addressRepository.save(address);
        faculty.setFacultyAddress(address);
        facultyRepository.save(faculty);
    }
}
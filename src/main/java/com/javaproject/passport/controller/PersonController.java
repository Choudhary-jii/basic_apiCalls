package com.javaproject.passport.controller;

import com.javaproject.passport.entity.People;
import com.javaproject.passport.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PassportService service;

    @PostMapping("/addPerson")
    public People addPerson(@RequestBody People people){
        return service.saveDetail(people);
    }
    @PostMapping("/addPersons")
    public List<People> addPersons(@RequestBody List<People> peoples) {
        return service.getAllPerson(peoples);
    }

    @GetMapping("/persons")
    public List<People> getProples(){
        return service.getPeoples();
    }

    @GetMapping("/person/{id}")
    public People findPeopleById(@PathVariable int id){
        return  service.getPeopleById(id);
    }

    @GetMapping("/person/name/{name}")
    public People findPeopleByName(@PathVariable String name){
        return  service.getPeopleByName(name);
    }

    @PutMapping("/update")
    public People updatePeople(@RequestBody People people){
        return service.updatePeople(people);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        return service.deletePeople(id);
    }

}


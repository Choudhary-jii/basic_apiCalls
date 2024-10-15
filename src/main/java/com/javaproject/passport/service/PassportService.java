package com.javaproject.passport.service;

import com.javaproject.passport.entity.People;
import com.javaproject.passport.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService
{
    @Autowired
    public PersonRepository repository;


    //POST METHODS
    public People saveDetail(People people){
        return  repository.save(people);
    }
    public List<People> getAllPerson(List<People> peoples){
        return  repository.saveAll(peoples);
    }

    public List<People> getPeoples(){
        return  repository.findAll();
    }

    public People getPeopleById(int id){
        return  repository.findById(id).orElse(null);
    }

    public People getPeopleByName(String name){
        return   repository.findByName(name);
    }

    public String deletePeople(int id){
         repository.deleteById(id);
        return "Person is removed successfully" + id;
    }


    public People updatePeople(People people) {
        People existingPerson = repository.findById(people.getId()).orElse(null);
        if (existingPerson != null) {
            existingPerson.setName(people.getName());
            existingPerson.setMobileNumber(people.getMobileNumber());
            existingPerson.setPspExpMonth(people.getPspExpMonth());
            existingPerson.setPspExpYear(people.getPspExpYear());
            existingPerson.setPspIssueMonth(people.getPspIssueMonth());
            existingPerson.setPspIssueYear(people.getPspIssueYear());
            return repository.save(existingPerson);
        }
        return null; // Optionally, you could throw an exception if the person is not found
    }


}

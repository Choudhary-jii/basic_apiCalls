package com.javaproject.passport.repository;

import com.javaproject.passport.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<People, Integer> {
    People findByName(String name);

    //void delete(int id);

    void deleteById(int id);

}

package com.nandi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nandi.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}

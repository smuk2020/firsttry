package com.shubhankar.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shubhankar.demo.model.Student;



@RepositoryRestResource(collectionResourceRel="students", path="students")
public interface StudentRepo extends JpaRepository<Student, Integer>
{

}

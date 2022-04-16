package com.lakshan.demoapp.repository;

import com.lakshan.demoapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Student save(Student student);

}

package com.lakshan.demoapp.service;

import com.lakshan.demoapp.model.Student;

public interface StudentService {

    Student save(Student student);

    Student fetchStudentById(int id);
}

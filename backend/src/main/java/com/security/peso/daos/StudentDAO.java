package com.security.peso.daos;

import com.security.peso.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentDAO {
    Student saveStudent(Student student);

    Optional<Student> getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student student);


    Student updateStudentByFields(Long id, Map<String, Object> fields);

    void deleteStudentById(Long id);

}

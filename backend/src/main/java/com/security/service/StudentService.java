package com.security.service;

import com.security.daos.StudentDAO;
import com.security.model.Student;
import com.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class StudentService implements StudentDAO {


    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);

    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public Student updateStudentByFields(Long id, Map<String, Object> fields) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {

    }
}

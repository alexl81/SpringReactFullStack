package ru.lostfound.SpringReactFullStack.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lostfound.SpringReactFullStack.exception.BadRequestException;
import ru.lostfound.SpringReactFullStack.exception.StudentNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if(existsEmail) {
            throw new BadRequestException("Email " + student.getEmail() + " taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id " + id + " does not exists");
        }
        studentRepository.deleteById(id);
    }
}

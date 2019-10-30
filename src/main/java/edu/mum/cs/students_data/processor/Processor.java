package edu.mum.cs.students_data.processor;

import edu.mum.cs.students_data.model.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Processor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) throws Exception {
        Integer age = student.getAge();
        student.setBirthday(LocalDate.of(LocalDate.now().getYear() - age, 01, 10));
        return student;
    }
}

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
        Integer age = Integer.parseInt(student.getBirthday());
       LocalDate birthday = LocalDate.of(LocalDate.now().getYear() - age, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
       student.setBirthday(birthday.toString());
       return student;
    }
}

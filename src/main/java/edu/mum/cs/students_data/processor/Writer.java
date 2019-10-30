package edu.mum.cs.students_data.processor;

import edu.mum.cs.students_data.model.Student;
import edu.mum.cs.students_data.repository.StudentRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<Student> {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void write(List<? extends Student> students) throws Exception {
        studentRepository.saveAll(students);
    }
}

package edu.mum.cs.students_data.configuration;

import edu.mum.cs.students_data.model.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfigurationClass {

    @Bean
    Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
            ItemReader<Student> itemReader, ItemProcessor<Student, Student> itemProcessor,
            ItemWriter<Student> itemWriter) {

        Step step = stepBuilderFactory.get("student-data")
                .<Student, Student>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        return jobBuilderFactory.get("student-data")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<Student> flatFileItemReader(@Value("classpath:students.csv") Resource resource) {
        FlatFileItemReader<Student> flatFileItemReader = new FlatFileItemReader();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("students-mapper");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(linemapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<Student> linemapper() {

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames(new String[]{"id", "firstName", "lastName", "gpa", "age"});
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setDelimiter(",");

        BeanWrapperFieldSetMapper<Student> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Student.class);

        DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }
}

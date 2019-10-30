package edu.mum.cs.students_data.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    JobLauncher launcher;

    @Autowired
    Job job;


    @GetMapping(value = {"/", "/home", "/login"})
    public String load() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> maps = new HashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        maps.put("Execution time", new JobParameter(dtf.format(now)));
        JobParameters params = new JobParameters(maps);
        JobExecution jobExecution = launcher.run(job, params);

        return "job/startjob";
    }



}

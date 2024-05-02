package com.spring.batch.controller;


import com.spring.batch.Config.EConfig;
import com.spring.batch.batch.job.EJob;
import com.spring.batch.model.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class JOBTESTINGController {


    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    private EJob regularJob;
    @Autowired
    public JobExplorer jobExplorer;

    @Value("${jdaCronExpr}")
    private String jdaCronExpr;

    @Value("${timeZone}")
    private String timeZone;

    @Bean
    public Trigger regularJdaTrigger() {
        log.info("Executing the trigger in TimeZone: " + timeZone);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jdaCronExpr)
                .inTimeZone(TimeZone.getTimeZone(timeZone));
        return TriggerBuilder.newTrigger()
                .forJob(regularJdaJobDetail())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail regularJdaJobDetail() {
        return JobBuilder.newJob(EConfig.class)
                .storeDurably()
                .build();
    }

    @GetMapping(value = "/regularjob")
    public void handle() throws Exception {

        log.info("Executing the JDA regular rpa job..");
        JobParameters parameters = new JobParametersBuilder(jobExplorer)
                .getNextJobParameters(regularJob.normalJob())
                .toJobParameters();
        try {
            this.jobLauncher.run(regularJob.normalJob(), parameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
                 | JobParametersInvalidException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorMessage(e.getMessage());
            errorDetails.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            errorDetails.setErrorType("Scheduler");
            log.error("Error occured while executing job.. " + errorDetails.jsonObject());
        }
    }

}







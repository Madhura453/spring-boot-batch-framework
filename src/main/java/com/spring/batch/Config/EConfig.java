package com.spring.batch.Config;

import com.spring.batch.batch.job.EJob;
import com.spring.batch.model.ErrorDetails;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
@EnableScheduling
@Slf4j
public class EConfig extends QuartzJobBean {

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    public JobExplorer jobExplorer;

    @Autowired
    private EJob jdaRegularRpaJob;

    @Value("${jdaCronExpr}")
    private String cronExpr;

    @Value("${timeZone}")
    private String timeZone;

    @Bean
    public Trigger regularJdaTrigger() {
        log.info("Executing the trigger in TimeZone: " + timeZone);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpr)
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

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("Executing the JDA regular rpa job..");
        JobParameters parameters = new JobParametersBuilder(jobExplorer)
                .getNextJobParameters(jdaRegularRpaJob.normalJob())
                .toJobParameters();
        try {
            this.jobLauncher.run(jdaRegularRpaJob.normalJob(), parameters);
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

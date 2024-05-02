package com.spring.batch.batch.job;


import com.spring.batch.batch.step.EStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EJob {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public EStep processAndSendRegularRPAsTOJDAStep;

    @Bean
    public Job normalJob() throws Exception {
        log.info("Executing the JDA Regular job ProcessAndSendRegularRPAsTOJDAJob ..");
        return this.jobBuilderFactory
                .get("ProcessAndSendRegularRPAsTOJDAJob")
                .incrementer(new RunIdIncrementer())
                .start(processAndSendRegularRPAsTOJDAStep.regularJdaChunkBasedStep())
                .build();
    }

}

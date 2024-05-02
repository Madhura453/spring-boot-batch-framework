package com.spring.batch.batch.step;


import com.spring.batch.batch.Processor.EProcessor;
import com.spring.batch.batch.reader.EReader;
import com.spring.batch.batch.writer.EWriter;
import com.spring.batch.converter.Converter;
import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;
import com.spring.batch.repository.EmployeeRepository;
import com.spring.batch.service.EmployeeFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class EStep {
    @Value("#{${jdaLocationIds}}")
    private List<String> jdaLocationIds;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Converter<Employee, EmployeeDto> rpaHeaderJDARegularRpaConverter;

    @Autowired
    private EmployeeRepository rpaHeaderRepository;


    @Autowired
    private EmployeeFileService jdaFileService;

    @Bean
    public ItemReader<Employee> regularItemReader(List<Employee> rpaHeaderList) {
        return new EReader(rpaHeaderList);
    }

    @Bean
    public ItemProcessor<Employee, EmployeeDto> regularItemProcessor(@Qualifier("regularRpaConverter")
                                                                     Converter<Employee, EmployeeDto> converter) {
        return new EProcessor(converter);
    }

    @Bean
    public ItemWriter<EmployeeDto> regularItemWriter() {
        return new EWriter(jdaFileService);
    }

    @Bean
    public Step regularJdaChunkBasedStep() throws Exception {
        log.info("Executing the chunk-based regular Rpa step ProcessAndSendRegularRPAsTOJDAStep..");
        List<Employee> rpaHeaderList = rpaHeaderRepository.findAll();
        return this.stepBuilderFactory
                .get("chunkBasedStep")
                .<Employee, EmployeeDto>chunk(rpaHeaderList.size())
                .reader(regularItemReader(rpaHeaderList))
                .processor(regularItemProcessor(rpaHeaderJDARegularRpaConverter))
                .writer(regularItemWriter())
                .build();
    }

}

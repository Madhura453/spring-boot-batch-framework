package com.spring.batch.batch.writer;

import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;
import com.spring.batch.service.EmployeeFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EWriter implements ItemWriter<EmployeeDto> {

    private EmployeeFileService jdaFileService;

    public EWriter(EmployeeFileService jdaFileService) {
        this.jdaFileService = jdaFileService;
    }

    @Override
    public void write(List<? extends EmployeeDto> list) throws Exception {
        List<EmployeeDto> regularRpas = new ArrayList<>();
        list.stream().forEach(r -> regularRpas.add(r));
        log.info("Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                list);
        jdaFileService.createFlatFileAndUpload(regularRpas);

    }
}
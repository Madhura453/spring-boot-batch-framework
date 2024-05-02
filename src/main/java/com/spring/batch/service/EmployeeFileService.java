package com.spring.batch.service;

import com.spring.batch.dto.EmployeeDto;

import java.util.List;

public interface EmployeeFileService {
    boolean createFlatFileAndUpload(List<EmployeeDto> regularRpas);
}

package com.spring.batch.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import com.spring.batch.dto.EmployeeDto;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeFileServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EmployeeFileServiceImplTest {
    @Autowired
    private EmployeeFileServiceImpl employeeFileServiceImpl;

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload() {
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(new ArrayList<>()));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(new ArrayList<>()));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload2() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload3() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload4() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("S", "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload5() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto());
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload6() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(null);
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload7() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(mock(EmployeeDto.class));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload8() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload9() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        employeeDtoList.add(new EmployeeDto("Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload10() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto("S", "Converting regularRpas to Flat File. The regularRpas's are: {}",
                "Converting regularRpas to Flat File. The regularRpas's are: {}"));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload11() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(new EmployeeDto());
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload12() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(null);
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }

    /**
     * Method under test: {@link EmployeeFileServiceImpl#createFlatFileAndUpload(java.util.List)}
     */
    @Test
    void testCreateFlatFileAndUpload13() {
        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList.add(mock(EmployeeDto.class));
        assertFalse(this.employeeFileServiceImpl.createFlatFileAndUpload(employeeDtoList));
    }
}


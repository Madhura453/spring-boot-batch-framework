package com.spring.batch.batch.writer;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.service.EmployeeFileService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EWriterTest {
    /**
     * Method under test: {@link EWriter#EWriter(EmployeeFileService)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EWriter.jdaFileService

        new EWriter(mock(EmployeeFileService.class));
    }

    /**
     * Method under test: {@link EWriter#write(java.util.List)}
     */
    @Test
    void testWrite() throws Exception {
        EmployeeFileService employeeFileService = mock(EmployeeFileService.class);
        when(employeeFileService.createFlatFileAndUpload((java.util.List<EmployeeDto>) any())).thenReturn(true);
        EWriter eWriter = new EWriter(employeeFileService);
        eWriter.write(new ArrayList<>());
        verify(employeeFileService).createFlatFileAndUpload((java.util.List<EmployeeDto>) any());
    }

    /**
     * Method under test: {@link EWriter#write(java.util.List)}
     */
    @Test
    void testWrite2() throws Exception {
        EmployeeFileService employeeFileService = mock(EmployeeFileService.class);
        when(employeeFileService.createFlatFileAndUpload((java.util.List<EmployeeDto>) any())).thenReturn(true);
        EWriter eWriter = new EWriter(employeeFileService);

        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList
                .add(new EmployeeDto("Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}"));
        eWriter.write(employeeDtoList);
        verify(employeeFileService).createFlatFileAndUpload((java.util.List<EmployeeDto>) any());
    }

    /**
     * Method under test: {@link EWriter#write(java.util.List)}
     */
    @Test
    void testWrite3() throws Exception {
        EmployeeFileService employeeFileService = mock(EmployeeFileService.class);
        when(employeeFileService.createFlatFileAndUpload((java.util.List<EmployeeDto>) any())).thenReturn(true);
        EWriter eWriter = new EWriter(employeeFileService);

        ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeDtoList
                .add(new EmployeeDto("Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}"));
        employeeDtoList
                .add(new EmployeeDto("Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}",
                        "Batch writer create and upload file to Azure blob stroage.The JDRpaDtos are: {}"));
        eWriter.write(employeeDtoList);
        verify(employeeFileService).createFlatFileAndUpload((java.util.List<EmployeeDto>) any());
    }
}


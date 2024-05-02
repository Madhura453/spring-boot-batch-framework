package com.spring.batch.batch.Processor;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spring.batch.converter.Converter;
import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;
import org.junit.jupiter.api.Test;

class EProcessorTest {
    /**
     * Method under test: {@link EProcessor#EProcessor(Converter)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EProcessor.rpaHeaderJDARegularRpaConverter

        new EProcessor((Converter<Employee, EmployeeDto>) mock(Converter.class));
    }

    /**
     * Method under test: {@link EProcessor#process(Employee)}
     */
    @Test
    void testProcess() throws Exception {
        Converter<Employee, EmployeeDto> converter = (Converter<Employee, EmployeeDto>) mock(Converter.class);
        EmployeeDto employeeDto = new EmployeeDto("Eid", "Name", "Dept");

        when(converter.convert((Employee) any())).thenReturn(employeeDto);
        EProcessor eProcessor = new EProcessor(converter);

        Employee employee = new Employee();
        employee.setDept("Dept");
        employee.setEid("Eid");
        employee.setName("Name");
        assertSame(employeeDto, eProcessor.process(employee));
        verify(converter).convert((Employee) any());
    }
}


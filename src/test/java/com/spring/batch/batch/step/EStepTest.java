package com.spring.batch.batch.step;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spring.batch.converter.Converter;
import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

class EStepTest {
    /**
     * Method under test: {@link EStep#regularItemReader(java.util.List)}
     */
    @Test
    void testRegularItemReader() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.NullPointerException: need a type map
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        EStep eStep = new EStep();
        assertNull(eStep.regularItemReader(new ArrayList<>()).read());
    }

    /**
     * Method under test: {@link EStep#regularItemReader(java.util.List)}
     */
    @Test
    void testRegularItemReader2() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.NullPointerException: need a type map
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        EStep eStep = new EStep();

        Employee employee = new Employee();
        employee.setDept("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setEid("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setName("Reading the data from the database for sending rpa's  to TOS . ..");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Employee actualReadResult = eStep.regularItemReader(employeeList).read();
        assertSame(employeeList.get(0), actualReadResult);
    }

    /**
     * Method under test: {@link EStep#regularItemReader(java.util.List)}
     */
    @Test
    void testRegularItemReader3() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.NullPointerException: need a type map
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        EStep eStep = new EStep();
        Employee employee = mock(Employee.class);
        doNothing().when(employee).setDept((String) any());
        doNothing().when(employee).setEid((String) any());
        doNothing().when(employee).setName((String) any());
        employee.setDept("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setEid("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setName("Reading the data from the database for sending rpa's  to TOS . ..");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Employee actualReadResult = eStep.regularItemReader(employeeList).read();
        verify(employee).setDept((String) any());
        verify(employee).setEid((String) any());
        verify(employee).setName((String) any());
        assertSame(employeeList.get(0), actualReadResult);
    }

    /**
     * Method under test: {@link EStep#regularItemProcessor(Converter)}
     */
    @Test
    void testRegularItemProcessor() throws Exception {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.NullPointerException: need a type map
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        EStep eStep = new EStep();
        Converter<Employee, EmployeeDto> converter = (Converter<Employee, EmployeeDto>) mock(Converter.class);
        EmployeeDto employeeDto = new EmployeeDto("Eid", "Name", "Dept");

        when(converter.convert((Employee) any())).thenReturn(employeeDto);
        ItemProcessor<Employee, EmployeeDto> actualRegularItemProcessorResult = eStep.regularItemProcessor(converter);
        Employee employee = new Employee();
        employee.setDept("Dept");
        employee.setEid("Eid");
        employee.setName("Name");
        EmployeeDto actualProcessResult = actualRegularItemProcessorResult.process(employee);
        verify(converter).convert((Employee) any());
        assertSame(employeeDto, actualProcessResult);
    }

    /**
     * Method under test: {@link EStep#regularItemWriter()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegularItemWriter() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.spring.batch.batch.writer.EWriter.write(EWriter.java:27)
        //   In order to prevent regularItemWriter()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   regularItemWriter().
        //   See https://diff.blue/R013 to resolve this issue.

        ItemWriter<EmployeeDto> actualRegularItemWriterResult = (new EStep()).regularItemWriter();
        actualRegularItemWriterResult.write(new ArrayList<>());
    }

    /**
     * Method under test: {@link EStep#regularJdaChunkBasedStep()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegularJdaChunkBasedStep() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.spring.batch.batch.step.EStep.regularJdaChunkBasedStep(EStep.java:66)
        //   In order to prevent regularJdaChunkBasedStep()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   regularJdaChunkBasedStep().
        //   See https://diff.blue/R013 to resolve this issue.

        (new EStep()).regularJdaChunkBasedStep();
    }
}


package com.spring.batch.batch.reader;

import com.spring.batch.model.Employee;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EReaderTest {
    /**
     * Method under test: {@link EReader#EReader(java.util.List)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EReader.rpaHeaderIterator

        (new EReader(new ArrayList<>())).read();
    }

    /**
     * Method under test: {@link EReader#EReader(java.util.List)}
     */
    @Test
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EReader.rpaHeaderIterator

        Employee employee = new Employee();
        employee.setDept("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setEid("Reading the data from the database for sending rpa's  to TOS . ..");
        employee.setName("Reading the data from the database for sending rpa's  to TOS . ..");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        (new EReader(employeeList)).read();
    }
}


package com.spring.batch.converter;

import com.spring.batch.annotation.Position;
import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;

public class EmployeeToDtoConverter implements  Converter<Employee, EmployeeDto>{
    @Override
    public EmployeeDto convert(Employee employee) {

        return EmployeeDto.builder().eid(employee.getEid()).name(employee.getName()).
                dept(employee.getDept()).build();
    }
}

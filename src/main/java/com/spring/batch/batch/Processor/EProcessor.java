package com.spring.batch.batch.Processor;

import com.spring.batch.converter.Converter;
import com.spring.batch.dto.EmployeeDto;
import com.spring.batch.model.Employee;
import lombok.extern.slf4j.Slf4j;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class EProcessor implements ItemProcessor<Employee, EmployeeDto> {

    private Converter<Employee, EmployeeDto> rpaHeaderJDARegularRpaConverter;

    public EProcessor(Converter<Employee, EmployeeDto> rpaHeaderJDARegularRpaConverter) {
        this.rpaHeaderJDARegularRpaConverter = rpaHeaderJDARegularRpaConverter;
    }

    @Override
    public EmployeeDto process(Employee employee) throws Exception {
        log.info("Transforming the rpaHeader to JDARpaDto.");
        return rpaHeaderJDARegularRpaConverter.convert(employee);
    }
}

package com.spring.batch.batch.reader;

import com.spring.batch.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class EReader implements ItemReader<Employee> {

    private Iterator<Employee> rpaHeaderIterator;

    public EReader(List<Employee> rpaHeaderList) {
        this.rpaHeaderIterator = rpaHeaderList.iterator();
    }

    @Override
    public Employee read() {
        log.info("Reading the data from the database for sending rpa's  to TOS . ..");
        if (rpaHeaderIterator.hasNext()) {
            return rpaHeaderIterator.next();
        } else {
            return null;
        }
    }
}

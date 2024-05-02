package com.spring.batch.dto;

import com.spring.batch.annotation.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    @Position(length = 3, delimeter = "S")
    public String eid;
    @Position(length = 5, delimeter = "S")
    public String name;
    @Position(length = 6, delimeter = "S")
    public String dept;

}

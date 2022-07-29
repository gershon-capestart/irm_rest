package com.capestart.irm.employees.pojo;

import lombok.Builder;
import lombok.Data;

import static com.capestart.irm.common.utils.QueryUtils.convertObjToInteger;
import static com.capestart.irm.common.utils.QueryUtils.convertObjToString;

@Data
@Builder
public class Employee {
    private String name;
    private int code;
    private String designation;
    private String email;
    private String team;

    public static Employee ConvertObjToEmployee(Object[] row) {
        return Employee.builder()
                .name(convertObjToString(row[0]))
                .code(convertObjToInteger(row[1]))
                .designation(convertObjToString(row[2]))
                .email(convertObjToString(row[3]))
                .team(convertObjToString(row[4]))
                .build();
    }
}

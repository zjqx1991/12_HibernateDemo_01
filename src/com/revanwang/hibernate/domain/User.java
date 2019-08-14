package com.revanwang.hibernate.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
    private Date    hiredate;

}
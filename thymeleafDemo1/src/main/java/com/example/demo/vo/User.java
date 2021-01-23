package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private Integer sex;
    private Date birthday;
}

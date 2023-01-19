package com.example.currencyexchangeservice.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "access")
@Data
public class AccessModel {

    @Id
    @Column(name = "userid")
    private Integer userId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "username")
    private String userName;


    @Column(name = "password")
    private String password;
}

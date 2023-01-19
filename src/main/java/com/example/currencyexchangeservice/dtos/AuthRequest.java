package com.example.currencyexchangeservice.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
}

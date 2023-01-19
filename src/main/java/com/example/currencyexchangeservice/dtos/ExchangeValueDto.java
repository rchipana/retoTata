package com.example.currencyexchangeservice.dtos;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class ExchangeValueDto {



    private String from;


    private String to;

    private BigDecimal exchangeRate;

    private BigDecimal quantity;

    private BigDecimal totalCalculateAmount;
}

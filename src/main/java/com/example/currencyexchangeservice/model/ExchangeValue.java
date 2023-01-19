package com.example.currencyexchangeservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "EXCHANGE")
@Data
public class ExchangeValue {
    @Id
    private Integer id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;


    private  String operation;



}

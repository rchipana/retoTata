package com.example.currencyexchangeservice.controller;


import com.example.currencyexchangeservice.dtos.AuthRequest;
import com.example.currencyexchangeservice.dtos.ExchangeValueDto;
import com.example.currencyexchangeservice.model.ExchangeValue;
import com.example.currencyexchangeservice.repository.ExchangeValueRepository;
import com.example.currencyexchangeservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.math.*;

@RestController
public class CurrencyExchangeController {

    @Autowired
    ExchangeValueRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<?> retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, Object> response = new HashMap<>();

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        if (exchangeValue != null) {
            ExchangeValueDto dto = new ExchangeValueDto();

            dto.setFrom(from);
            dto.setTo(to);
            dto.setExchangeRate(exchangeValue.getExchangeRate());
            dto.setQuantity(quantity);
            if (exchangeValue.getOperation().equalsIgnoreCase("1")) {
                dto.setTotalCalculateAmount(quantity.multiply(exchangeValue.getExchangeRate()));
            } else {
                dto.setTotalCalculateAmount(quantity.divide(exchangeValue.getExchangeRate(), 2, RoundingMode.CEILING));

            }

            response.put("conversion", dto);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }

        response.put("error", "internal server");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}




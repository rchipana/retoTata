package com.example.currencyexchangeservice.repository;

import com.example.currencyexchangeservice.model.AccessModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepository  extends CrudRepository<AccessModel, Long> {

    AccessModel findByUserName(String username);
}

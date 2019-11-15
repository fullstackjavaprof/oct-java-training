package com.javafullstacktraining.swaggerdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javafullstacktraining.swaggerdemo.model.UserRecord;


@Repository
public interface UserRepository extends CrudRepository<UserRecord, String>{

}

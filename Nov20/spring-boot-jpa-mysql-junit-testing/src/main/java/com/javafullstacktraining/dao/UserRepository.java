package com.javafullstacktraining.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javafullstacktraining.entities.UserRecord;

@Repository
public interface UserRepository extends CrudRepository<UserRecord, Integer> {

}

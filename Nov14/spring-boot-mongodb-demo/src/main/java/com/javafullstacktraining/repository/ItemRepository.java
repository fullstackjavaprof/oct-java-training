package com.javafullstacktraining.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javafullstacktraining.docs.Item;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item,Long> {
    List<Item> findByCategory(String category);
    Item findByItemId(long itemId);
}

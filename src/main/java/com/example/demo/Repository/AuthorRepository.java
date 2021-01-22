package com.example.demo.Repository;

import com.example.demo.Entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, Integer> {
    Author findUserById(int i);
}

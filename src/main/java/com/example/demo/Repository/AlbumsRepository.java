package com.example.demo.Repository;

import com.example.demo.Entity.Albums;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsRepository extends MongoRepository<Albums, Integer> {
}

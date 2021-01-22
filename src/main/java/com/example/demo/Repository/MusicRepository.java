package com.example.demo.Repository;

import com.example.demo.Entity.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music, Integer> {
    List<Music> findMusicById(int i);
}
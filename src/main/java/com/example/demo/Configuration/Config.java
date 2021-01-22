package com.example.demo.Configuration;

import com.example.demo.Entity.*;
import com.example.demo.Repository.AlbumsRepository;
import com.example.demo.Repository.AuthorRepository;
import com.example.demo.Repository.MusicRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@AllArgsConstructor
@Data
@Configuration
public class Config {
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final MusicRepository musicRepository;
    private final AlbumsRepository albumsRepository;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return (args) -> {
            users().forEach(userRepository::save);
            author().forEach(authorRepository::save);
            music().forEach(musicRepository::save);
            albums().forEach(albumsRepository::save);
        };
    }

    private List<Albums> albums() {
        return List.of(
                Albums.builder().id(1).title("На лету")
                        .years(2017)
                        .action(Action.PLAY)
                        .author(authorRepository.findUserById(1))
                        .music(musicRepository.findMusicById(1))
                        .build()
        );
    }

    private List<Music> music() {
        return List.of(
                Music.builder().id(1).name("На лету")
                .source("https://youtu.be/7QhRPZ5tkLA")
                .build()
        );
    }

    private List<Author> author() {
        return List.of(
                Author.builder().id(1).user(userRepository.findUserById(1)).build()
        );
    }

    private List<User> users() {
        return List.of(
                User.builder().id(1).username("Dean")
                .email("daniyar@gmail.com")
                .password("Dan")
                .build()
        );
    }
}

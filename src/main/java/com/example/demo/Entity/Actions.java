package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "actions")
public class Actions {
    @Id
    private Integer id;

    @DBRef
    private User user;

    @DBRef
    private Albums albums;
    private Music music;

    private LocalDateTime localDateTime;
}
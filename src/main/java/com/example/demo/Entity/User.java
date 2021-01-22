package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Document(collection = "users")
public class User {

    @Id
    private Integer id;
    @Indexed // для поиска по учетному имени
    private String username;
    @Indexed // для поиска по электронной почте
    private String email;

    private String password;

    @DBRef
    private List<Albums> albums = new ArrayList<>();

}

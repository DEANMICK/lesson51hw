package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "albums")
public class Albums {
    @Id
    private Integer id;

    @Indexed // для поиска по названию
    private String title;

    @Indexed // для поиска по году выпуска
    private Integer years;

    private Action action;

    @Indexed // для поиска по имени автора
    @DBRef
    private Author author;

    @DBRef
    private List<Music> music = new ArrayList<>();
}

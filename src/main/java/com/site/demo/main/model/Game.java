package com.site.demo.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Game {
    @Id
    private Long id;
    private String name;
    private String description;
    private String titleImagePath;
    //TODO add the field for screenshots paths
}

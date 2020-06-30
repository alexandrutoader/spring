package com.siit.spring.domain.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Singer {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private List<Album> albums;
}

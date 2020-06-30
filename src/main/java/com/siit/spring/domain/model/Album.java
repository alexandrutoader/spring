package com.siit.spring.domain.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Album {

    private long id;

    private String title;

    private LocalDate releaseDate;

    private Singer singer;
}

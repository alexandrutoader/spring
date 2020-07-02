package com.siit.spring.controller;

import com.siit.spring.domain.model.Album;
import com.siit.spring.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new album.")
    public Album create(@RequestBody Album album) {
        return service.create(album);
    }
}

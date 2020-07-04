package com.siit.spring.controller;

import com.siit.spring.domain.model.Album;
import com.siit.spring.exception.AlbumNotFoundException;
import com.siit.spring.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getOneAlbum(@PathVariable("id") long id) {

        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbums() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album create(@RequestBody Album album) {
        return service.create(album);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody Album album) {
        album.setId(id);
        service.updateTransactional(album);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @ExceptionHandler(AlbumNotFoundException.class)
    public void notFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}

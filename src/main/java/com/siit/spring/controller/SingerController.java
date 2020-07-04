package com.siit.spring.controller;

import com.ApplicationProperties;
import com.siit.spring.domain.model.Singer;
import com.siit.spring.exception.SingerNotFoundException;
import com.siit.spring.repository.SingerRepository;
import com.siit.spring.service.SingerService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/singers")
@AllArgsConstructor
public class SingerController {

    private final SingerService service;

    private final ApplicationProperties properties;

    @Value("com.siit.studentNames")
    private List<String> studentNames;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Singer getOneSinger(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Singer> getAllSingerrs() {
        System.out.println("The number of students: " + properties.getNumberOfStudents());
        System.out.println("The names of students: " + studentNames);
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Singer create(@RequestBody Singer singer) {
        return service.create(singer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody Singer singer) {
        singer.setId(id);
        service.updateTransactional(singer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @ExceptionHandler(SingerNotFoundException.class)
    public void notFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}

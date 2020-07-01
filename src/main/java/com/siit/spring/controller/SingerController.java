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

    //constructor injection
    private final SingerService service;

    private final ApplicationProperties properties;

    @Value("com.siit.studentNames")
    private List<String> studentNames;

    @GetMapping("/{id}") //    /singers/10
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get singer by id.")
    public Singer getOneSinger(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping //    /singers
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all singers.")
    public List<Singer> getAllSingerrs(Model model) {
        System.out.println("The number of students: " + properties.getNumberOfStudents());
        System.out.println("The names of students: " + studentNames);
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new singer.")
    public Singer create(@RequestBody Singer singer) {
        return service.create(singer);
    }
    //{id:12,
    // firstName: "sjansjan",}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Update singer by id.")
    public void update(@PathVariable("id") long id, @RequestBody Singer singer) {
        singer.setId(id);
        service.updateTransactional(singer);
    }

    @ExceptionHandler(SingerNotFoundException.class)
    public void notFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete singer by id.")
    public void delete(@PathVariable("id") long id) {
        Singer singer = service.findById(id);
        service.delete(singer);
    }
}

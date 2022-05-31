package com.example.movie.controllers;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }
    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        movieService.addMovie(movie);
         return ResponseEntity.status(201).body("Movie added!");
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateMovie(@RequestBody @Valid Movie movie, @PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        movieService.updateMovie(movie,id);
        return ResponseEntity.status(200).body("Movie updated!");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteMovie(@PathVariable @Valid Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!");
    }
}

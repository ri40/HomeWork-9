package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repostory.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;



    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }
    public void updateMovie(Movie movie, Integer id) {
        Movie oldMovie = movieRepository.findById(id).get();
        oldMovie.setId(movie.getId());
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setLaunchDate(movie.getLaunchDate());
        movieRepository.save(oldMovie);
    }
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

}

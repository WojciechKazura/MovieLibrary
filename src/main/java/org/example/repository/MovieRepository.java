package org.example.repository;

import org.example.exception.ServiceException;
import org.example.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();

    int getAllMoviesOf(String genre);

    void addMovie(Movie movie)throws ServiceException;

    void addMovies(List<Movie> movieList);

}

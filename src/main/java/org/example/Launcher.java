package org.example;

import org.example.controller.ConsoleController;
import org.example.model.Movie;
import org.example.repository.MovieMySqlRepository;
import org.example.repository.MovieRepository;

import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        ///MovieRepository movieRepository = new MovieMySqlRepository();

        ConsoleController controller = new ConsoleController();
        controller.startAppMenu();


        // List<Movie> movies = movieRepository.getAllMovies();
        // for (Movie movie : movies) {
        //   System.out.println(movie);
        //  }
        // System.out.println("Filmów z gatunku SF jest: " + movieRepository.getAllMoviesOf("sf"));

        //movieRepository.addMovie(movie);
        // movieRepository.getAllMovies();
        //  movieRepository.getAllMoviesOf("sf");
        // System.out.println("Filmów z gatunku SF jest: " + movieRepository.getAllMoviesOf("sf"));




    }
}

//|launchar|controller|service|repository|model|
//|rozruch|sterowanie|logika|repozytoria|dane|
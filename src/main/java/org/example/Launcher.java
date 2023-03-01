package org.example;

import org.example.controller.ConsoleController;
import org.example.controller.GUIController;

public class Launcher {
    public static void main(String[] args) {
        ///MovieRepository movieRepository = new MovieJDBCRepository();


        if(args.length==0||args[0].equals("GUI")){
            GUIController controller=new GUIController();
            controller.startAppMenu();
        }else{
            ConsoleController controller= new ConsoleController();
            controller.startAppMenu();
        }


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
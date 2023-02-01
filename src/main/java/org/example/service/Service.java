package org.example.service;

import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.repository.MovieMySqlRepository;

public class Service {
    private MovieMySqlRepository movieMySqlRepository = new MovieMySqlRepository();

    public void addMovie(Movie movie) throws ServiceException{
        cheMovie(movie);
        movieMySqlRepository.addMovie(movie);
    }

    public void cheMovie(Movie movie) throws ServiceException {
        if (movie.getTitle().equals("")) {
            throw new ServiceException("Brak tytułu");
        } else if (movie.getGenre().equals("")) {
            throw new ServiceException("Brak gatunku");
        } else if (movie.getYear() == 0) {
            throw new ServiceException("Brak roku");
        } else if (movie.getYear() < 1800 || movie.getYear() > 2100) {
            throw new ServiceException("Nieprawidóowy zakres dat.");
        }
    }

   /* public int cheMovie(Movie movie) {
        if (movie.getTitle().equals("")) {
            return 1;
        } else if (movie.getGenre().equals("")) {
            return 2;
        } else if (movie.getYear() == 0) {
            return 3;
        } else if (movie.getYear() < 1800 || movie.getYear() > 2100) {
            return 4;
        } else return 0;
    }*/

    //jeśli uzytkownik wprowadzi dane nowego filmu musimy:
    //-upewnić się, że id jest wolne
    //-upewnić się, że tytuł, gatunek i rok, są uzupełnione
    //-upewnić się, że rok jest podany poprawnie (1800-2100)
}


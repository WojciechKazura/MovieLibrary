package org.example.repository;

import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.repository.MovieRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieMySqlRepository implements MovieRepository {
    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Lugakim99!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select*from movies;");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String genre = resultSet.getString(3);
                int year = resultSet.getInt(4);
                Movie movie = new Movie(id, title, genre, year);
                movieList.add(movie);
            }
        } catch (SQLException e) {
            System.out.println("wystapił błąd!");
        }
        return movieList;
    }

    @Override
    public int getAllMoviesOf(String genre) {
        int howManyMoviesHaveThatGenre = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Lugakim99!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select*from movies;");
            while (resultSet.next()) {
                String movieGenre = resultSet.getString(3);
                if (movieGenre.equals(genre)) {
                    howManyMoviesHaveThatGenre++;
                }
            }
        } catch (SQLException e) {
            System.out.println("wystapił błąd!");
        }
        return howManyMoviesHaveThatGenre;
    }

    @Override
    public void addMovie(Movie movie) throws ServiceException{
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Lugakim99!");
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement= connection.prepareStatement("insert into movies values (?,?,?,?);");
            int id = movie.getId();
            String title= movie.getTitle();
            String genre= movie.getGenre();
            int year=movie.getYear();
           // statement.execute("insert into movies values ("+id+",'"+title+"','"+genre+"',"+year+");");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,genre);
            preparedStatement.setInt(4,year);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ServiceException("Wystąpił błąd w połączeniu SQL");
        }
    }

    @Override
    public void addMovies(List<Movie> movieList) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Lugakim99!");
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into movies values (?,?,?,?);");
            for(Movie movie:movieList){
                int id = movie.getId();
                String title= movie.getTitle();
                String genre= movie.getGenre();
                int year=movie.getYear();
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,title);
                preparedStatement.setString(3,genre);
                preparedStatement.setInt(4,year);
                preparedStatement.execute();
            }
        }catch (SQLException e) {
            System.out.println("wystapił błąd!");
        }
    }


}

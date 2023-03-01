package org.example.repository;

import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class MovieHibernateRepository implements MovieRepository {

    private SessionFactory sessionFactory;

    public MovieHibernateRepository() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Movie.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public List<Movie> getAllMovies() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Movie> query = session.createQuery("from Movie", Movie.class);
        List<Movie> movieList = query.getResultList();
        transaction.commit();
        session.close();

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
    public void addMovie(Movie movie) throws ServiceException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movie);
        transaction.commit();
        session.close();
    }

    @Override
    public void addMovies(List<Movie> movieList) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "Lugakim99!");
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into movies values (?,?,?,?);");
            for (Movie movie : movieList) {
                int id = movie.getId();
                String title = movie.getTitle();
                String genre = movie.getGenre();
                int year = movie.getYear();
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, genre);
                preparedStatement.setInt(4, year);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println("wystapił błąd!");
        }
    }


}

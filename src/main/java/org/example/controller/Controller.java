package org.example.controller;

import org.example.exception.CloseAppException;
import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.service.Service;

import javax.swing.*;

public abstract class Controller {

    private Service service = new Service();

    public void startAppMenu(){
        try{
            addMovie();
        }catch (CloseAppException e ){
            showMessage(e.getMessage());
        };

    }

    public void addMovie() throws CloseAppException {
        int id = readInt("Podaj id.");
        String title = readString("Podaj tytuł");
        String genre = readString("Podaj gatunek");
        int year = readInt("Podaj rok.");
        Movie movie = new Movie(id, title, genre, year);
        try{
            service.addMovie(movie);
            showMessage("Zapisano film "+movie);
        }catch (ServiceException e){
            showMessage(e.getMessage());
        }
    }

   abstract void showMessage(String message);
   abstract String readString(String question) throws CloseAppException;
   abstract int readInt(String question) throws CloseAppException;



}

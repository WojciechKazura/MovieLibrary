package org.example.controller;

import org.example.exception.CloseAppException;
import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.service.Service;

import javax.swing.*;
import java.util.InputMismatchException;

public class GUIController {
    private Service service = new Service();

    public void startAppMenu(){
        try{
            addMovie();
        }catch (CloseAppException e ){
            JOptionPane.showMessageDialog(null,e.getMessage());
        };

    }

    public void addMovie() throws CloseAppException {
        int id = readInt("Podaj id.");
        String title = readString("podaj tytuł");
        String genre = readString("podaj gatunek");
        int year = readInt("Podaj rok.");
        Movie movie = new Movie(id, title, genre, year);
        try{
            service.addMovie(movie);
            JOptionPane.showMessageDialog(null, "Zapisano " + movie);
        }catch (ServiceException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private String readString(String question) throws CloseAppException {
        String input= JOptionPane.showInputDialog(question);
        if(input==null){
            throw new CloseAppException("Aplikacja zamknięta");
        }
        return input;
    }

    private int readInt(String question) throws CloseAppException {
        try {
            return Integer.parseInt(readString(question));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nieprawodłowa wartość, spróbuj ponownie.");
            return readInt(question);
        }
    }


}

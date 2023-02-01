package org.example.controller;

import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleController {
    private Service service = new Service();
    private Scanner scanner = new Scanner(System.in);

    void hello() {
        System.out.println("Witaj urzytkowniku");
    }

    void menu() {
        System.out.println("Wybierz opcje:");

    }


    void start() {

    }

    public void addMovie() {
        System.out.println("podaj id");
        int id = scannerInt();
        System.out.println("podaj tytuł");
        String title = scannerString();
        System.out.println("podaj gatunek");
        String genre = scannerString();
        System.out.println("podaj rok");
        int year = scannerInt();
        Movie movie = new Movie(id, title, genre, year);
        System.out.println("twój film to " + movie);
        try{
            service.addMovie(movie);
            System.out.println("Zapisano "+movie);
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }

    }

    private String scannerString() {
        return scanner.nextLine();
    }

    private int scannerInt() {
        try {
            int a = scanner.nextInt();
            scanner.nextLine();
            return a;
        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowa wartość.");
            System.out.println("spróbuj ponownie.");
            scanner.nextLine();
            return scannerInt();
        }
    }


}

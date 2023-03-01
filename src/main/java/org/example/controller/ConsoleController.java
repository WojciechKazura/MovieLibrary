package org.example.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleController extends Controller{

    private Scanner scanner = new Scanner(System.in);

    @Override
    void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    String readString(String question) {
        showMessage(question);
        return scanner.nextLine();
    }

    @Override
    int readInt(String question) {
        try {
            showMessage(question);
            int a = scanner.nextInt();
            scanner.nextLine();
            return a;
        } catch (InputMismatchException e) {
            showMessage("Nieprawidłowa wartość.");
            showMessage("spróbuj ponownie.");
            scanner.nextLine();
            return readInt(question);
        }
    }
}

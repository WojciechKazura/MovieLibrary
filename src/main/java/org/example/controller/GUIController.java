package org.example.controller;

import org.example.exception.CloseAppException;
import org.example.exception.ServiceException;
import org.example.model.Movie;
import org.example.service.Service;

import javax.swing.*;
import java.util.InputMismatchException;

public class GUIController extends Controller {

    public  void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }
     String readString(String question) throws CloseAppException {
        String input= JOptionPane.showInputDialog(question);
        if(input==null){
            throw new CloseAppException("Aplikacja zamknięta");
        }
        return input;
    }

    int readInt(String question) throws CloseAppException {
        try {
            return Integer.parseInt(readString(question));
        } catch (NumberFormatException e) {
            showMessage("Nieprawodłowa wartość, spróbuj ponownie.");
            return readInt(question);
        }
    }


}

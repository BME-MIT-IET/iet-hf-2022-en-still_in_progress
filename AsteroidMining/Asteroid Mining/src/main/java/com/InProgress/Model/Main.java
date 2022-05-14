package main.java.com.InProgress.Model;

import main.java.com.InProgress.GUI.StartWindow;

/**
 * Entry point of the application.
 * Creates the first start window.
 * @author InProgress
 */
public class Main {

    public static void main(String[] args) {

        StartWindow startWindow = new StartWindow();
        startWindow.initialize();
    }
}


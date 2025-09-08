package org.example;
import java.util.Scanner;

public class SerieMenuApp {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series seriesMenuApp = new Series(); // Object that handles all series-related actions

        // Outer loop: gives the option to start the menu or exit the whole program
        while (true) {
            System.out.println("\nLATEST SERIES - 2025");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String option = scanner.nextLine();

            // If the user doesn't enter "1", we quit the application completely
            if (!option.equals("1")) {
                System.out.println("Application closed.");
                break;
            }

            // Inner loop: runs the actual menu until the user decides to stop
            while (true) {
                System.out.println("\nPlease select one of the following menu items");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series age restriction.");
                System.out.println("(4) Delete series.");
                System.out.println("(5) Print series report - 2025.");
                System.out.println("(6) Exit Application.");
                System.out.print("Select menu item: ");

                String choice = scanner.nextLine();

                // Handles the menu options by calling methods from the Series class
                switch (choice) {
                    case "1":
                        seriesMenuApp.CaptureSeries();
                        break;
                    case "2":
                        seriesMenuApp.SearchSeries();
                        break;
                    case "3":
                        seriesMenuApp.UpdateSeries();
                        break;
                    case "4":
                        seriesMenuApp.DeleteSeries();
                        break;
                    case "5":
                        seriesMenuApp.SeriesReport();
                        break;
                    case "6":
                        seriesMenuApp.ExitSeriesApplication();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
                // After finishing an action, ask the user if they want to relaunch the menu
                System.out.print("Enter (1) to launch menu or any other key to exit: ");
                String repeat = scanner.nextLine();
                // Small bug here: you're checking "option" again instead of "repeat"
                if (!repeat.equals("1")) {
                    System.out.println("Application closed.");
                    return; // exits the program
                }
            }
        }
    }
}

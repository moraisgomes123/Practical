package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    // Stores all series objects in memory (like a small database)
    static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // --- Capture a new series and add it to the list ---
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");

        // Ask for series details
        System.out.println("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.println("Enter the series name: ");
        String name = scanner.nextLine();

        // Validate the age restriction until the input is correct
        String age;
        while (true) {
            System.out.println("Enter the series age restriction: ");
            age = scanner.nextLine();
            if (isValidAge(age))
                break;
            System.out.println("You have entered an incorrect series age.");
            System.out.println("Please re-enter the series age.");
        }

        System.out.println("Enter the number of episodes for " + name + ":");
        String episodes = scanner.nextLine();

        // Create the new SeriesModel and store it in the list
        SeriesModel series = new SeriesModel(id, name, age, episodes);
        seriesList.add(series);
        System.out.println("Series processed successfully!");
    }

    // --- Search for a series by ID ---
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        SeriesModel found = findSeriesById(id);

        if (found != null) {
            printSeries(found);
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // --- Update an existing series ---
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        SeriesModel found = findSeriesById(id);

        if (found != null) {
            // Update name
            System.out.print("Enter the series name: ");
            found.SeriesName = scanner.nextLine();

            // Update age restriction with validation
            String age;
            while (true) {
                System.out.print("Enter the age restriction: ");
                age = scanner.nextLine();
                if (isValidAge(age))
                    break;
                System.out.println("You have entered an incorrect series age!");
                System.out.println("Please re-enter the series age.");
            }
            found.SeriesAge = age;

            // Update episodes
            System.out.println("Enter the number of episodes: ");
            found.SeriesNumberOfEpisodes = scanner.nextLine();

        } else {
            // It should probably just say "Series not found!" instead.
            System.out.print("Enter the number of episodes: ");
            found.SeriesNumberOfEpisodes = scanner.nextLine();
        }
    }

    // --- Delete a series by ID ---
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        SeriesModel found = findSeriesById(id);

        if (found != null) {
            System.out.println("Are you sure you want to delete series " + id + " from the system? yes(y) to delete.");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                seriesList.remove(found);
                System.out.println("Series with Series id " + id + " was deleted!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Series id: " + id + " was not found!");
        }
    }

    // --- Print all series stored in the list ---
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series to display.");
            return;
        }

        int count = 1;
        for (SeriesModel series : seriesList) {
            System.out.println("Series " + count++);
            printSeries(series);
            System.out.println();
        }
    }

    // --- Exit the application completely ---
    public void ExitSeriesApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    // --- Helper: checks if age restriction is valid (must be between 3 and 18) ---
    private boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age > 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // --- Helper: find a series in the list by ID ---
    private SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) return s;
        }
        return null;
    }

    // --- Helper: print a series nicely ---
    private void printSeries(SeriesModel s) {
        System.out.println("SERIES ID: " + s.SeriesId);
        System.out.println("SERIES NAME: " + s.SeriesName);
        System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
        System.out.println("SERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
    }
}

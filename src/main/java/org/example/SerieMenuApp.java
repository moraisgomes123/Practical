package org.example;
import java.util.Scanner;

public  class SerieMenuApp{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Series seriesMenuApp = new Series();


        while (true){
            System.out.println("\nLATEST SERIES - 2025");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String option = scanner.nextLine();

            if (!option.equals("1")){
                System.out.println("Application closed.");
                break;
            }
            while (true){
                System.out.println("\nPlease select one of the following menu item");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for  series.");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application.");
                System.out.println("Select menu item: ");

                String choice = scanner.nextLine();

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

                System.out.print("Enter (1) to launch menu or any other key to exit: ");
                String repeat = scanner.nextLine();
                if (!option.equals("1")){
                    System.out.println("Application closed.");
                    return;
                }
            }
        }
    }
}

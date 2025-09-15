
package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    private Series series;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;
    
    @BeforeEach
    void setUp() {
        series = new Series();
        Series.seriesList.clear();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Series.scanner = new java.util.Scanner(System.in); 
    }
    @Test
    void searchSeries() {
        Series.seriesList.add(new SeriesModel("101", "Wild Adventure", "10", "5"));
        simulateInput("101\n");

        series.SearchSeries();

        String output = outContent.toString();
        assertTrue(output.contains("SERIES ID: 101"));
        assertTrue(output.contains("Wild Adventure"));
    }
    @Test
    void TestSearchSeries_SeriesNotFound() {
        simulateInput("999\n");
        series.SearchSeries();

        String output = outContent.toString();
        assertTrue(output.contains("not found")); 
    }
    @Test
    void updateSeries() {
        Series.seriesList.add(new SeriesModel("202", "Old Name", "12", "4"));
        simulateInput("202\nNew Name\n10\n6\n");

        series.UpdateSeries();

        SeriesModel updated = Series.seriesList.get(0);
        assertEquals("New Name", updated.SeriesName);
        assertEquals("10", updated.SeriesAge);
        assertEquals("6", updated.SeriesNumberOfEpisodes);
    }

    @Test
    void deleteSeries() {
        Series.seriesList.add(new SeriesModel("303", "To Delete", "14", "7"));
        simulateInput("303\ny\n");

        series.DeleteSeries();

        assertTrue(Series.seriesList.isEmpty());
        assertFalse(outContent.toString().contains("WAS deleted!"));
    }
    @Test
    void TestDeleteSeries_SeriesNotFound() {
        simulateInput("888\n");

        series.DeleteSeries();

        String output = outContent.toString();
        assertTrue(output.contains("not found"));
    }
    @Test
    void seriesReport() {
        Series.seriesList.add(new SeriesModel("401", "Cooking Show", "10", "8"));
        Series.seriesList.add(new SeriesModel("402", "Drama Club", "12", "10"));

        series.SeriesReport();

        String output = outContent.toString();
        assertTrue(output.contains("Series 1"));
        assertTrue(output.contains("Cooking Show"));
        assertTrue(output.contains("Series 2"));
        assertTrue(output.contains("Drama Club"));
    }
    @Test
    void exitSeriesApplication() {
        assertDoesNotThrow(() -> {
            assertNotNull(series.getClass().getMethod("ExitSeriesApplication"));
        });
    }
}

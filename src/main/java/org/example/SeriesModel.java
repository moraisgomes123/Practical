package org.example;
import java.util.Scanner;

public class SeriesModel{
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
        // Getters
        public String getSeriesId(){
            return SeriesId;
        }
        public String getSeriesName(){
            return SeriesName;
        }
        public String getSeriesAge(){
            return SeriesAge;
        }
        public String getSeriesNumberOfEpisodes(){
            return SeriesNumberOfEpisodes;
        }
    }

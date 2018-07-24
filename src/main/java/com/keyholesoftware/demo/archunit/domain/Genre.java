package com.keyholesoftware.demo.archunit.domain;

import java.util.HashMap;
import java.util.Map;

public enum Genre {

    ARTS("ARTS", "Arts & Photography"),
    CHILDREN("CHILDREN", "Children's Books"),
    COMICS("COMICS", "Comics & Graphic Novels"),
    EDUCATION("EDUCATION", "Education & Teaching"),
    ENGINEERING("ENGINEERING", "Engineering & Transportation"),
    HEALTH("HEALTH", "Health, Fitness & Dieting"),
    HISTORY("HISTORY", "History"),
    HOBBIES("HOBBIES", "Crafts, Hobbies & Home"),
    LAW("LAW", "Law"),
    LITERATURE("LITERATURE", "Literature & Fiction"),
    MYSTERIES("MYSTERIES", "Mystery, Thriller & Suspense"),
    POLITICS("POLITICS", "Politics & Social Sciences"),
    ROMANCE("RROMANCE", "Romance"),
    SCIENCE("SCIENCE", "Science & Math"),
    SCIENCEFICTION("SCIENCEFICTION", "Science Fiction & Fantasy"),
    SELFHELP("SELFHELP","Self-Help"),
    SPORTS("SPORTS", "Sports & Outdoors"),
    TRAVEL("TRAVEL", "Travel"); 

    private static Map<String, String> genreDescriptionByGenre = new HashMap<String, String>();
    private String genre;
    private String genreDescription;
    
    Genre(String genre) {
        this.genre = genre;
        this.genreDescription = getGenreDescriptionByValue(genre);
    }
    
    Genre(String genre, String genreDescription) {
        this.genre = genre;
        this.genreDescription = genreDescription;
    }


    public String getGenreDescription() {
        return genreDescription;
    }

    public String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }
    
    private String getGenreDescriptionByValue(String genre) {
        return genreDescriptionByGenre.get(genre);
    }
    
}

package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Director {
    private String name;
    private int numberOfMovies;
    private double imbdRating;

    public Director() {
    }

    public Director(String name, int numberOfMovies, double imbdRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imbdRating = imbdRating;
    }
}

package com.driver;

import java.util.*;

public class MovieRepository {

    private Map<String, Movie> movieData = new HashMap<>();
    private Map<String, Director> directorData = new HashMap<>();
    private Map<String, List<String>> movieDirectorPair = new HashMap<>();//director-movies

    public void addMovie(Movie movie){
        movieData.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorData.put(director.getName(), director);
    }

    public Optional<Movie> getByMovieName(String movie) {
        if(movieData.containsKey(movie)){
            return Optional.of(movieData.get(movie));
        }
        return Optional.empty();
    }
    public Optional<Director> getDirectorByName(String director) {
        if(directorData.containsKey(director)){
            return Optional.of(directorData.get(director));
        }
        return Optional.empty();
    }

    public List<String> getAllMovies(){
        return new ArrayList<>(movieData.keySet());
    }
    public List<String> getAllDirector(){
        return new ArrayList<>(directorData.keySet());
    }

    public void addMovieDirectorPair(String movie, String director){
        if(!movieDirectorPair.containsKey(director)){
            movieDirectorPair.put(director,new ArrayList<>());
        }
        List<String> movies = movieDirectorPair.get(director);
        movies.add(movie);
        movieDirectorPair.put(director,movies);
    }

    public List<String> getMoviesByDirectorName(String director) throws DirectorNotFoundException {
        return movieDirectorPair.get(director);
    }
    public void deleteDirectorByName(String director){
        directorData.remove(director);
        movieDirectorPair.remove(director);
    }
    public void deleteMovieByName(String movie){
        movieData.remove(movie);
    }
}

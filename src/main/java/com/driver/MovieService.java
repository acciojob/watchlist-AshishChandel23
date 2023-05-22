package com.driver;

import java.util.List;
import java.util.Optional;

public class MovieService {
    private MovieRepository repository = new MovieRepository();

    public void addMovie(Movie movie){
        repository.addMovie(movie);
    }
    public void addDirector(Director director){
        repository.addDirector(director);
    }

    public Movie getMovieByName(String movie) throws MovieNotFoundException {
        Optional<Movie> optionalMovie = repository.getByMovieName(movie);
        if(optionalMovie.isEmpty()){
            throw new MovieNotFoundException("Movie Not Found in DB");
        }
        return optionalMovie.get();
    }
    public Director getDirectorByName(String director) throws DirectorNotFoundException {
        Optional<Director> optionalDirector = repository.getDirectorByName(director);
        if(optionalDirector.isEmpty()){
            throw new DirectorNotFoundException("Director Not Found in DB");
        }
        return optionalDirector.get();
    }
    public List<String> getAllMovies() {
        return repository.getAllMovies();
    }

    public void addMovieDirectorPair(String movie, String director) throws MovieNotFoundException, DirectorNotFoundException {
        Optional<Movie> optionalMovie = repository.getByMovieName(movie);
        Optional<Director> optionalDirector = repository.getDirectorByName(director);
        if(optionalMovie.isEmpty()){
            throw new MovieNotFoundException("Movie Not Found in DB");
        }
        if(optionalDirector.isEmpty()){
            throw new DirectorNotFoundException("Director Not Found in DB");
        }
        Director director1 = optionalDirector.get();
        director1.setNumberOfMovies(director1.getNumberOfMovies()+1);
        repository.addDirector(director1);
        repository.addMovieDirectorPair(movie,director);
    }

    public List<String> getMoviesByDirectorName(String director)throws DirectorNotFoundException {
        Optional<Director> optionalDirector = repository.getDirectorByName(director);
        if(optionalDirector.isEmpty()){
            throw new DirectorNotFoundException("Director Not Found in DB");
        }
        return repository.getMoviesByDirectorName(director);
    }

    public void deleteDirectorByName(String director) {
        List<String> movies = getMoviesByDirectorName(director);
        for(String m : movies){
            repository.deleteMovieByName(m);
        }
        repository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        List<String> directors = repository.getAllDirector();
        for(String d : directors){
            deleteDirectorByName(d);
        }
    }
}

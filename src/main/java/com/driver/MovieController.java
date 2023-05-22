package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService service = new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        service.addMovie(movie);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.OK);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        service.addDirector(director);
        return new ResponseEntity<>("Director added successfully", HttpStatus.OK);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        service.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Director-Movie Pair added successfully",HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name/{movie}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){
        Movie getMovie = service.getMovieByName(movie);
        return new ResponseEntity<>(getMovie,HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{director}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director){
        Director getDirector = service.getDirectorByName(director);
        return new ResponseEntity<>(getDirector,HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = service.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies(){
        List<String> movies = service.getAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        service.deleteDirectorByName(director);
        return new ResponseEntity<>("Director deleted successfully", HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        service.deleteAllDirectors();
        return new ResponseEntity<>("All Directors deleted successfully", HttpStatus.OK);
    }

}

package com.example.movie;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();
    int uniqMovieId = 6;

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    @Override
    public ArrayList<Movie> getMovies() {
        Collection<Movie> movieCollection = movieList.values();
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        if (movieList.get(movieId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movieList.get(movieId);
    }

    @Override
    public Movie addMovie(Movie movieObj) {
        movieObj.setMovieId(uniqMovieId);
        movieList.put(uniqMovieId, movieObj);
        uniqMovieId += 1;
        return movieObj;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movieObj) {
        Movie existingMovie = movieList.get(movieId);

        if (existingMovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (movieObj.getMovieName() != null) {
            existingMovie.setMovieName(movieObj.getMovieName());
        }

        if (movieObj.getLeadActor() != null) {
            existingMovie.setLeadActor(movieObj.getLeadActor());
        }

        return existingMovie;
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie movieObj = movieList.get(movieId);
        if (movieObj == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}

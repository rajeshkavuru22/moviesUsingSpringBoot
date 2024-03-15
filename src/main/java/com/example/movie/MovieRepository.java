package com.example.movie;

import java.util.*;
import com.example.movie.Movie;

public interface MovieRepository {
    ArrayList<Movie> getMovies();

    Movie getMovieById(int movieId);

    Movie addMovie(Movie movieObj);

    Movie updateMovie(int movieId, Movie movieObj);

    void deleteMovie(int movieId);

}
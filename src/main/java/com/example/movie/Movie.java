package com.example.movie;

public class Movie {
    private int movieId;
    private String movieName;
    private String leadActor;

    public Movie(int movieId, String movieName, String leadActor) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    public void setMovieId(int id) {
        this.movieId = id;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public void setMovieName(String name) {
        this.movieName = name;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setLeadActor(String actor) {
        this.leadActor = actor;
    }

    public String getLeadActor() {
        return this.leadActor;
    }

}
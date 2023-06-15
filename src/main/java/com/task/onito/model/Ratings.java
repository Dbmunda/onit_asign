package com.task.onito.model;

import jakarta.persistence.*;

@Entity
@Table(name="ratings")
public class Ratings {

    @Id
    @Column(name = "tconst")
    private String tConst;

    @Column(name = "averageRating")
    private double averageRating;

    @Column(name = "numVotes")
    private int numVotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst")
    private Movies movie;

    public String gettConst() {
        return tConst;
    }

    public void settConst(String tConst) {
        this.tConst = tConst;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

}

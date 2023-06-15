package com.task.onito.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="movies")
public class Movies {

    @Id
    @Column(name="tconst")
    private String tConst;

    @Column(name="titleType")
    private String titleType;

    @Column(name="primaryTitle")
    private String primaryTitle;

    @Column(name = "runtimeMinutes")
    private Long runtimeMinutes;

    @Column(name = "genres")
    private String genres;

//    @OneToOne
//    @JoinColumn(name = "rating_id")
//    private Ratings ratings;
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Ratings ratings;

    public Movies (){
        super();
    }
    public Movies(String tConst, String titleType, String primaryTitle, Long runtimeMinutes, String genres) {
        this.tConst = tConst;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.runtimeMinutes = runtimeMinutes;
        this.genres = genres;
    }

    public String gettConst() {
        return tConst;
    }

    public void settConst(String tConst) {
        this.tConst = tConst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public Long getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Long runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }


}

package com.task.onito.to;

public class MovieTO2 {
    private String tconst;
    private String primaryTitle;
    private String genre;
    private Long runtimeMinutes;
    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(Long runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }
}

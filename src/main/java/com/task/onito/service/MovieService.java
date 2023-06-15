package com.task.onito.service;

import com.task.onito.model.Movies;
import com.task.onito.to.MovieTO;
import com.task.onito.to.MovieTO2;

import java.util.List;

public interface MovieService {
   List<MovieTO2> getLongestDurationMovies();

   Movies SaveMovies(Movies movies);

   List<MovieTO> getTopRatedMovies();
}

package com.task.onito.controller;

import com.task.onito.model.Movies;
import com.task.onito.service.MovieService;
import com.task.onito.to.MovieTO;
import com.task.onito.to.MovieTO2;
import com.task.onito.utlity.CommonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    Logger _Logger = Logger.getLogger(MovieController.class.getName());

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/longest-duration-movies")
    public ResponseEntity<List<MovieTO2>> getLongestDurationMovies() throws Exception{
        List<MovieTO2> longestDurationMovies =null;
        try{
            longestDurationMovies= movieService.getLongestDurationMovies();
            if(!CommonUtil.isNullOrEmpty(longestDurationMovies) ){
                return ResponseEntity.ok(longestDurationMovies);
            }
            return null;
        }catch (Exception e){
            throw e;
        }
    }
    @PostMapping("/new-movie")
    public ResponseEntity<String> addNewMovie(@RequestBody Movies movies) throws Exception{
        try{
            Movies savedMovie = movieService.SaveMovies(movies);
            if(CommonUtil.isNullOrEmpty(savedMovie)){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("success");
        }catch (Exception e){
            throw e;
        }
    }

    @RequestMapping("/top-rated-movies")
    public ResponseEntity<List<MovieTO>> getTopRatedMovies() throws Exception{
        try{
            List<MovieTO> topRatedMovies = movieService.getTopRatedMovies();
            if(!CommonUtil.isNullOrEmpty(topRatedMovies)){
                return ResponseEntity.ok(topRatedMovies);
            }
            return null;
        }catch (Exception e){
            throw e;
        }
    }
}

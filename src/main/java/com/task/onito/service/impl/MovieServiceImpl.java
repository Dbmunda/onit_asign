package com.task.onito.service.impl;

import com.task.onito.dao.MovieRepository;
import com.task.onito.model.Movies;
import com.task.onito.model.Ratings;
import com.task.onito.service.MovieService;
import com.task.onito.to.MovieTO;
import com.task.onito.to.MovieTO2;
import com.task.onito.utlity.CommonUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final EntityManager entityManager;

    public MovieServiceImpl(MovieRepository movieRepository, EntityManager entityManager) {
        this.movieRepository = movieRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<MovieTO2> getLongestDurationMovies() {
        List<MovieTO2> resultList= new ArrayList<>();;
        try {
            List<Object[]> results = getLongestDurationMoviesDS();
            if(!CommonUtil.isNullOrEmpty(results)) {
                for (Object[] result : results) {
                    MovieTO2 movieTO2 = new MovieTO2();
                    String tconst = (String) result[0];
                    String genre = (String) result[1];
                    String primaryTitle = (String) result[2];
                    Long runtimeMinutes = (Long) result[3];

                    movieTO2.setTconst(tconst);
                    movieTO2.setGenre(genre);
                    movieTO2.setPrimaryTitle(primaryTitle);
                    movieTO2.setRuntimeMinutes(runtimeMinutes);

                    resultList.add(movieTO2);
                }
            }
        }catch(Exception e){
           throw e;
        }
        return resultList;
    }

public List<Object[]> getLongestDurationMoviesDS(){
    List<Object[]> resultList=null;
    try {
        StringBuilder hqlQuery1 = new StringBuilder();
        hqlQuery1.append("SELECT m.tConst,m.genres, m.primaryTitle,m.runtimeMinutes  FROM Movies m ORDER BY m.runtimeMinutes DESC");
        Query query = entityManager.createQuery(hqlQuery1.toString());
        query.setMaxResults(2);
        resultList = query.getResultList();
    }catch(Exception e){
        throw e;
    }
    return resultList;
    }


    @Override
    public Movies SaveMovies(Movies movies) {
        Ratings rating = new Ratings();
        rating.settConst(movies.gettConst());
        rating.setAverageRating(movies.getRatings().getAverageRating());
        rating.setNumVotes(movies.getRatings().getNumVotes());
        rating.setMovie(movies);
        return movieRepository.save(movies);
    }

    @Override
    public List<MovieTO> getTopRatedMovies() {
        List<MovieTO> topRatedMovies = new ArrayList<>();

        try {
            List<Object[]> results = findTopRatedMovies();
            if(!CommonUtil.isNullOrEmpty(results))  {
               for (Object[] result : results) {
                   String tconst = (String) result[0];
                   String primaryTitle = (String) result[1];
                   String genre = (String) result[2];
                   Double averageRating = (Double) result[3];

                   MovieTO movieTO = new MovieTO();
                   movieTO.setTconst(tconst);
                   movieTO.setPrimaryTitle(primaryTitle);
                   movieTO.setGenre(genre);
                   movieTO.setAverageRating(averageRating);

                   topRatedMovies.add(movieTO);
               }
           }
        }catch(Exception e){
            throw  e;
        }
        return topRatedMovies;
    }
    List<Object[]> findTopRatedMovies(){
        List<Object[]> topRatedMovies = null;
        try{
             StringBuilder hqlQuery = new StringBuilder();
             hqlQuery.append("SELECT m.tConst, m.primaryTitle, m.genres, AVG(r.averageRating)");
             hqlQuery.append(" FROM Movies m ");
             hqlQuery.append(" LEFT JOIN m.ratings r ");
             hqlQuery.append("GROUP BY m.tConst, m.primaryTitle, m.genres ");
             hqlQuery.append("HAVING AVG(r.averageRating) > 6.0 ");
             hqlQuery.append("ORDER BY AVG(r.averageRating) DESC");
             Query query = entityManager.createQuery(hqlQuery.toString());
             topRatedMovies = query.getResultList();
        }catch(Exception e){
            throw e;
        }
        return topRatedMovies;
    }

}

package com.task.onito.dao;

import com.task.onito.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings,String> {
}

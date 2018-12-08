package com.projekt.strona.Service;

import com.projekt.strona.Dao.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingDao ratingDao;

    public void addRating(int ratingNumber, String ratingAuthor, String ratingTarget) {
        ratingDao.addRating(ratingNumber,ratingAuthor,ratingTarget);
    }
}

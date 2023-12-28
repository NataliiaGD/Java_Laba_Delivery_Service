package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Feedback;

import java.util.List;

public interface FeedbackRepository {
    Feedback findById(int id);

    List<Feedback> retrieveAll();

    void create(Feedback feedback);

    void updateFeedbackByComments(int id, String newComments);

    void deleteById(int id);
}

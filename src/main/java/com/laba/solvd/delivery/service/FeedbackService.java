package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback findById(int id);

    List<Feedback> retrieveAll();

    void create(Feedback feedback);

    void updateFeedbackByComments(int id, String newComments);

    void deleteById(int id);
}

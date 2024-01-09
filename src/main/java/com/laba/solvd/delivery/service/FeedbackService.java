package com.laba.solvd.delivery.service;

import com.laba.solvd.delivery.domain.Feedback;

import java.util.List;

public interface FeedbackService {

    List<Feedback> retrieveAll();

    void create(Feedback feedback);

    void deleteById(int id);
}

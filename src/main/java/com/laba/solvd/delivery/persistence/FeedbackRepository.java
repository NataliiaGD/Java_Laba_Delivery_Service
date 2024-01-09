package com.laba.solvd.delivery.persistence;

import com.laba.solvd.delivery.domain.Feedback;

import java.util.List;

public interface FeedbackRepository {

    List<Feedback> retrieveAll();

    void create(Feedback feedback);

    void deleteById(int id);
}

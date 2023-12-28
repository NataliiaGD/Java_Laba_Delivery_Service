package com.laba.solvd.delivery.service.impl;

import com.laba.solvd.delivery.domain.Feedback;
import com.laba.solvd.delivery.persistence.FeedbackRepository;
import com.laba.solvd.delivery.service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public List<Feedback> retrieveAll() {
        return null;
    }

    @Override
    public void create(Feedback feedback) {
        feedbackRepository.create(feedback);
    }

    @Override
    public void updateFeedbackByComments(int id, String newComments) {

    }

    @Override
    public void deleteById(int id) {
        feedbackRepository.deleteById(id);

    }
}

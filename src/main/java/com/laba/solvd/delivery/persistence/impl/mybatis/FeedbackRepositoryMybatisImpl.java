package com.laba.solvd.delivery.persistence.impl.mybatis;

import com.laba.solvd.delivery.domain.Feedback;
import com.laba.solvd.delivery.persistence.FeedbackRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FeedbackRepositoryMybatisImpl implements FeedbackRepository {
    @Override
    public Feedback findById(int id) {
        return null;
    }

    @Override
    public List<Feedback> retrieveAll() {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            FeedbackRepository feedbackRepository = sqlSession.getMapper(FeedbackRepository.class);
            return feedbackRepository.retrieveAll();
        }
    }

    @Override
    public void create(Feedback feedback) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            FeedbackRepository feedbackRepository = sqlSession.getMapper(FeedbackRepository.class);
            feedbackRepository.create(feedback);
        }
    }

    @Override
    public void updateFeedbackByComments(int id, String newComments) {

    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession()) {
            FeedbackRepository feedbackRepository = sqlSession.getMapper(FeedbackRepository.class);
            feedbackRepository.deleteById(id);
        }
    }
}

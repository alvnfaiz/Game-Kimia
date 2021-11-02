package com.alvindev.aplikasibelajaruts.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.alvindev.aplikasibelajaruts.data.room.QuestionDao;
import com.alvindev.aplikasibelajaruts.data.room.RumusKimiaRoomDatabase;
import com.alvindev.aplikasibelajaruts.data.room.ScoreDao;
import com.alvindev.aplikasibelajaruts.domain.Question;
import com.alvindev.aplikasibelajaruts.domain.Score;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private QuestionDao mQuestionDao;
    private ExecutorService executorService;
    private ScoreDao mScoreDao;

    public Repository(Application application) {
        // membuat thread baru
        executorService = Executors.newSingleThreadExecutor();
        RumusKimiaRoomDatabase db = RumusKimiaRoomDatabase.getDatabase(application);
        mQuestionDao = db.questionDao();
        mScoreDao = db.scoreDao();
    }

    public void insertScore(final Score score) {
        executorService.execute(() -> mScoreDao.insert(score));
    }

    public void updateScore(final Score score) {
        executorService.execute(() -> mScoreDao.update(score));
    }

    public void deleteScore(final Score score) {
        executorService.execute(() -> mScoreDao.delete(score));
    }

    public LiveData<List<Question>> getAllQuestion() {
        return mQuestionDao.getAllQuestions();
    }

    public void insertQuestion(final Question question) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mQuestionDao.insert(question);
            }
        });
    }

    public void deleteQuestion(final Question question) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mQuestionDao.delete(question);
            }
        });
    }

    public LiveData<List<Score>> getAllScore() {
        return mScoreDao.getScores();
    }
}

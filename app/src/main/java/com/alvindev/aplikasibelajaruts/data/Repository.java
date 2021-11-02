package com.alvindev.aplikasibelajaruts.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.alvindev.aplikasibelajaruts.data.room.QuestionDao;
import com.alvindev.aplikasibelajaruts.data.room.RumusKimiaRoomDatabase;
import com.alvindev.aplikasibelajaruts.domain.Question;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private QuestionDao mQuestionDao;
    private ExecutorService executorService;

    public Repository(Application application) {
        // membuat thread baru
        executorService = Executors.newSingleThreadExecutor();
        RumusKimiaRoomDatabase db = RumusKimiaRoomDatabase.getDatabase(application);
        mQuestionDao = db.questionDao();
    }

    public LiveData<List<Question>> getAllQuestion() {
        return mQuestionDao.getAllQuestions();
    }

    public void insert(final Question question) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mQuestionDao.insert(question);
            }
        });
    }

    public void delete(final Question question) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mQuestionDao.delete(question);
            }
        });
    }
}

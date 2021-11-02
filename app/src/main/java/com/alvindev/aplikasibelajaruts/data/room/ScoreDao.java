package com.alvindev.aplikasibelajaruts.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.alvindev.aplikasibelajaruts.domain.Score;

import java.util.List;

@Dao
public interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Score score);

    @Update()
    void update(Score score);

    @Delete()
    void delete(Score score);

    @Query("SELECT * FROM score ORDER BY score DESC")
    LiveData<List<Score>> getScores();
}

package com.alvindev.aplikasibelajaruts.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.alvindev.aplikasibelajaruts.domain.Question;

import java.util.List;

/**
 * <p>
 * Ini merupakan Interface yang akan digunakan untuk melakukan operasi data di dalam Database.
 * Anotasi {@link Dao} digunakan untuk menandai sekaligus menghubungkannya dengan Dao ROOM.
 * </p>
 *
 * <p>
 * Pada interface ini kita hanya gunakan tiga operasi dasar saja yaitu {@link Insert},
 * {@link Delete} dan {@link Query}.
 * </p>
 *
 * <p>
 * Untuk Query kita simpan di dalam Live Data sebagai penyedia data sebelum ditampilkan ke view.
 * </p>
 */
@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Question question);

    @Delete()
    void delete(Question question);

    @Query("SELECT * FROM question ORDER BY id ASC")
    LiveData<List<Question>> getAllQuestions();
}

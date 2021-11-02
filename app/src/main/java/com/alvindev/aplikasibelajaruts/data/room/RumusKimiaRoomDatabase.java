package com.alvindev.aplikasibelajaruts.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alvindev.aplikasibelajaruts.domain.Question;

/**
 * Ini merupakan kelas yang menangani database. {@link Database} adalah anotasi yang menghubungkan
 * langsung kelas ini dengan Room Database. Pada {@literal entities} digunakan untuk memasukkan
 * daftar Tabel ke dalam database, disini kita secara langsung menganggap entities dan model sebagai
 * entitas yang sama
 */
@Database(entities = {Question.class}, version = 1)
public abstract class RumusKimiaRoomDatabase extends RoomDatabase {
    private static volatile RumusKimiaRoomDatabase INSTANCE;

    // SINGLETON
    public static RumusKimiaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE != null) {
            synchronized (RumusKimiaRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        RumusKimiaRoomDatabase.class, "game_database")
                        .build();
            }
        }
        return INSTANCE;
    }

    public abstract QuestionDao questionDao();


}

package com.example.roomexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tune.class}, version = 1)
public abstract class TunesDB extends RoomDatabase {
    final static String DATABASE_NAME = "tunes.db";
    public static TunesDB INSTANCE = null;

    abstract PlayList playList();

    public static TunesDB create(Context context, boolean memoryOnly){
        RoomDatabase.Builder<TunesDB> db;
        if(memoryOnly)
            db = Room.inMemoryDatabaseBuilder(context, TunesDB.class);
        else
            db = Room.databaseBuilder(context, TunesDB.class, DATABASE_NAME);
        return db.build();
    }
    public static TunesDB get(Context context){
        if (INSTANCE == null)
            INSTANCE = create(context, false);
        return INSTANCE;
    }
}

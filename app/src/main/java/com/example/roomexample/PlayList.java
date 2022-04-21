package com.example.roomexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayList {

    @Insert
    void addNewTune(Tune...tunes);

    @Delete
    void deleteTunes(Tune...tunes);

    @Update
    void updateTunes(Tune...tunes);

    @Query("SELECT * FROM tunes WHERE _id=:id")
    Tune getTuneById(int id);

    @Query("SELECT * FROM tunes WHERE artist=:artist ORDER BY title")
    List<Tune> getAllByArtist(String artist);


}

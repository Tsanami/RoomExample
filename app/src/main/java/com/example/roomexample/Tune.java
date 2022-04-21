package com.example.roomexample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tunes")
public class Tune {

    @PrimaryKey
    int _id;
    String title;
    String artist;
    int year;

    @Ignore
    public Tune(){
        _id = 0;
        title = "";
        artist = "";
        year = 0;
    }

    public Tune(int _id, String title, String artist, int year) {
        this._id = _id;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        return "Музыкальный трек: " + _id + title + artist + year;
    }
}

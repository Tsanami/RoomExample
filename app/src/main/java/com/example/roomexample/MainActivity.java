package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button addButton, clearButton;
    ListView tunesList;
    TunesDB tunesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button);
        clearButton = findViewById(R.id.clear_button);
        tunesList = findViewById(R.id.tunes_list);

        tunesDB = TunesDB.get(getApplicationContext());
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PlayList playList = tunesDB.playList();
                        playList.addNewTune(new Tune(new Random().nextInt(10000),
                                "Hey ngarok", "Lalcy", 1998));
                    }
                }).start();
                setInfoFromTunes();
            }
        });
    }



    void setInfoFromTunes(){
        Context context = getApplicationContext();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Cursor c = tunesDB.query("SELECT * FFROM tunes", null);
                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                        context, R.layout.list_item,  c, c.getColumnNames(),
                        new int[]{R.id._id, R.id.title_tune, R.id.artist, R.id.year},
                        CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                );
                tunesList.setAdapter(cursorAdapter);
            }
        });
    }
}
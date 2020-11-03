package com.example.locationreminder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class BuyGrocery extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseManager db;
    ArrayList<String> id, note_title, new_note; //
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_grocery);

        recyclerView = findViewById(R.id.recyclerview);

        db = new DatabaseManager(BuyGrocery.this);
        id = new ArrayList<>();
        note_title = new ArrayList<>(); //
        new_note = new ArrayList<>();

        storeData();;

        customAdapter = new CustomAdapter(BuyGrocery.this, this, id, note_title, new_note); //
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(BuyGrocery.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            recreate();
        }
    }

    public void btnNote(View v)
    {
        Intent intent = new Intent(com.example.locationreminder.BuyGrocery.this, com.example.locationreminder.AddNote.class);

        startActivity(intent);
    }

    void storeData()
    {
        Cursor cursor = db.reaData();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                note_title.add(cursor.getString(1));
                new_note.add(cursor.getString(2));
            }
        }
    }
}
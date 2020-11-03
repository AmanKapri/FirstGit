package com.example.locationreminder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText addTitle_input, addNote_input;
    Button btn_update, btn_delete;

    String id, title, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        addTitle_input = findViewById(R.id.tv_addtitle2);
        addNote_input = findViewById(R.id.tv_addnote2);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        getIntentData();



        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseManager db = new DatabaseManager(Update.this);
                title = addTitle_input.getText().toString().trim();
                note = addNote_input.getText().toString().trim();
                db.updateData(id, title, note);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseManager db = new DatabaseManager(Update.this);
                db.delete(id);
                finish();
            }
        });

    }

    void getIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("note"))
        {
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            note = getIntent().getStringExtra("note");

            addNote_input.setText(note);
            addTitle_input.setText(title);
        }
        else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    }
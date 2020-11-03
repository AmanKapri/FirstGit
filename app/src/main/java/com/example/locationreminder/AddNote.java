package com.example.locationreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNote extends AppCompatActivity {

    EditText tv_addtitle, tv_note;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        tv_addtitle = findViewById(R.id.tv_addtitle);
        tv_note = findViewById(R.id.tv_addnote);
        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseManager db = new DatabaseManager(AddNote.this);
                db.addNote(tv_addtitle.getText().toString().trim(),
                        tv_note.getText().toString().trim());
            }
        });
    }
}
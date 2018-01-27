package com.ezerski.vladislav.geonotes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NoteAddActivity extends AppCompatActivity{

    private static final int REQUEST_CODE = 1;

    private Button btnCreateNote;
    private View btnSelectNoteColor;
    private ImageView newNote;
    private EditText note_body;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        newNote = findViewById(R.id.new_note);
        note_body = findViewById(R.id.editText_note);

        btnCreateNote = findViewById(R.id.btn_create_note);
        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnSelectNoteColor = findViewById(R.id.select_note_color);
        btnSelectNoteColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ColorPickerActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            int color  = data.getIntExtra("color", Color.BLACK);
            btnSelectNoteColor.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            newNote.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            btnCreateNote.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }
}

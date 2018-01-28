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

public class NoteAddActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private Button btnCreateNote;
    private View btnSelectNoteColor;
    private ImageView newNote;
    private EditText noteBody;

    private Note note = new Note();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        newNote = findViewById(R.id.new_note);
        noteBody = findViewById(R.id.editText_note);

        btnCreateNote = findViewById(R.id.btn_create_note);
        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note.setBody(noteBody.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("bodyText", note);
                setResult(RESULT_OK, intent);
                finish();
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
            if (resultCode == RESULT_OK) {
                int color = data.getIntExtra("color", Color.BLACK);
                btnSelectNoteColor.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                newNote.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                btnCreateNote.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                note.setColor(color);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}

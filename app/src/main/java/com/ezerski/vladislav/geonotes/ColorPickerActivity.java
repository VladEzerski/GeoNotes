package com.ezerski.vladislav.geonotes;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.skydoves.colorpickerview.ColorListener;
import com.skydoves.colorpickerview.ColorPickerView;

public class ColorPickerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_picker);

        final Button btn_col_pick = findViewById(R.id.btn_ColPick);
        final ColorPickerView colorPicker = findViewById(R.id.colorPickerView);

        colorPicker.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(int color) {
                btn_col_pick.getBackground().setColorFilter(colorPicker.getColor(), PorterDuff.Mode.SRC_ATOP);
            }
        });

        btn_col_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("color", colorPicker.getColor());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
}

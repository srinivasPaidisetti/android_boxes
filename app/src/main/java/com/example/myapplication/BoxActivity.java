package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BoxActivity extends AppCompatActivity {
    public static final String TAG = "BoxesActivity";
    private GridView gridView;
    private int mCount;
    RadioButton colorRadioButton;
    RadioGroup radioGroup;
    int red = 0, green = 0, blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        gridView = findViewById(R.id.gridView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mCount = getIntent().getIntExtra("count", 0);
        gridView.setAdapter(new BoxAdapter(this, mCount));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                colorRadioButton = (RadioButton) findViewById(selectedId);
                switch (colorRadioButton.getText().toString()) {
                    case "R":
                        red = red + 1;
                        changeColor(red, mCount, R.drawable.box_red, view, "RED");
                        break;
                    case "G":
                        green = green + 1;
                        changeColor(green, mCount, R.drawable.box_green, view, "GREEN");
                        break;
                    case "B":
                        blue = blue + 1;
                        changeColor(blue, mCount, R.drawable.box_blue, view, "BLUE");
                        break;
                }
            }

        });
    }

    private void changeColor(int click, int count, int boxColor, View view, String color) {
        if (click <= count/3) {
            ImageView imageView = (ImageView) view;
            imageView.setImageResource(boxColor);
        } else {
            Toast.makeText(BoxActivity.this, color + " limit exceeded", Toast.LENGTH_LONG).show();
        }
    }
}

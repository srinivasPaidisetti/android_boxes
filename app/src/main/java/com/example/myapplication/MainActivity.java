package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.e_boxes_count);
        mButton = findViewById(R.id.b_submit);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(mEditText.getText().toString());
                if (validateNumber(number)) {
                    Intent intent = new Intent(MainActivity.this, BoxActivity.class);
                    intent.putExtra("count", number);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Not a multiple of 3",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validateNumber(int n) {
        return n % 3 == 0;
    }


}
package com.example.pract16;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    TextView outputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.ed_text);
        outputText = findViewById(R.id.output_Text);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnLoad = findViewById(R.id.btn_load);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edText.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("savedText", text);
                editor.apply();
            }

        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedText = preferences.getString("savedText", "");
                outputText.setText(savedText);
            }

        });

    }
}
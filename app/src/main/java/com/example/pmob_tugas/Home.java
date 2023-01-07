package com.example.pmob_tugas;

import static com.example.pmob_tugas.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmob_tugas.R.id;

public class Home extends AppCompatActivity {
    private Button txtlogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtlogout = (Button) findViewById(logout);

        txtlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
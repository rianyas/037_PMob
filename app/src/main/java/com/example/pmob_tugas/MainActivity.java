package com.example.pmob_tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnama, txtnim, txtpassword;
    Button login, register;
    DataHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtuser = findViewById(R.id.txtnama);
        EditText txtunim = findViewById(R.id.txtnim);
        EditText txtpassword = findViewById(R.id.txtpassword);
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);
        db = new DataHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = txtnama.getText().toString().trim();
                String nim = txtnim.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();

//                Boolean res = db.ceknim(nama, nim, password);
//                if (res == true) {
//                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, Home.class));
//                } else {
//                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Registrasi.class);
                startActivity(i);
            }
        });
    }
}
package com.example.pmob_tugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrasi extends AppCompatActivity {
    private EditText txtnama, txtnim, txtpassword;
    private Button register;
    DataHelper DBase;
    private SharedPreferences sharedPreferences;
    Context x;

    public Registrasi(Context x) {
        this.x = x;
        DBase = new DataHelper(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        DBase = new DataHelper(this);

        txtnama = (EditText) findViewById(R.id.txtnama);
        txtnim = (EditText) findViewById(R.id.txtnim);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        register = (Button) findViewById(R.id.register);
        sharedPreferences = getSharedPreferences("mydata", MODE_PRIVATE);


        register.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor =

                String nama = txtnama.getText().toString().trim();
                String nim = txtnim.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                ContentValues values = new ContentValues();

                if(nim.equals("") || nama.equals("") || password.equals(""))
                    Toast.makeText(Registrasi.this, "Lengkapi Isian Data", Toast.LENGTH_SHORT).show();
                else {
                    SQLiteDatabase db = DBase.getWritableDatabase();
                    db.execSQL("insert into profil(nama, nim, password) values('" +
                            txtnama.getText().toString()+"','"+
                            txtnim.getText().toString() +"','" +
                            txtpassword.getText().toString() + "')");
                    Toast.makeText(Registrasi.this,
                            "Register Brhasil", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(Registrasi.this, MainActivity.class));
                }
            }
        }));
    }

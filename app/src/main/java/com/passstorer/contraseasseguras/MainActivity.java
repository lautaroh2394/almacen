package com.passstorer.contraseasseguras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAbout;
    private Button btnAyudar;
    private Button btnVerContrasenas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbout = (Button) findViewById(R.id.buttonAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutActivity = new Intent(MainActivity.this, aboutActivity.class);
                startActivity(aboutActivity);
            }
        });

        btnVerContrasenas = (Button) findViewById(R.id.buttonVerContrasenas);
        btnVerContrasenas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contrasenas = new Intent(MainActivity.this, contrasenasActivity.class);
                startActivity(contrasenas);
            }
        });


    }
}
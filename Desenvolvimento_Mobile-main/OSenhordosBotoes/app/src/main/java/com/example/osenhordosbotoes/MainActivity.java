package com.example.osenhordosbotoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnFilme2 = findViewById(R.id.btnFilme2);
        btnFilme2.setOnClickListener(this);

        Button btnFilme3 = findViewById(R.id.btnFilme3);
        btnFilme3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnFilme3) {
                    startActivity(new Intent(MainActivity.this, Filme3Activity.class));
                }
            }
        });
    }

    public void abrir(View view) {
        Intent intent = new Intent(this, Filme1Activity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFilme2) {
            startActivity(new Intent(this, Filme2Activity.class));
        }
    }
}
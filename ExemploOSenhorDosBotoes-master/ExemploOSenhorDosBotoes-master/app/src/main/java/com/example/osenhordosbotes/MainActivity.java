package com.example.osenhordosbotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.osenhordosbotes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //2a. forma
        binding.btnFilme2.setOnClickListener(this);

        //3a. forma
        binding.btnFilme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        Filme3Activity.class);
                startActivity(intent);
            }
        });
    }

    //1a. forma (desuso)
    public void abrir(View view) {
        Intent intent = new Intent(this,
                Filme1Activity.class);
        startActivity(intent);
    }

    //2a. forma
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnFilme2){
            startActivity(new Intent(this,
                    Filme2Activity.class));
        }
    }
}
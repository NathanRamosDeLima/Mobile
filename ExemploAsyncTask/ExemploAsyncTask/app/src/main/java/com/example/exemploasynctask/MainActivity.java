package com.example.exemploasynctask;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exemploasynctask.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnProcessar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        ProcessarTask task = new ProcessarTask(binding.btnProcessar,
                binding.txtStatus, binding.pgbProgresso);
        binding.pgbProgresso.setMax(10);
        task.execute(10);
    }
}
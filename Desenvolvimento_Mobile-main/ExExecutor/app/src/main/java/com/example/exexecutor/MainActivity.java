package com.example.exexecutor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProcessar;
    private TextView txtStatus;
    private ProgressBar pgbProgresso;

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

        btnProcessar = findViewById(R.id.btnProcessar);
        btnProcessar.setOnClickListener(this);

        txtStatus = findViewById(R.id.txtStatus);
        pgbProgresso = findViewById(R.id.pgbProgresso);
    }


    @Override
    public void onClick(View v) {
        ProcessarTask task = new ProcessarTask(btnProcessar, txtStatus, pgbProgresso);
        pgbProgresso.setMax(10);
        task.iniciarProcessamento(10);
    }
}
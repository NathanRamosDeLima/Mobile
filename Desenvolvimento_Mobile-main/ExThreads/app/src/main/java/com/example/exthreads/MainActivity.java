package com.example.exthreads;

import android.os.Bundle;
import android.os.SystemClock;
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

    private TextView txtStatus;
    private Button btnProcessar;
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
        pgbProgresso.setMax(10);
        pgbProgresso.setProgress(0);

    }

    @Override
    public void onClick(View v) {
        //Código que atualiza a interface antes da thread
        btnProcessar.setEnabled(false);
        pgbProgresso.setVisibility(View.VISIBLE);
        executarAlgoDemorado();

    }

    private void executarAlgoDemorado() {
        new Thread(new Runnable() {
            int progresso = 0;
            @Override
            public void run() {
                while (progresso < pgbProgresso.getMax()) {
                    SystemClock.sleep(1000);
                    progresso++;
                    runOnUiThread(new Runnable() {
                        //Código que atualiza a interface durante a thread
                        @Override
                        public void run() {
                            pgbProgresso.setProgress(progresso);
                        }
                    });
                }

                runOnUiThread(new Runnable() {
                    //Código que atualiza a interface no final da thread
                    @Override
                    public void run() {
                        pgbProgresso.setVisibility(View.INVISIBLE);
                        txtStatus.setText(R.string.finalizado);
                        btnProcessar.setEnabled(true);
                    }
                });
            }
        }).start();
    }
}
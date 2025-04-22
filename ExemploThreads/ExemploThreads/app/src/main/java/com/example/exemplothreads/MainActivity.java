package com.example.exemplothreads;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exemplothreads.databinding.ActivityMainBinding;

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
        //binding.txtStatus.setText(R.string.processando);
        binding.btnProcessar.setEnabled(false);
        binding.pgbProgresso.setVisibility(View.VISIBLE);
        binding.pgbProgresso.setMax(15);
        binding.pgbProgresso.setProgress(0);
        executarAlgoDemorado();

    }

    private void executarAlgoDemorado() {
        new Thread(new Runnable() {
            int progresso = 0;

            @Override
            public void run() {
               //código que deve executar em segundo plano
                while(progresso < binding.pgbProgresso.getMax()){
                    SystemClock.sleep(1000);
                    progresso++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //código que atualiza a barra de progresso
                            binding.pgbProgresso.setProgress(progresso);
                        }
                    });
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //código que atualiza a interface
                        binding.pgbProgresso.setVisibility(View.INVISIBLE);
                        binding.btnProcessar.setEnabled(true);
                        binding.txtStatus.setText(R.string.finalizado);
                    }
                });
            }
        }).start();
    }
}
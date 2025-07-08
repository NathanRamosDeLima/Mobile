package com.example.exexecutor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessarTask {

    private Button btnProcessar;
    private TextView txtStatus;
    private ProgressBar pgbProgresso;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public ProcessarTask(Button btnProcessar, TextView txtStatus, ProgressBar pgbProgresso) {
        this.btnProcessar = btnProcessar;
        this.txtStatus = txtStatus;
        this.pgbProgresso = pgbProgresso;
    }

    public void iniciarProcessamento(int max){
        btnProcessar.setEnabled(false);
        pgbProgresso.setProgress(0);
        pgbProgresso.setVisibility(View.VISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                final int progresso = 0;
                while (i < max) {
                    SystemClock.sleep(1000);
                    mainHandler.post(() -> pgbProgresso.setProgress(progresso));
                    i++;
                }
                mainHandler.post(() -> {
                    pgbProgresso.setVisibility(View.INVISIBLE);
                    txtStatus.setText("Finalizado");
                    btnProcessar.setEnabled(true);
                });
            }
        });
    }
}

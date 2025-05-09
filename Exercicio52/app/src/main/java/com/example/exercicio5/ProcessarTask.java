package com.example.exercicio5;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessarTask extends AsyncTask<Integer, Integer, Void> {

    private final Button btnProcessar;
    private final TextView txtStatus;
    private final ProgressBar pgbProgresso;

    public ProcessarTask(Button btnProcessar, TextView txtStatus, ProgressBar pgbProgresso) {
        this.btnProcessar = btnProcessar;
        this.txtStatus    = txtStatus;
        this.pgbProgresso = pgbProgresso;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtStatus.setText(R.string.processando);
        pgbProgresso.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int contador = params[0];
        while (contador >= 0) {
            publishProgress(contador);
            SystemClock.sleep(1000);
            contador--;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int val = values[0];
        pgbProgresso.setProgress(val);
        txtStatus.setText(String.valueOf(val));
    }

    @Override
    protected void onPostExecute(Void result) {
        pgbProgresso.setVisibility(View.INVISIBLE);
        txtStatus.setText(R.string.finalizado);
        btnProcessar.setEnabled(true);
    }
}
package com.example.comunicacaofragments;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements DatePickerFragment.OnDateSelectedListener, TimePickerFragment.OnTimeSelectedListener {

    private TextView tvDataHora;
    private Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDataHora = findViewById(R.id.tvDataHora);
        Button btnData = findViewById(R.id.btnDefinirData);
        Button btnHora = findViewById(R.id.btnDefinirHora);

        calendario = Calendar.getInstance();
        atualizarTexto();

        btnData.setOnClickListener(v -> {
            DatePickerFragment datePicker = new DatePickerFragment();
            datePicker.setOnDateSelectedListener(this);
            datePicker.show(getSupportFragmentManager(), "datePicker");
        });

        btnHora.setOnClickListener(v -> {
            TimePickerFragment timePicker = new TimePickerFragment();
            timePicker.setOnTimeSelectedListener(this);
            timePicker.show(getSupportFragmentManager(), "timePicker");
        });
    }

    private void atualizarTexto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        tvDataHora.setText(sdf.format(calendario.getTime()));
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        calendario.set(Calendar.YEAR, year);
        calendario.set(Calendar.MONTH, month);
        calendario.set(Calendar.DAY_OF_MONTH, day);
        atualizarTexto();
    }

    @Override
    public void onTimeSelected(int hour, int minute) {
        calendario.set(Calendar.HOUR_OF_DAY, hour);
        calendario.set(Calendar.MINUTE, minute);
        atualizarTexto();
    }
}

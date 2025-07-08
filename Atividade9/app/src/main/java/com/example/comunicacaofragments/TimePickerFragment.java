package com.example.comunicacaofragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    private OnTimeSelectedListener listener;

    public interface OnTimeSelectedListener {
        void onTimeSelected(int hour, int minute);
    }

    public void setOnTimeSelectedListener(OnTimeSelectedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), (view, hourOfDay, minute1) -> {
            if (listener != null) {
                listener.onTimeSelected(hourOfDay, minute1);
            }
        }, hora, minuto, true);
    }
}

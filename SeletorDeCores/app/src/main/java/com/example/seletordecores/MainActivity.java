package com.example.seletordecores;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seletordecores.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ActivityMainBinding binding;
    private String[] corHex = {"00", "00", "00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.skbVermelho.setOnSeekBarChangeListener(this);
        binding.skbVerde.setOnSeekBarChangeListener(this);
        binding.skbAzul.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String c = Integer.toHexString(progress);
        if(seekBar.getId() == R.id.skbVermelho){
            corHex[0] = (c.length() == 2? "":"0") + c;
        }

        if(seekBar.getId() == R.id.skbVerde){
            corHex[1] = (c.length() == 2? "":"0") + c;
        }

        if(seekBar.getId() == R.id.skbAzul){
            corHex[2] = (c.length() == 2? "":"0") + c;
        }


        binding.txtCor.setText("#"+corHex[0]+corHex[1]+corHex[2]);
        binding.caixaCor.setBackgroundColor(Color.parseColor("#"+corHex[0]+corHex[1]+corHex[2]));




    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
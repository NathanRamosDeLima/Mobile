package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CAT";

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
        Log.i(TAG, "Método onCreate() chamado");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "Método onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Método onResume() chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Método onPause() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Método onStop() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Método onDestroy() chamado");
    }
}
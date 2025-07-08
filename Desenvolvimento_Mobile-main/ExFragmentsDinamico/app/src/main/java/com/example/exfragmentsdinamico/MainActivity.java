package com.example.exfragmentsdinamico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private boolean swapped = false;

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

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        fm = getSupportFragmentManager();
        UpFragment up = new UpFragment();
        DownFragment down = new DownFragment();

        ft = fm.beginTransaction();
        ft.add(R.id.fragment1, up, "up");
        ft.add(R.id.fragment2, down, "down");
        ft.commit();


    }

    @Override
    public void onClick(View view) {

        ft = fm.beginTransaction();
        if(!swapped){
            ft.replace(R.id.fragment1, new DownFragment(), "down");
            ft.replace(R.id.fragment2, new UpFragment(), "up");

        }
        else {
            ft.replace(R.id.fragment1, new UpFragment(), "up");
            ft.replace(R.id.fragment2, new DownFragment(), "down");
        }
        swapped = !swapped;
        ft.commit();
    }
}
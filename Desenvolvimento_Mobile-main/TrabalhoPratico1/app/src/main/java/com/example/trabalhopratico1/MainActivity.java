package com.example.trabalhopratico1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtImageUrl;
    private Button btnDownload, btnClear;
    private ProgressBar progressBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets sys = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(sys.left, sys.top, sys.right, sys.bottom);
            return insets;
        });

        txtImageUrl = findViewById(R.id.txtImageUrl);
        btnDownload = findViewById(R.id.btnDownload);
        btnClear = findViewById(R.id.btnClear);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);

        btnDownload.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDownload) {
            String url = txtImageUrl.getText().toString().trim();

            if (url.isEmpty()) {
                Toast.makeText(this, "Digite uma URL válida", Toast.LENGTH_SHORT).show();
                return;
            }

            new Thread(() -> {
                runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));

                try {
                    InputStream in = new URL(url).openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(in);
                    in.close();

                    runOnUiThread(() -> {
                        imageView.setImageBitmap(bitmap);
                        progressBar.setVisibility(View.GONE);
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, "Erro ao baixar imagem", Toast.LENGTH_SHORT).show();
                    });
                }

            }).start();

        } else if (v.getId() == R.id.btnClear) {
            imageView.setImageDrawable(null);
            txtImageUrl.setText("");
        }
    }
}

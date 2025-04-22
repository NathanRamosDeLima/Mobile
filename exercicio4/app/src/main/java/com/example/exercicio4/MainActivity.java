package com.example.exercicio4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.material.slider.Slider;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    Button btnAplicar;
    TextView resultado;
    SeekBar seekBarTamanho;
    CheckBox cbNegrito, cbItalico, cbMaiusculas;
    RadioGroup radioGroupCores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        btnAplicar = findViewById(R.id.btnAplicar);
        resultado = findViewById(R.id.resultado);
        seekBarTamanho = findViewById(R.id.seekBarTamanho);
        cbNegrito = findViewById(R.id.cbNegrito);
        cbItalico = findViewById(R.id.cbItalico);
        cbMaiusculas = findViewById(R.id.cbMaiusculas);
        radioGroupCores = findViewById(R.id.radioGroupCores);

        btnAplicar.setOnClickListener(v -> {
            String texto = inputText.getText().toString();
            if (cbMaiusculas.isChecked()) {
                texto = texto.toUpperCase();
            }

            int estilo = Typeface.NORMAL;
            if (cbNegrito.isChecked() && cbItalico.isChecked()) {
                estilo = Typeface.BOLD_ITALIC;
            } else if (cbNegrito.isChecked()) {
                estilo = Typeface.BOLD;
            } else if (cbItalico.isChecked()) {
                estilo = Typeface.ITALIC;
            }

            resultado.setTypeface(null, estilo);
            resultado.setText(texto);
        });

        seekBarTamanho.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultado.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        radioGroupCores.setOnCheckedChangeListener((group, checkedId) -> {
            int cor = Color.BLACK;
            if (checkedId == R.id.rbVermelho) {
                cor = Color.RED;
            } else if (checkedId == R.id.rbVerde) {
                cor = Color.GREEN;
            } else if (checkedId == R.id.rbAzul) {
                cor = Color.BLUE;
            }
            resultado.setTextColor(cor);
        });
    }
}
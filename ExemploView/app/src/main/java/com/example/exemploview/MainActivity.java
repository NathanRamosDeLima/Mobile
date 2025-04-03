package com.example.exemploview;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exemploview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //  setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnExibir.setOnClickListener(this);
        binding.btnLimpar.setOnClickListener(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLimpar){
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.swtWhats.setChecked(false);
            binding.rdgPeriodo.clearCheck();
            binding.chkINternet.setChecked(false);
            binding.chkStreamin.setChecked(false);
            binding.chkTelefone.setChecked(false);
            binding.chkTv.setChecked(false);


        }
        else if (view.getId() == R.id.btnExibir){
            //Toast.makeText(this,"Exibir",Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: "
                    + binding.edtNome.getText().toString());
            binding.txtEmail.setText("E-mail: "
                    + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: "
                    + binding.edtTelefone.getText().toString());
            if(binding.swtWhats.isChecked()){
                binding.txtWhatsApp.setText("WhatsApp: "
                        +binding.swtWhats.getTextOn());
            }else{
                binding.txtWhatsApp.setText("WhatsApp: "
                        +binding.swtWhats.getTextOff());
            }

            int idrdbSelecionado = binding.rdgPeriodo.getCheckedRadioButtonId();
            if(idrdbSelecionado > 0){
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                binding.txtPeriodo.setText("Período: "
                        + rdbSelecionado.getText().toString());
            }

            String pref="";
            if(binding.chkINternet.isChecked())
                pref = binding.chkINternet.getText().toString();
            if(binding.chkTelefone.isChecked()){
                pref += " ";
                pref += binding.chkTelefone.getText().toString();
            }
            if(binding.chkTv.isChecked()){
                pref += " ";
                pref += binding.chkTv.getText().toString();
            }
            if(binding.chkStreamin.isChecked()){
                pref += " ";
                pref += binding.chkStreamin.getText().toString();
            }
            binding.txtPreferencia.setText("Preferências: " + pref);
        }
    }
}
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exemploasynctask.R;

public class MainActivity extends AppCompatActivity {

    private TextView textViewContador;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewContador = findViewById(R.id.textViewContador);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(v -> {
            btnIniciar.setEnabled(false); // desabilita o botão
            new ContadorAsyncTask().execute(10); // inicia a contagem
        });
    }

    private class ContadorAsyncTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... params) {
            int valor = params[0];
            while (valor >= 0) {
                publishProgress(valor); // envia valor para UI thread
                try {
                    Thread.sleep(1000); // espera 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                valor--;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textViewContador.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            btnIniciar.setEnabled(true); // reabilita o botão após a contagem
        }
    }
}

package com.example.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] estados;
    String[] capitais;
    Random r = new Random();
    int num;
    int count = 1;
    int pontuacao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estados = new String[]{
                "Paraná",
                "São Paulo",
                "Espirito Santo",
                "Minas Gerais",
                "Rio Grande do Sul",
                "Roraima",
                "Sergipe",
                "Tocantins",
                "Distrito Federal",
                "Pará",
                "Paraíba",
                "Pernambuco",
                "Piauí",
                "Goías",
                "Ceará"
        };

        capitais = new String[]{
                "Cutiriba",
                "São Paulo",
                "Vitória",
                "Belo Horizonte",
                "Porto Alegre",
                "Boa Vista",
                "Aracaju",
                "Palmas",
                "Brasília",
                "Belém",
                "João Pessoa",
                "Recife",
                "Teresinha",
                "Goiânia",
                "Fortaleza"
        };

        Random r = new Random();
        num = r.nextInt(15);
        TextView outEstado = findViewById(R.id.estado);
        outEstado.setText(estados[num]);
    }

    public void avancar(View view){
        if(count < 5) {
            num = r.nextInt(15);
            TextView outEstado = findViewById(R.id.estado);
            outEstado.setText(estados[num]);
            count = count + 1;
            Button btn1 = (Button) findViewById(R.id.confirmar);
            btn1.setEnabled(true);
            TextView output = findViewById(R.id.Resposta);
            output.setText("");
        }
        else if(count == 5){
            Button btn1 = (Button) findViewById(R.id.confirmar);
            Button btn2 = (Button) findViewById(R.id.avancarr);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            TextView output = findViewById(R.id.Resposta);
            output.setText("Jogo finalizado!");
        }
    }

    public void confirmar(View view){
        EditText input = findViewById(R.id.ChuteCapital);
        TextView output = findViewById(R.id.Resposta);
        TextView pont = findViewById(R.id.pontuacao);
        Button btn1 = (Button) findViewById(R.id.confirmar);
        btn1.setEnabled(false);
        String capital = capitais[num];
        if(input.length() == 0){
            Toast.makeText(this, "Forneça a Capital", Toast.LENGTH_SHORT).show();
        }
        else if (input.getText().toString().equals(capital)){
            output.setText("Voce Acertou!!!");
            pontuacao = pontuacao + 10;
            pont.setText(String.valueOf(pontuacao));
        }
        else{
            output.setText("Voce Errou !!! Capital Correta: "+ capital);
        }
    }
}
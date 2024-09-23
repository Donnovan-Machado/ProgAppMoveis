package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        // recupera os dados passados da MainActivity
        Intent i = getIntent();

        float peso = i.getFloatExtra("peso", 0);
        float altura = i.getFloatExtra("altura", 0);
        String nome = i.getStringExtra("nome");

        ImageView img = findViewById(R.id.imageView2);

        float imc = peso/(altura*altura);
        String estado;
        if (imc < 18.5) {
            estado = "Abaixo do peso";
            img.setImageResource(R.drawable.abaixopeso);

        } else if (imc < 25) {
            estado = "Normal";
            img.setImageResource(R.drawable.normal);

        } else if (imc < 30) {
            estado = "Sobrepeso";
            img.setImageResource(R.drawable.sobrepeso);

        } else if (imc < 35) {
            estado = "Obesidade grau 1";
            img.setImageResource(R.drawable.obesidade1);

        } else if (imc < 40) {
            estado = "Obesidade grau 2";
            img.setImageResource(R.drawable.obesidade2);

        } else {
            estado = "Obesidade grau 3";
            img.setImageResource(R.drawable.obesidade3);

        }

        //seta os valores
        TextView nomeTextView = findViewById(R.id.textViewNome);
        TextView alturaTextView = findViewById(R.id.textViewAltura);
        TextView pesoTextView = findViewById(R.id.textViewPeso);
        TextView imcTextView = findViewById(R.id.textViewImc);
        TextView estadoTextView = findViewById(R.id.textViewEstado);

        nomeTextView.setText("Nome: " + nome);
        pesoTextView.setText("Peso: " + peso + " kg");
        alturaTextView.setText("Altura: " + altura + " m");
        imcTextView.setText("IMC: " + (peso/(altura*altura)));
        estadoTextView.setText(estado);

        //botão para voltar
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
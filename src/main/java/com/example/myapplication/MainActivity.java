package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText edNome = findViewById(R.id.edNome);
        EditText edAlt = findViewById(R.id.edAltura);
        EditText edPeso = findViewById(R.id.edPeso);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float peso = Float.parseFloat(edPeso.getText().toString());
                    float alt = Float.parseFloat(edAlt.getText().toString());
                    String nome = edNome.getText().toString();
                    Intent i = new Intent(MainActivity.this, MainActivityB.class);
                    i.putExtra("peso", peso);
                    i.putExtra("altura", alt);
                    i.putExtra("nome", nome);
                    startActivity(i);
                } catch (NumberFormatException e) {
                    Log.e("MainActivity", "Erro ao converter valores", e);
                }
            }
        });
    }


}
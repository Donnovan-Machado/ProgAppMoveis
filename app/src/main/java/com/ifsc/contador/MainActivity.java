package com.ifsc.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    EditText edMin, edMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        edMin=findViewById(R.id.edMin);
        edMax=findViewById(R.id.edMax);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min =Integer.parseInt(edMin.getText().toString());
                int maxim=Integer.parseInt(edMax.getText().toString());
                Random random=new Random();

                int valorSorteado=random.nextInt(maxim- min)+ min;
                textView.setText(Integer.toString(valorSorteado));
            }
        });
        Log.d("Ciclo de vida","Passou pelo metodo oncreate");
        Toast.makeText(this, "oncreate", Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Clico de vida", "Paaou pelo metodo onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de vida", "Passou pelo metodo onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de vida", "Passou pelo metodo onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo de vida", "Pasou pelo metodo onStop");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo de vida", "Passou pelo metodo onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo de vida", "Passou pelo metoo onRestart");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

}
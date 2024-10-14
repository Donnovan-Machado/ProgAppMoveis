package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int num1;
    int num2;
    Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btClick);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Random random= new Random();
            Button b=(Button) view;
            TextView txt1 =(TextView) view;
            TextView t2 =(TextView) view;
            TextView th =(TextView) view;
            t1 = findViewById(R.id.txtInicial);
            t2 = findViewById(R.id.txtFinal);
            th = findViewById(R.id.txtHello);
            num1 = Integer.parseInt(String.valueOf(t1.getText()));
            num2 = Integer.parseInt(String.valueOf(t2.getText()));
            th.setText(String.valueOf(random.nextInt(num2-num1)+num1));
            Intent i = new Intent(getApplicationContext(),dois.class);
            //startActivity(i);
        }
        });
    }
}
package com.ifsc.listagem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] nomes = new String[] {"Picareta", "Jhonas Dark", "Camili", "Vitoria", "Mari"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        DAOPlaneta planetaDAO = new DAOPlaneta();
        PlanetaAdapter planetaAdapter = new PlanetaAdapter(this,R.layout.item_planeta,planetaDAO.getPlanetas());

        listView.setAdapter(planetaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),Integer.toString(i) + nomes[i], Toast.LENGTH_LONG ).show();
            }
        });
    }
}
package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    EditText editTextNome, editTextEmail, editTextNasc;
    Button button;
    ListView listView;

    int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.edNome);
        editTextEmail = findViewById(R.id.edEmail);
        editTextNasc = findViewById(R.id.edDataNascimento);
        button = findViewById(R.id.btnCadastrar);
        listView = findViewById(R.id.listview);

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT, dtnsc DATE)");

        carregarListagem();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);

                if (selectedId == -1) {
                    long status = database.insert("pessoas", null, cv);
                    if (status > 0) {
                        Toast.makeText(getApplicationContext(), "Usuario inserido com sucesso!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro na inserção!", Toast.LENGTH_LONG).show();
                    }
                } else { // Atualização
                    cv.put("id", selectedId);
                    database.update("pessoas", cv, "id=?", new String[]{String.valueOf(selectedId)});
                    Toast.makeText(getApplicationContext(), "Usuario atualizado com sucesso!", Toast.LENGTH_LONG).show();
                    selectedId = -1;
                }

                carregarListagem();
                limparCampos();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = database.rawQuery("SELECT * FROM pessoas", null);
                cursor.moveToPosition(position);
                selectedId = cursor.getInt(0);
                String nome = cursor.getString(1);
                String email = cursor.getString(2);
                String dataNasc = cursor.getString(3);

                editTextNome.setText(nome);
                editTextEmail.setText(email);
                editTextNasc.setText(dataNasc);
                cursor.close();
            }
        });
    }

    public void carregarListagem() {
        Cursor cursor = database.rawQuery("SELECT * FROM pessoas", null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);
    }

    private void limparCampos() {
        editTextNome.setText("");
        editTextEmail.setText("");
        editTextNasc.setText("");
    }
}

package com.vitoraugusto.myapplication.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitoraugusto.myapplication.Controller.PessoaController;
import com.vitoraugusto.myapplication.Model.Curso;
import com.vitoraugusto.myapplication.Model.Pessoa;
import com.vitoraugusto.myapplication.R;


public class MainActivity extends AppCompatActivity {
    Context context;

    private Button limpar, salvar, finalizar;
    private EditText primeiroNome, sobrenome, nomeCurso, telefoneDeContato;
PessoaController pessoaController;
    Pessoa pessoa;
    Curso curso;

SharedPreferences sharedPreferences;

public static final String NOMES_PREFERENCES = "usuarios";



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        pessoa = new Pessoa();

        limpar = findViewById(R.id.limpar);
        salvar = findViewById(R.id.salvar);
        finalizar = findViewById(R.id.finalizar);

        primeiroNome = findViewById(R.id.primeiroNome);
        sobrenome = findViewById(R.id.sobrenome);
        nomeCurso = findViewById(R.id.nomeDoCurso);
        telefoneDeContato = findViewById(R.id.TelefoneDeContato);

        sharedPreferences = getSharedPreferences(NOMES_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = sharedPreferences.edit();


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNome.setText("");
                sobrenome.setText("");
                nomeCurso.setText("");
                telefoneDeContato.setText("");
            }
        });


        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa = new Pessoa(
                        String.valueOf(primeiroNome.getText()),
                        String.valueOf(sobrenome.getText()),
                        String.valueOf(nomeCurso.getText()),
                        String.valueOf(telefoneDeContato.getText()));


                pessoaController = new PessoaController();
                pessoaController.salvar(pessoa);

                listaVip.putString("Nome : ", pessoa.getPrimeiroNome());
                listaVip.putString("Sobrenome: ", pessoa.getSobrenome());
                listaVip.putString("Curso: ", pessoa.getCurso());
                listaVip.putString("Telefone Contato", pessoa.getTelefoneContato());
                listaVip.apply();



                Toast.makeText(MainActivity.this, "Dados Salvos", Toast.LENGTH_SHORT).show();
                primeiroNome.setText("");
                sobrenome.setText("");
                nomeCurso.setText("");
                telefoneDeContato.setText("");

            }
        });
    }


}








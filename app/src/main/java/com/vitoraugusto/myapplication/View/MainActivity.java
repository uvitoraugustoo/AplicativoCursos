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

import com.vitoraugusto.myapplication.Controller.CursoController;
import com.vitoraugusto.myapplication.Controller.PessoaController;
import com.vitoraugusto.myapplication.Model.Curso;
import com.vitoraugusto.myapplication.Model.Pessoa;
import com.vitoraugusto.myapplication.R;


public class MainActivity extends AppCompatActivity {
    Context context = this;

    private Button limpar, salvar, finalizar;
    private EditText primeiroNome, sobrenome, nomeCurso, telefoneDeContato;
    PessoaController pessoaController;
    Pessoa pessoa;
    Curso curso;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        pessoaController = new PessoaController(this);

        pessoa = new Pessoa();

        limpar = findViewById(R.id.limpar);
        salvar = findViewById(R.id.salvar);
        finalizar = findViewById(R.id.finalizar);

        primeiroNome = findViewById(R.id.primeiroNome);
        sobrenome = findViewById(R.id.sobrenome);
        nomeCurso = findViewById(R.id.nomeDoCurso);
        telefoneDeContato = findViewById(R.id.TelefoneDeContato);


        limpar.setOnClickListener(v ->
        {
            primeiroNome.setText("");
            sobrenome.setText("");
            nomeCurso.setText("");
            telefoneDeContato.setText("");
            pessoaController.deleterPessoa();

        });


        finalizar.setOnClickListener(v -> {
            {
                finish();
            }
        });
        salvar.setOnClickListener(v -> {
            {
                Pessoa pessoa = new Pessoa(
                        primeiroNome.getText().toString(),
                        sobrenome.getText().toString(),
                        nomeCurso.getText().toString(),
                        telefoneDeContato.getText().toString()
                );

                pessoaController.salvarPessoa(pessoa);



                Toast.makeText(MainActivity.this, "Dados Salvos", Toast.LENGTH_SHORT).show();

            }
        });
        carregarPessoaSalva();
    }

    public void carregarPessoaSalva() {
        Pessoa pessoa1 = pessoaController.carregarPessoa();

        primeiroNome.setText(pessoa1.getPrimeiroNome());
        sobrenome.setText(pessoa1.getSobrenome());
        nomeCurso.setText(pessoa1.getNomeDoCurso());
        telefoneDeContato.setText(pessoa1.getTelefoneContato());

    }
}









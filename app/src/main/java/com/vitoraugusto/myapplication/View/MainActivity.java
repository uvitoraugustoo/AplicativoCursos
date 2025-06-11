package com.vitoraugusto.myapplication.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitoraugusto.myapplication.Controller.CursoController;
import com.vitoraugusto.myapplication.Controller.DbController;
import com.vitoraugusto.myapplication.Controller.PessoaController;
import com.vitoraugusto.myapplication.Model.Curso;
import com.vitoraugusto.myapplication.Model.Pessoa;
import com.vitoraugusto.myapplication.R;


public class MainActivity extends AppCompatActivity {

    int posicao;
    private Button limpar, salvar, finalizar;
    private EditText primeiroNome, sobrenome, telefoneDeContato;
    PessoaController pessoaController;
    Pessoa pessoa;
    Spinner nomeDoCurso;
    Curso curso;
    CursoController cursoController;

    Spinner spinner;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nomeDoCurso = findViewById(R.id.nomeDoCurso);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        nomeDoCurso.setAdapter(adapter);

        cursoController = new CursoController(this);
        pessoaController = new PessoaController(this);

        pessoa = new Pessoa();

        limpar = findViewById(R.id.limpar);
        salvar = findViewById(R.id.salvar);
        finalizar = findViewById(R.id.finalizar);
        primeiroNome = findViewById(R.id.primeiroNome);
        sobrenome = findViewById(R.id.sobrenome);


        telefoneDeContato = findViewById(R.id.TelefoneDeContato);

        limpar.setOnClickListener(v ->
        {
            primeiroNome.setText("");
            sobrenome.setText("");

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

                DbController dbController = new DbController(this);
                String resultado;

                Pessoa pessoa = new Pessoa(
                        primeiroNome.getText().toString(),
                        sobrenome.getText().toString(),
                        nomeDoCurso.getSelectedItem().toString(),
                        telefoneDeContato.getText().toString()
                );



                pessoaController.salvarPessoa(pessoa);
                resultado = dbController.insertData(pessoa.getPrimeiroNome(), pessoa.getSobrenome(), pessoa.getNomeDoCurso(), pessoa.getTelefoneContato());
                posicao = nomeDoCurso.getSelectedItemPosition();
                cursoController = new CursoController(this);

                cursoController.salvarPosicao(posicao);
                Toast.makeText(MainActivity.this, "Dados Salvos", Toast.LENGTH_SHORT).show();
            }

        });

        carregarPessoaSalva();
    }

    public void carregarPessoaSalva() {
        Pessoa pessoa1 = pessoaController.carregarPessoa();
        CursoController cursoController1 = new CursoController(this);
        primeiroNome.setText(pessoa1.getPrimeiroNome());
        sobrenome.setText(pessoa1.getSobrenome());
        nomeDoCurso.setSelection(cursoController1.carregarCurso());
        telefoneDeContato.setText(pessoa1.getTelefoneContato());
    }
}









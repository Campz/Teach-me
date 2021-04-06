package com.example.teach_me.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.model.Anuncio;

public class NovoAnuncioActivity extends AppCompatActivity {

    Spinner spinner_disciplina;
    EditText txt_descricao, txt_qtAlunos, txt_valor, txt_professor;
    Button btnCadastrarAnuncio, btnCancelarAnuncio;
    DisciplinaController disciplinaController;
    AnuncioController anuncioController;
    Anuncio novoAnuncio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_anuncio);
        initComponents();
        buttonsEvents();

        ArrayAdapter<CharSequence> disciplina_adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_disciplina, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        disciplina_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_disciplina.setAdapter(disciplina_adapter);

        //ArrayAdapter<CharSequence> professor_adapter = ArrayAdapter.createFromResource(this,
               // R.array.spinner_professor, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //professor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        //spinner_professor.setAdapter(professor_adapter);

    }

    private void buttonsEvents() {
        // Cancela o cadastro e volta a tela anterior
        btnCancelarAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Cadastra o novo anuncio
        btnCadastrarAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOK = true;

                if(TextUtils.isEmpty(txt_descricao.getText())){
                    isDadosOK = false;
                    txt_descricao.setError("Digite uma descrição para o anúncio");
                    txt_descricao.requestFocus();
                }

                if(TextUtils.isEmpty(txt_qtAlunos.getText())){
                    isDadosOK = false;
                    txt_qtAlunos.setError("Digite uma quantidade de vagas");
                    txt_qtAlunos.requestFocus();
                }

                if(TextUtils.isEmpty(txt_valor.getText())){
                    isDadosOK = false;
                    txt_valor.setError("Digite um valor para o seu anuncio");
                    txt_valor.requestFocus();
                }

                if(isDadosOK){
                    // Deu Bom
                    novoAnuncio.setDescricao(txt_descricao.getText().toString());
                    novoAnuncio.setQtdAlunos(Integer.getInteger(txt_qtAlunos.getText().toString()));
                    novoAnuncio.setValor(txt_valor.getText().toString());
                    novoAnuncio.setCdUsuarioProfessor(5);
                    novoAnuncio.setCdDisciplina(7);

                    anuncioController.incluir(novoAnuncio);
                    Log.i("log_add_usuario","onClick: Dados corretos...");
                }else{
                    // Deu ruim
                    Log.e("log_add_usuario","onClick: Dados incorretos...");
                }

            }
        });
    }

    private void initComponents() {
        spinner_disciplina = (Spinner) findViewById(R.id.spnDisciplinas);
        txt_professor = findViewById(R.id.editProfessor);
        txt_descricao = findViewById(R.id.editDescricao);
        txt_qtAlunos = findViewById(R.id.editQtd);
        txt_valor = findViewById(R.id.editValor);
        btnCadastrarAnuncio = findViewById(R.id.btnCadastrarAnuncio);
        btnCancelarAnuncio = findViewById(R.id.btnCadastrarAnuncio);

        novoAnuncio = new Anuncio();

        disciplinaController = new DisciplinaController(this);
        anuncioController = new AnuncioController(this);
    }
}

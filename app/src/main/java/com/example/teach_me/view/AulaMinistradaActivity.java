package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.InstituicaoController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AulaMinistradaActivity extends AppCompatActivity {

    TextView nmDisciplina, nmInstituicao, valor;
    ImageView imgUsuario;
    RecyclerView recyclerAlunosMatriculados;
    FloatingActionButton bt_deletarAnuncio;
    LinearLayout layout_avaliarProfessor;
    Button bt_enviar;
    EditText txt_titulo, txt_nota, txt_descricao;

    UsuarioController usuarioController;
    AnuncioController anuncioController;
    AulaController aulaController;
    DisciplinaController disciplinaController;
    InstituicaoController instituicaoController;

    Usuario professor;
    Aula aula;
    Anuncio anuncio;
    Disciplina disciplina;
    Instituicao instituicao;
    List<Aula> aulas;
    List<Aula> matriculados;
    int idAula;

    MatriculadosAdapter matriculadosAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_ministrada);
        initComponents();
        buttonsEvents();
        Intent intent = getIntent();
        idAula = Integer.parseInt(intent.getExtras().getString("Aula"));

        // Buscar objetos referentes
        try {
            aula = aulaController.get(idAula);
            anuncio = anuncioController.get(aula.getCdAnuncio());
            professor = usuarioController.get(anuncio.getCdUsuarioProfessor());
            disciplina = disciplinaController.get(anuncio.getCdDisciplina());
            instituicao = instituicaoController.get(professor.getCdInstituicao());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Caso a aula seja ministrada pelo usuario logado
        // irá aparecer o botão de excluir anuncio e não exibirá opção para avaliar o professor
        if(professor.getId().equals(usuarioController.getUsuarioLogado().getId())){
            layout_avaliarProfessor.setVisibility(View.INVISIBLE);
            bt_deletarAnuncio.setVisibility(View.VISIBLE);
        }else{
            layout_avaliarProfessor.setVisibility(View.VISIBLE);
            bt_deletarAnuncio.setVisibility(View.INVISIBLE);

            // Se o usuario ja tiver avaliado alguma vez, o botão ficará desativado
            if (aula.getIsAvaliado() == 1){
                bt_enviar.setEnabled(false);
            }else{
                bt_enviar.setEnabled(true);
            }
        }

        //Preenche os campos
        nmDisciplina.setText(disciplina.getNmDisciplina());
        nmInstituicao.setText(instituicao.getNmInstituicao());
        valor.setText(anuncio.getValor());
        Picasso.get().load(professor.getFoto()).into(imgUsuario);

        // Faz uma busca dos alunos que estão matriculados nesse anúncio
        for (Aula a:aulas){
            if(a.getCdAnuncio().equals(anuncio.getId())){
                matriculados.add(a);
            }
        }

        // Coloca os alunos matriculado em um recycler view
        matriculadosAdapter = new MatriculadosAdapter(this,matriculados);
        recyclerAlunosMatriculados.setAdapter(matriculadosAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerAlunosMatriculados.setLayoutManager(layoutManager);


    }

    private void initComponents(){
        nmDisciplina = findViewById(R.id.txt_disciplinaAulaMinistrada);
        nmInstituicao = findViewById(R.id.txt_instituicaoAulaMinistrada);
        valor = findViewById(R.id.txt_valorAulaMinistrada);
        imgUsuario = findViewById(R.id.img_usuarioAulaMinistrada);
        recyclerAlunosMatriculados = findViewById(R.id.recycleAlunosMatriculados);
        bt_deletarAnuncio = findViewById(R.id.bt_deletarAnuncio);
        layout_avaliarProfessor = findViewById(R.id.layout_avaliarProfessor);
        bt_enviar = findViewById(R.id.bt_enviarAvaliacao);
        txt_titulo = findViewById(R.id.editTextTituloAvaliacao);
        txt_nota = findViewById(R.id.editTextNotaAvaliacaco);
        txt_descricao = findViewById(R.id.editTextDescAvaliacao);

        usuarioController = UsuarioController.getInstance(this);
        anuncioController = AnuncioController.getInstance(this);
        aulaController = AulaController.getInstance(this);
        disciplinaController = DisciplinaController.getInstance(this);
        instituicaoController = InstituicaoController.getInstance(this);
        professor = new Usuario();
        aula = new Aula();
        anuncio = new Anuncio();
        disciplina = new Disciplina();
        instituicao = new Instituicao();
        aulas = aulaController.listar();
        matriculados = new ArrayList<>();
    }

    private void buttonsEvents(){

        bt_deletarAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AulaMinistradaActivity.this, "Impossível apagar: Há alunos matriculados!", Toast.LENGTH_LONG).show();
            }
        });

        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOK = true;

                if(TextUtils.isEmpty(txt_titulo.getText())){
                    isDadosOK = false;
                    txt_titulo.setError("Digite um título");
                    txt_titulo.requestFocus();
                }

                if(TextUtils.isEmpty(txt_nota.getText())){
                    isDadosOK = false;
                    txt_nota.setError("Digite um nota de 1 a 5");
                    txt_nota.requestFocus();
                }

                if(TextUtils.isEmpty(txt_descricao.getText())){
                    isDadosOK = false;
                    txt_descricao.setError("Digite uma descrição");
                    txt_descricao.requestFocus();
                }
                 double nota = Double.parseDouble(txt_nota.getText().toString());

                if(nota < 1 || nota > 5){
                    isDadosOK = false;
                    txt_nota.setError("A nota deve ser de 1 a 5");
                    txt_nota.requestFocus();
                }

                if (isDadosOK){
                    aula.setIsAvaliado(1);
                    aula.setTitulo(txt_titulo.getText().toString());
                    aula.setAvaliacao(nota);
                    aula.setDescricao(txt_descricao.getText().toString());
                    aulaController.alterar(aula);

                    Toast.makeText(AulaMinistradaActivity.this, "Avaliação enviada com sucesso!", Toast.LENGTH_LONG).show();
                    bt_enviar.setEnabled(false);
                }
            }
        });
    }
}

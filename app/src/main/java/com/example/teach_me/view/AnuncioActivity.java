package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnuncioActivity extends AppCompatActivity {

    ImageView imgProfessor;
    TextView txtNome, txtQtdAval, txtPreco, txtDescricao, txtDisciplina;
    Button btnPerfil, btnContratar;
    RatingBar rbAvaliacao;
    RecyclerView rv_avaliacoes;

    Anuncio anuncio;
    Usuario professor;
    Disciplina disciplina;
    String valor;
    List<Usuario> usuarios;
    List<Aula> aulas;
    List<Aula> avaliacoes;

    UsuarioController usuarioController;
    AulaController aulaController;
    AnuncioController anuncioController;
    DisciplinaController disciplinaController;

    AvaliacaoAdapter avaliacaoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio);

        Intent intent = getIntent();

        initComponents();

        // Pega o id do professor e do anúncio
        int idUsuario = intent.getExtras().getInt("Professor");
        int idAnuncio = Integer.parseInt(intent.getExtras().getString("idAnuncio"));

        // Busca o usuário autor do anuncio
        try {
            professor = usuarioController.get(intent.getExtras().getInt("Professor"));
            anuncio = anuncioController.get(idAnuncio);
            disciplina = disciplinaController.get(anuncio.getCdDisciplina());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Preenche os campos do anúncio
        txtNome.setText(professor.getNmUsuario());
        valor = intent.getExtras().getString("Valor");
        txtPreco.setText(valor);
        rbAvaliacao.setRating(Float.parseFloat(professor.getAvaliacao()));
        txtDisciplina.setText(disciplina.getNmDisciplina());
        txtDescricao.setText(anuncio.getDescricao());

        // É pra pegar a quantidade de avaliações do usuário
        //txtQtdAval.setText(intent.getExtras().getString("QtdAlunos"));

        // coloca a foto
        Picasso.get().load(professor.getFoto()).into(imgProfessor);

        // Faz uma busca de todas as avaliações referente a esse anúncio
        for (Aula aula:aulas){
            if(aula.getIsAvaliado() == 1 && aula.getCdAnuncio().equals(idAnuncio)){
                System.out.println(aula.getTitulo());
                avaliacoes.add(aula);
            }
        }

        // Faz a criação de um adapter para as avaliações utiliznando um layout linear na vertical
        avaliacaoAdapter = new AvaliacaoAdapter(this,avaliacoes);
        rv_avaliacoes.setAdapter(avaliacaoAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_avaliacoes.setLayoutManager(layoutManager);

        buttonsEvents(professor, idAnuncio);
    }

    private void initComponents(){
        imgProfessor = findViewById(R.id.img_perfil);
        txtNome = findViewById(R.id.txtProfessor);
        txtQtdAval = findViewById(R.id.txtQtdAval);
        txtPreco = findViewById(R.id.txtValorAnuncio);
        txtDescricao = findViewById(R.id.txt_descricaoAnuncio);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnContratar = findViewById(R.id.btnContratar);
        rbAvaliacao = findViewById(R.id.avaliacaoPerfil);
        txtDisciplina = findViewById(R.id.txt_disciplinaAnuncio);
        rv_avaliacoes = findViewById(R.id.recycleAvaliacoes);

        anuncio = new Anuncio();
        professor = new Usuario();
        usuarios = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        usuarioController = UsuarioController.getInstance(this);
        aulaController = AulaController.getInstance(this);
        anuncioController = AnuncioController.getInstance(this);
        disciplinaController = DisciplinaController.getInstance(this);
        aulas = aulaController.listar();
    }

    private void buttonsEvents(final Usuario u, final int idAnun){
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaPerfil = new Intent(AnuncioActivity.this, PerfilActivity.class);

                telaPerfil.putExtra("Foto", u.getFoto());
                telaPerfil.putExtra("NmUsuario", u.getNmUsuario());
                telaPerfil.putExtra("Avaliacao", u.getAvaliacao());
                telaPerfil.putExtra("Biografia", u.getDescricao());
                startActivity(telaPerfil);
            }
        });
        // Na verdade essa função deve inicializar uma nova janela com os dados da aula
        // La vamo dar um jeito do usuário escolher o horário e confirmar o contrato da aula
        // O layout em questão é o activity_contratar_aula
        btnContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaContratarAula = new Intent(AnuncioActivity.this, ContratarAulaActivity.class);
                telaContratarAula.putExtra("idAnuncio",String.valueOf(idAnun));
                telaContratarAula.putExtra("Valor",valor);
                startActivity(telaContratarAula);
//                Aula aula;
//                aula = new Aula();
//                aula.setCdAnuncio(idAnun);
//                aula.setCdUsuarioAluno(usuarioController.getUsuarioLogado().getId()); // pega a id do usuario logado
//                aula.setHorario("23M34"); // ???????????
//                aula.setIsAvaliado(0);
//                aulaController.incluir(aula);
            }
        });
    }
}

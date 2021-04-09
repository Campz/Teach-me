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

import com.example.teach_me.R;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnuncioActivity extends AppCompatActivity {

    ImageView imgProfessor;
    TextView txtNome, txtQtdAval, txtPreco, txtDescricao;
    Button btnPerfil, btnContratar;
    RatingBar rbAvaliacao;

    Anuncio anuncio;
    Usuario professor;
    List<Usuario> usuarios;

    UsuarioController usuarioController;
    AulaController aulaController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio);

        initComponents();

        Intent intent = getIntent();

        // Pega o id do professor e do anúncio
        int idUsuario = Integer.parseInt(intent.getExtras().getString("Professor"));
        int idAnuncio = Integer.parseInt(intent.getExtras().getString("idAnuncio"));

        // Preenche os campos do anúncio
        txtPreco.setText(intent.getExtras().getString("Valor"));
        rbAvaliacao.setRating(Float.parseFloat(intent.getExtras().getString("Avaliacao")));
        txtDescricao.setText(intent.getExtras().getString("Descricao"));
        txtQtdAval.setText(intent.getExtras().getString("QtdAlunos"));

        usuarios = usuarioController.listar();

        // busca no array de usuarios o usuario do anúncio
        for (Usuario u:usuarios) {
            if(u.getId() == idUsuario){
                professor = u;
                break;
            }
        }

        // coloca a foto
        Picasso.get().load(professor.getFoto()).into(imgProfessor);

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

        anuncio = new Anuncio();
        professor = new Usuario();
        usuarios = new ArrayList<>();
        usuarioController = UsuarioController.getInstance(this);
        aulaController = AulaController.getInstance(this);
    }

    private void buttonsEvents(final Usuario u, final int idAnun){
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaPerfil = new Intent(AnuncioActivity.this, MainActivity.class);

                telaPerfil.putExtra("Foto", u.getFoto());
                telaPerfil.putExtra("NmUsuario", u.getNmUsuario());
                telaPerfil.putExtra("Avaliacao", u.getAvaliacao());
                telaPerfil.putExtra("Biografia", u.getDescricao());
                startActivity(telaPerfil);
                finish();
            }
        });

        btnContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aula aula;

                aula = new Aula();
                aula.setCdAnuncio(idAnun);
                aula.setCdUsuarioAluno(3); // como pega a id do usuario logado ??????????
                aula.setHorario("23M34"); // ???????????
                aula.setIsAvaliado(0);
                aulaController.incluir(aula);
            }
        });
    }
}

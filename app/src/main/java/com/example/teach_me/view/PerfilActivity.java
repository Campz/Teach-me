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
import com.example.teach_me.controller.InstituicaoController;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity {
    CircleImageView img_perfil;
    TextView txt_NmUsuario, txt_biografia, txt_instituicao, txt_email;
    RatingBar avaliacao;
    InstituicaoController instituicaoController;
    Button bt_sair;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);
        initComponents();

        Intent intent = getIntent();
        Picasso.get().load(intent.getExtras().getString("Foto")).into(img_perfil);
        txt_NmUsuario.setText(intent.getExtras().getString("NmUsuario"));
        avaliacao.setRating(Float.parseFloat(intent.getExtras().getString("Avaliacao")));
        txt_biografia.setText(intent.getExtras().getString("Biografia"));
        bt_sair.setVisibility(View.INVISIBLE);
        try {
            txt_instituicao.setText(instituicaoController.get(Integer.parseInt(intent.getExtras().getString("Instituicao"))).getNmInstituicao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        img_perfil = findViewById(R.id.img_perfil);
        txt_NmUsuario = findViewById(R.id.txt_nomePerfil);
        avaliacao = findViewById(R.id.avaliacaoPerfil);
        txt_biografia = findViewById(R.id.txt_biografiaPerfil);
        txt_instituicao = findViewById(R.id.txt_nmLocal);
        txt_email = findViewById(R.id.txt_nmCurso);
        bt_sair = findViewById(R.id.bt_sair);
        instituicaoController = InstituicaoController.getInstance(this);
    }
}

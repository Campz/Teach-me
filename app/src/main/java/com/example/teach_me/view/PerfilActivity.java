package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;
import com.squareup.picasso.Picasso;

public class PerfilActivity extends AppCompatActivity {
    ImageView img_perfil;
    TextView txt_NmUsuario;
    RatingBar avaliacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);
        initComponents();

        Intent intent = getIntent();
        Picasso.get().load(intent.getExtras().getString("Foto")).into(img_perfil);
        txt_NmUsuario.setText(intent.getExtras().getString("NmUsuario"));
        avaliacao.setRating(Float.parseFloat(intent.getExtras().getString("Avaliacao")));

    }

    private void initComponents() {
        img_perfil = findViewById(R.id.img_perfil);
        txt_NmUsuario = findViewById(R.id.textView);
        avaliacao = findViewById(R.id.ratingBar_avaliacao);
    }
}

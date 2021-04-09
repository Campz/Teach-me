package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;

public class AulaMinistradaActivity extends AppCompatActivity {

    TextView nmDisciplina, nmInstituicao, valor;
    ImageView imgUsuario;
    RecyclerView recyclerAlunosMatriculados;

    int idAula;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_ministrada);
        initComponents();
        Intent intent = getIntent();
        idAula = Integer.parseInt(intent.getExtras().getString("Aula"));
    }

    private void initComponents(){
        nmDisciplina = findViewById(R.id.txt_disciplinaAulaMinistrada);
        nmInstituicao = findViewById(R.id.txt_instituicaoAulaMinistrada);
        valor = findViewById(R.id.txt_valorAulaMinistrada);
        imgUsuario = findViewById(R.id.img_usuarioAulaMinistrada);
        recyclerAlunosMatriculados = findViewById(R.id.recycleAlunosMatriculados);
    }
}

package com.example.teach_me.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.model.Anuncio;

import java.util.ArrayList;
import java.util.List;

public class ResultadosActivity extends AppCompatActivity {
    List<Anuncio> resultados;
    AnuncioController anuncioController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        anuncioController = new AnuncioController(this);
        resultados = anuncioController.listar();
        RecyclerView rv_anuncios = findViewById(R.id.rv_resultados);
        ResultadosAdapter resultadosAdapter = new ResultadosAdapter(this,resultados);
        rv_anuncios.setAdapter(resultadosAdapter);
        rv_anuncios.setLayoutManager(new GridLayoutManager(this,2));
    }
}

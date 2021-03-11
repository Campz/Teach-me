package com.example.teach_me.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.models.Anuncio;

import java.util.ArrayList;

public class ResultadosActivity extends AppCompatActivity {
    ArrayList<Anuncio> resultados;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        resultados = Repositorio.getInstance().getAnuncios();
        RecyclerView rv_anuncios = findViewById(R.id.rv_resultados);
        ResultadosAdapter resultadosAdapter = new ResultadosAdapter(this,resultados);
        rv_anuncios.setAdapter(resultadosAdapter);
        rv_anuncios.setLayoutManager(new GridLayoutManager(this,2));
    }
}

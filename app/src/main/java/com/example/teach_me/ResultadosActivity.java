package com.example.teach_me;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.models.Anuncio;

import java.util.ArrayList;

public class ResultadosActivity extends AppCompatActivity {
    ArrayList<Anuncio> resultados;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        
    }
}

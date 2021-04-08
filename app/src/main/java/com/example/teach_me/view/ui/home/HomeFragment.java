package com.example.teach_me.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.view.DestaquesAdapter;
import com.example.teach_me.R;
import com.example.teach_me.view.LoginActivity;
import com.example.teach_me.view.MainActivity;
import com.example.teach_me.view.NovoAnuncioActivity;
import com.example.teach_me.view.Repositorio;
import com.example.teach_me.view.ResultadosAdapter;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View root;

    List<Usuario> destaques;
    List<Anuncio> anuncios;

    DestaquesAdapter destaquesAdapter;
    ResultadosAdapter anunciosAdapter;

    UsuarioController usuarioController;
    AnuncioController anuncioController;

    RecyclerView lista_destaques;
    RecyclerView lista_anuncios;
    TextView txt_professores;
    Button bt_buscar;
    FloatingActionButton bt_novo_anuncio;

    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
        //        textView.setText(s);
            }
        });
        initComponents();
        buttonsEvents();

        destaques = usuarioController.listar();

        destaquesAdapter = new DestaquesAdapter(getContext(),destaques);
        lista_destaques.setAdapter(destaquesAdapter);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(RecyclerView.HORIZONTAL);
        lista_destaques.setLayoutManager(layout);

//        anuncios = anuncioController.listar();
//
//        anunciosAdapter  = new ResultadosAdapter(getContext(),anuncios);
//        lista_anuncios.setAdapter(anunciosAdapter);
//        lista_anuncios.setLayoutManager(new GridLayoutManager(getContext(),2));

        return root;
    }

    private void buttonsEvents() {
        bt_novo_anuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NovoAnuncioActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        lista_destaques = root.findViewById(R.id.lista_destaques);
        lista_anuncios = root.findViewById(R.id.rv_aulasRecentes);
        txt_professores = root.findViewById(R.id.txt_professores);
        bt_buscar = root.findViewById(R.id.bt_buscar);
        bt_novo_anuncio = root.findViewById(R.id.bt_novo_anuncio);

        usuarioController = UsuarioController.getInstance(getContext());
        anuncioController = AnuncioController.getInstance(getContext());
    }
}

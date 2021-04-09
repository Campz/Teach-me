package com.example.teach_me.view.ui.aulas;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Usuario;
import com.example.teach_me.view.AulasAdapter;

import java.util.ArrayList;
import java.util.List;

public class AulasFragment extends Fragment {

    private AulasViewModel mViewModel;
    View root;
    RecyclerView rv_minhasAulas;
    RecyclerView rv_aulasMinistradas;
    AulasAdapter minhasAulasAdapter;
    AulasAdapter aulasMinistradasAdapter;
    List<Aula> aulas;
    List<Aula> minhasAulas;
    List<Aula> aulasMinistradas;
    AulaController aulaController;
    UsuarioController usuarioController;
    AnuncioController anuncioController;
    Usuario usuarioLogado;

    public static AulasFragment newInstance() {
        return new AulasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_aulas, container, false);
        initComponents();
        // Se existir algum usuário logado
        aulas = aulaController.listar();
        if(usuarioController.isLogado()) {
            // Pega a lista de aulas em que o usuário logado está cadastrado e ministra
            for (Aula aula : aulas) {
                if (aula.getCdUsuarioAluno().equals(usuarioLogado.getId())){
                    minhasAulas.add(aula);
                }
                try {
                    if (anuncioController.get(aula.getCdAnuncio()).getCdUsuarioProfessor().equals(usuarioLogado.getId())){
                        aulasMinistradas.add(aula);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Cria um adapter para a recycler view e adciona um layout vertical para ela
            minhasAulasAdapter = new AulasAdapter(getContext(),minhasAulas);
            rv_minhasAulas.setAdapter(minhasAulasAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            rv_minhasAulas.setLayoutManager(layoutManager);

            aulasMinistradasAdapter = new AulasAdapter(getContext(), aulasMinistradas);
            rv_aulasMinistradas.setAdapter(aulasMinistradasAdapter);
            LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
            layoutManager1.setOrientation(RecyclerView.VERTICAL);
            rv_aulasMinistradas.setLayoutManager(layoutManager1);
        }

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AulasViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initComponents(){
        rv_minhasAulas = root.findViewById(R.id.rc_minhasAulas);
        rv_aulasMinistradas = root.findViewById(R.id.rc_aulasMinistradas);
        aulaController = AulaController.getInstance(getContext());
        aulas = new ArrayList<>();
        minhasAulas = new ArrayList<>();
        aulasMinistradas = new ArrayList<>();
        usuarioController = UsuarioController.getInstance(getContext());
        anuncioController = AnuncioController.getInstance(getContext());
        usuarioLogado = usuarioController.getUsuarioLogado();
    }

}

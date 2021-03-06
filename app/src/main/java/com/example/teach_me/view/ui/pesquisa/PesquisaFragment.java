package com.example.teach_me.view.ui.pesquisa;

import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.InstituicaoController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.datamodel.AnuncioDataModel;
import com.example.teach_me.datamodel.DisciplinaDataModel;
import com.example.teach_me.datamodel.InstituicaoDataModel;
import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Usuario;
import com.example.teach_me.view.LoginActivity;
import com.example.teach_me.view.RegistroActivity;
import com.example.teach_me.view.ResultadosActivity;
import com.example.teach_me.view.ResultadosAdapter;

import java.util.ArrayList;
import java.util.List;

public class PesquisaFragment extends Fragment {

    View root;
    private PesquisaViewModel mViewModel;

    TextView txtDisciplina, txtInstituicao;
    Button btnBuscar;
    RecyclerView rv_anuncioDestaque;

    AnuncioController anuncioController;
    UsuarioController usuarioController;
    DisciplinaController disciplinaController;
    InstituicaoController instituicaoController;

    List<Anuncio> anuncios;
    List<Usuario> usuarios;
    List<Disciplina> disciplinas;
    List<Instituicao> instituicoes;

    ResultadosAdapter resultadosAdapter;

    public static PesquisaFragment newInstance() {
        return new PesquisaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        initComponents();
        buttonsEvents();

        rv_anuncioDestaque.setAdapter(resultadosAdapter);
        rv_anuncioDestaque.setLayoutManager(new GridLayoutManager(getContext(),2));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PesquisaViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initComponents(){
        btnBuscar = root.findViewById(R.id.bt_buscar);
        txtDisciplina = root.findViewById(R.id.editText_disciplina);
        txtInstituicao = root.findViewById(R.id.editText_instituicao);
        rv_anuncioDestaque = root.findViewById(R.id.rv_anunciosDestaques);

        anuncioController = AnuncioController.getInstance(getContext());
        usuarioController = UsuarioController.getInstance(getContext());
        disciplinaController = DisciplinaController.getInstance(getContext());
        instituicaoController = InstituicaoController.getInstance(getContext());
        anuncios = anuncioController.listar();
        usuarios = usuarioController.listar();
        disciplinas = disciplinaController.listar();
        instituicoes = instituicaoController.listar();
        resultadosAdapter = new ResultadosAdapter(getContext(),anuncios);
    }

    private void buttonsEvents(){

        // Realiza uma busca e inicia uma nova intent com os resultados
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultadosActivity.class);
                startActivity(intent);


                boolean isDadosOK = true;

                if(TextUtils.isEmpty(txtDisciplina.getText())){
                    isDadosOK = false;
                    txtDisciplina.setError("Digite o nome da matéria");
                    txtDisciplina.requestFocus();
                }

                if(TextUtils.isEmpty(txtInstituicao.getText())){
                    isDadosOK = false;
                    txtInstituicao.setError("Digite uma instituição");
                    txtInstituicao.requestFocus();
                }

                if(isDadosOK){
                    Disciplina disciplina = new Disciplina();
                    disciplina.setNmDisciplina("Erro");
                    disciplina.setId(-1);

                    Instituicao instituicao = new Instituicao();
                    instituicao.setId(-1);

                    List<Usuario> usuarios_inst = new ArrayList<>();

                    //Busca o objeto disciplina
                    for (Disciplina d: disciplinas){
                        if(d.getNmDisciplina().equalsIgnoreCase(txtDisciplina.getText().toString())){
                            disciplina = d;
                            break;
                        }
                    }

                    //Busca o objeto Instituicao
                    for (Instituicao i: instituicoes){
                        if(i.getNmInstituicao().equalsIgnoreCase(txtInstituicao.getText().toString())){
                            instituicao = i;
                            break;
                        }
                    }

                    //Busca os usuários de outras instituicoes
                    for (Usuario u: usuarios){
                        if(u.getCdInstituicao() != instituicao.getId()){
                            usuarios_inst.add(u);
                        }
                    }

                    // remove anúncios de outras disciplinas
                    for (Anuncio a: anuncios){
                        if(a.getCdDisciplina() !=  disciplina.getId()){
                            anuncios.remove(a);
                        }
                    }

                    // remove anúncios de outras instituicoes
                    for (Anuncio a: anuncios){
                        for(Usuario u: usuarios_inst){
                            if(a.getCdUsuarioProfessor() == u.getCdInstituicao()){
                                anuncios.remove(a);
                            }
                        }
                    }

                }else{
                    Toast.makeText(root.getContext(), "Preencha os campos de busca!", Toast.LENGTH_LONG).show();
                }

                if(anuncios.size() == 0){
                    Toast.makeText(getContext(), "Nenhum registro encontrado!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "GGGGGGGGGGGGG!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

package com.example.teach_me.view.ui.pesquisa;

import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

import java.util.ArrayList;
import java.util.List;

public class PesquisaFragment extends Fragment {

    private PesquisaViewModel mViewModel;

    TextView txtDisciplina, txtInstituicao;
    Button btnBuscar;

    AnuncioController anuncioController;
    UsuarioController usuarioController;
    DisciplinaController disciplinaController;
    InstituicaoController instituicaoController;

    List<Anuncio> anuncios;
    List<Usuario> usuarios;
    List<Disciplina> disciplinas;
    List<Instituicao> instituicoes;


    public static PesquisaFragment newInstance() {
        return new PesquisaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        btnBuscar = root.findViewById(R.id.bt_buscar);
        txtDisciplina = root.findViewById(R.id.editText_disciplina);
        txtInstituicao = root.findViewById(R.id.editText_instituicao);

        anuncioController = AnuncioController.getInstance(root.getContext());
        usuarioController = UsuarioController.getInstance(root.getContext());
        disciplinaController = DisciplinaController.getInstance(root.getContext());
        instituicaoController = InstituicaoController.getInstance(root.getContext());

        /*anuncios = anuncioController.getAllAnuncios(AnuncioDataModel.TABELA);
        usuarios = usuarioController.getAllUsuarios(UsuarioDataModel.TABELA);
        disciplinas = disciplinaController.getAllDisciplinas(DisciplinaDataModel.TABELA);
        instituicoes = instituicaoController.getAllInstituicoes(InstituicaoDataModel.TABELA);*/

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultadosActivity.class);
                startActivity(intent);

                anuncios = anuncioController.listar();
                usuarios = usuarioController.listar();
                disciplinas = disciplinaController.listar();
                instituicoes = instituicaoController.listar();

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
                    Toast.makeText(root.getContext(), "Nenhum registro encontrado!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(root.getContext(), "GGGGGGGGGGGGG!", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PesquisaViewModel.class);
        // TODO: Use the ViewModel
    }
}

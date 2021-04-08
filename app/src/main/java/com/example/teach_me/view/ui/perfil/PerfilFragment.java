package com.example.teach_me.view.ui.perfil;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.teach_me.R;
import com.example.teach_me.controller.InstituicaoController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Usuario;
import com.example.teach_me.view.LoginActivity;
import com.example.teach_me.view.MainActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    View root;
    UsuarioController usuarioController;
    InstituicaoController instituicaoController;

    CircleImageView img_perfil;
    RatingBar avaliacaoPerfil;
    TextView txt_nomePerfil, txt_idade, txt_curso, txt_instituicao, txt_biografia;
    Button bt_sair;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_perfil, container, false);
        initComponents();
        buttonsEvents();
        // Caso exista um usuário logado
        if(usuarioController.isLogado()){
            Usuario usuarioLogado = usuarioController.getUsuarioLogado();
            Picasso.get().load(usuarioLogado.getFoto()).into(img_perfil);
            avaliacaoPerfil.setRating(Float.parseFloat(usuarioLogado.getAvaliacao()));
            txt_nomePerfil.setText(usuarioLogado.getNmUsuario());
            try {
                txt_instituicao.setText(instituicaoController.get(usuarioLogado.getCdInstituicao()).getNmInstituicao());
            } catch (Exception e) {
                e.printStackTrace();
            }
            txt_biografia.setText(usuarioLogado.getDescricao());
        }
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        // TODO: Use the ViewModel
    }

    private void buttonsEvents(){
        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioController.setUsuarioLogado(null);
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents(){
        img_perfil = root.findViewById(R.id.img_perfil);
        avaliacaoPerfil = root.findViewById(R.id.avaliacaoPerfil);
        txt_nomePerfil = root.findViewById(R.id.txt_nomePerfil);
        txt_idade = root.findViewById(R.id.txt_idade);
        txt_curso = root.findViewById(R.id.txt_nmCurso);
        txt_instituicao = root.findViewById(R.id.txt_nmLocal);
        txt_biografia = root.findViewById(R.id.txt_biografiaPerfil);
        bt_sair = root.findViewById(R.id.bt_sair);
        usuarioController = UsuarioController.getInstance(getContext());
        instituicaoController = InstituicaoController.getInstance(getContext());
    }

}

package com.example.teach_me.view.ui.pesquisa;

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

import com.example.teach_me.R;
import com.example.teach_me.view.ResultadosActivity;

public class PesquisaFragment extends Fragment {

    private PesquisaViewModel mViewModel;

    public static PesquisaFragment newInstance() {
        return new PesquisaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        Button bt_pesquisar = root.findViewById(R.id.bt_buscar);
        bt_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultadosActivity.class);
                startActivity(intent);
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

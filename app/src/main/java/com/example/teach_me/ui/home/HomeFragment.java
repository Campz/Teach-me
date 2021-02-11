package com.example.teach_me.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.DestaquesAdapter;
import com.example.teach_me.R;
import com.example.teach_me.Repositorio;
import com.example.teach_me.RetrofitClientInstance;
import com.example.teach_me.models.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    ArrayList<Usuario> destaques;
    DestaquesAdapter destaquesAdapter;

    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
        //        textView.setText(s);
            }
        });

        destaques = Repositorio.getInstance().getUsuarios();
        RecyclerView lista_destaques = root.findViewById(R.id.lista_destaques);
        destaquesAdapter = new DestaquesAdapter(getContext(),destaques);
        lista_destaques.setAdapter(destaquesAdapter);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(RecyclerView.HORIZONTAL);
        lista_destaques.setLayoutManager(layout);

        final TextView txt_professores = root.findViewById(R.id.txt_professores);

        Button bt_buscar = root.findViewById(R.id.bt_buscar);
        bt_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuario> call = new RetrofitClientInstance().getUsuarioService().buscarUsuario("1");
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Usuario usu = response.body();
                        System.out.println(usu.getData().getAvaliacao());
                        Toast.makeText(root.getContext(), "deu bom", Toast.LENGTH_SHORT).show();
                        txt_professores.setText(usu.getData().getNmUsuario());
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(root.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return root;
    }
}

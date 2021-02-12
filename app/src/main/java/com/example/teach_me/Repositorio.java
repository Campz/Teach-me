package com.example.teach_me;

import android.util.Log;
import android.widget.Toast;

import com.example.teach_me.api.UsuarioData;
import com.example.teach_me.models.Anuncio;
import com.example.teach_me.models.Disciplina;
import com.example.teach_me.models.Tipo;
import com.example.teach_me.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {
    private static Repositorio repositorio;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Anuncio> anuncios;

    private Repositorio(){
        this.usuarios = new ArrayList<>();
        this.anuncios = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (repositorio == null){
            return new Repositorio();
        }else{
            return  repositorio;
        }
    }

    public ArrayList<Usuario> getUsuarios(){
        Call<List<Usuario>> call = new RetrofitClientInstance().getUsuarioService().buscarListUsuario("0");
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
               if(response.isSuccessful()){
                   usuarios = new ArrayList<>(response.body());
                   Log.w("OPA", usuarios.get(0).getData().getEmail());
               }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
            }
        });
        return usuarios;
    }

    public ArrayList<Anuncio> getAnuncios(){
        Call<List<Anuncio>> call = new RetrofitClientInstance().getAnuncioService().buscarListAnuncio("1");
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                if(response.isSuccessful()){
                    anuncios = new ArrayList<>(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
            }
        });
        return anuncios;
    }
}

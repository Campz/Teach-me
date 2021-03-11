package com.example.teach_me.api;

import com.example.teach_me.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsuarioService {
    @GET("usuario/{usuario}")
    Call<Usuario> buscarUsuario(@Path("usuario") String usuario);

    @GET("usuario/{usuario}")
    Call<List<Usuario>> buscarListUsuario(@Path("usuario") String usuario);
}

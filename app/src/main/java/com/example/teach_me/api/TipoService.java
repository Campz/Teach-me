package com.example.teach_me.api;

import com.example.teach_me.models.Instituicao;
import com.example.teach_me.models.Tipo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TipoService {
    @GET("tipo/{tipo}")
    Call<Tipo> buscarTipo(@Path("tipo") String tipo);
}

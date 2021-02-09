package com.example.teach_me.api;
import com.example.teach_me.models.Instituicao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InstituicaoService {
    @GET("api/instituicaos")
    Call<Instituicao> buscarInstituicao(String instituicao);
}

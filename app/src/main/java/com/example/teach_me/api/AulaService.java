package com.example.teach_me.api;

import com.example.teach_me.model.Aula;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AulaService {
    @GET("aula/{aula}")
    Call<Aula> buscarAula(@Path("aula") String aula);
}

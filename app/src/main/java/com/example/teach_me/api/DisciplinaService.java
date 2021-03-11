package com.example.teach_me.api;

import com.example.teach_me.model.Disciplina;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DisciplinaService {
    @GET("disciplina/{disciplina}")
    Call<Disciplina> buscarDisciplina(@Path("disciplina") String disciplina);
}

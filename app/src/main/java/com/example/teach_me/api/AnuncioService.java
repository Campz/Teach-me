package com.example.teach_me.api;

import com.example.teach_me.models.Anuncio;
import com.example.teach_me.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnuncioService {
    @GET("anuncio/{anuncio}")
    Call<Anuncio> buscarAnuncio(@Path("anuncio") String anuncio);

    @GET("anuncio/{anuncio}/")
    Call<List<Anuncio>> buscarListAnuncio(@Path("anuncio") String anuncio);
}

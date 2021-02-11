package com.example.teach_me;
import com.example.teach_me.api.AnuncioService;
import com.example.teach_me.api.AulaService;
import com.example.teach_me.api.DisciplinaService;
import com.example.teach_me.api.InstituicaoService;
import com.example.teach_me.api.TipoService;
import com.example.teach_me.api.UsuarioService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://teachme-apirest.herokuapp.com/api/";

    public RetrofitClientInstance() {
        retrofit = new retrofit2.Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

    }

    public InstituicaoService getInstituicaoService() {
        return retrofit.create(InstituicaoService.class);
    }

    public AnuncioService getAnuncioService() {
        return retrofit.create(AnuncioService.class);
    }

    public AulaService getAulaService() {
        return retrofit.create(AulaService.class);
    }

    public DisciplinaService getDisciplinaService() {
        return retrofit.create(DisciplinaService.class);
    }

    public TipoService getTipoService() {
        return retrofit.create(TipoService.class);
    }

    public UsuarioService getUsuarioService() {
        return retrofit.create(UsuarioService.class);
    }
}

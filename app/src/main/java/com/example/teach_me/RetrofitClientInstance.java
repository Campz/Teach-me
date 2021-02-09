package com.example.teach_me;
import com.example.teach_me.api.AnuncioService;
import com.example.teach_me.api.AulaService;
import com.example.teach_me.api.DisciplinaService;
import com.example.teach_me.api.InstituicaoService;
import com.example.teach_me.api.TipoService;
import com.example.teach_me.api.UsuarioService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://teachme-apirest.herokuapp.com/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public InstituicaoService getInstituicaoService() {
        return this.retrofit.create(InstituicaoService.class);
    }

    public AnuncioService getAnuncioService() {
        return this.retrofit.create(AnuncioService.class);
    }

    public AulaService getAulaService() {
        return this.retrofit.create(AulaService.class);
    }

    public DisciplinaService getDisciplinaService() {
        return this.retrofit.create(DisciplinaService.class);
    }

    public TipoService getTipoService() {
        return this.retrofit.create(TipoService.class);
    }

    public UsuarioService getUsuarioService() {
        return this.retrofit.create(UsuarioService.class);
    }
}

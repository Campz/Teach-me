package com.example.teach_me;

import com.example.teach_me.models.Anuncio;
import com.example.teach_me.models.Aula;
import com.example.teach_me.models.Disciplina;
import com.example.teach_me.models.Instituicao;
import com.example.teach_me.models.Tipo;
import com.example.teach_me.models.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {
    private static Repositorio repositorio;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<Aula> aulas;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Tipo> tipos;
    private ArrayList<Instituicao> instituicoes;

    private Repositorio(){
        this.usuarios = new ArrayList<>();
        this.anuncios = new ArrayList<>();
        this.aulas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.instituicoes = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (repositorio == null){
            return new Repositorio();
        }else{
            return  repositorio;
        }
    }

    public ArrayList<Usuario> getUsuarios(){
        /*Call<List<Usuario>> call = new RetrofitClientInstance().getUsuarioService().buscarListUsuario("1");
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
               if(response.isSuccessful()){
                   for (int i = 0; i < 5; i++) {
                       usuarios.add(response.body().get(i));
                   }
                   System.out.println(usuarios.get(0).getData().toString());
                   //usuarios = new ArrayList<>(response.body());
               }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
            }
        });*/
        for (int i = 1; i <= 5; i++){
            String aux = Integer.toString(i);
            Call<Usuario> call = new RetrofitClientInstance().getUsuarioService().buscarUsuario(aux);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Usuario usu = response.body();
                        usuarios.add(usu);
                        System.out.println(usuarios.get(0).getData().toString());
                }
                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                }
            });
        }

        return usuarios;
    }

    public ArrayList<Anuncio> getAnuncios(){
        for (int i = 9; i <= 12; i++){
            String aux = Integer.toString(i);
            Call<Anuncio> call = new RetrofitClientInstance().getAnuncioService().buscarAnuncio(aux);
            call.enqueue(new Callback<Anuncio>() {
                @Override
                public void onResponse(Call<Anuncio> call, Response<Anuncio> response) {
                    Anuncio a = response.body();
                    anuncios.add(a);
                }
                @Override
                public void onFailure(Call<Anuncio> call, Throwable t) {
                }
            });
        }
        return anuncios;
    }

    public ArrayList<Aula> getAulas(){
        for (int i = 7; i <= 11; i++){
            String aux = Integer.toString(i);
            Call<Aula> call = new RetrofitClientInstance().getAulaService().buscarAula(aux);
            call.enqueue(new Callback<Aula>() {
                @Override
                public void onResponse(Call<Aula> call, Response<Aula> response) {
                    Aula a = response.body();
                    aulas.add(a);
                }
                @Override
                public void onFailure(Call<Aula> call, Throwable t) {
                }
            });
        }
        return aulas;
    }

    public ArrayList<Disciplina> getDisciplinas(){
        for (int i = 1; i <= 6; i++){
            String aux = Integer.toString(i);
            Call<Disciplina> call = new RetrofitClientInstance().getDisciplinaService().buscarDisciplina(aux);
            call.enqueue(new Callback<Disciplina>() {
                @Override
                public void onResponse(Call<Disciplina> call, Response<Disciplina> response) {
                    Disciplina d = response.body();
                    disciplinas.add(d);
                }
                @Override
                public void onFailure(Call<Disciplina> call, Throwable t) {
                }
            });
        }
        return disciplinas;
    }

    public ArrayList<Instituicao> getInstituicoes(){
        for (int i = 1; i <= 2; i++){
            String aux = Integer.toString(i);
            Call<Instituicao> call = new RetrofitClientInstance().getInstituicaoService().buscarInstituicao(aux);
            call.enqueue(new Callback<Instituicao>() {
                @Override
                public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                    Instituicao inst = response.body();
                    instituicoes.add(inst);
                }
                @Override
                public void onFailure(Call<Instituicao> call, Throwable t) {
                }
            });
        }
        return instituicoes;
    }

    public ArrayList<Tipo> getTipos(){
        for (int i = 1; i <= 3; i++){
            String aux = Integer.toString(i);
            Call<Tipo> call = new RetrofitClientInstance().getTipoService().buscarTipo(aux);
            call.enqueue(new Callback<Tipo>() {
                @Override
                public void onResponse(Call<Tipo> call, Response<Tipo> response) {
                    Tipo t = response.body();
                    tipos.add(t);
                }
                @Override
                public void onFailure(Call<Tipo> call, Throwable t) {
                }
            });
        }
        return tipos;
    }
}

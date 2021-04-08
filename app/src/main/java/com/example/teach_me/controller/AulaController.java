package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.teach_me.datamodel.AulaDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Aula;

import java.util.List;

public class AulaController extends AppDataBase implements ICRUD<Aula> {

    ContentValues dados;
    private static AulaController aulaController;

    private AulaController(Context context) {
        super(context);
    }

    public static AulaController getInstance(Context context){
        if (aulaController == null){
            aulaController = new AulaController(context);
        }
        return aulaController;
    }

    @Override
    public boolean incluir(Aula o) {
        dados = new ContentValues();
        dados.put(AulaDataModel.CDUSUARIOALUNO, o.getCdUsuarioAluno());
        dados.put(AulaDataModel.CDANUNCIO, o.getCdAnuncio());
        dados.put(AulaDataModel.HORARIO, o.getHorario());
        dados.put(AulaDataModel.TITULO, o.getTitulo());
        dados.put(AulaDataModel.DESCRICAO, o.getDescricao());
        dados.put(AulaDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(AulaDataModel.ISAVALIADO, o.getIsAvaliado());
        return insert(AulaDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Aula o) {
        dados = new ContentValues();
        dados.put(AulaDataModel.ID, o.getId());
        dados.put(AulaDataModel.CDUSUARIOALUNO, o.getCdUsuarioAluno());
        dados.put(AulaDataModel.CDANUNCIO, o.getCdAnuncio());
        dados.put(AulaDataModel.HORARIO, o.getHorario());
        dados.put(AulaDataModel.TITULO, o.getTitulo());
        dados.put(AulaDataModel.DESCRICAO, o.getDescricao());
        dados.put(AulaDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(AulaDataModel.ISAVALIADO, o.getIsAvaliado());
        return update(AulaDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(AulaDataModel.TABELA, id);
    }

    @Override
    public List<Aula> listar() {
        return getAllAulas(AulaDataModel.TABELA);
    }

    @Override
    public Aula get(Integer id) throws Exception {
        return getAulaById(AulaDataModel.TABELA, id);
    }
}

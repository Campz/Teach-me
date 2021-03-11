package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;
import com.example.teach_me.datamodel.AnuncioDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Anuncio;

import java.util.List;

public class AnuncioController extends AppDataBase implements ICRUD<Anuncio> {

    ContentValues dados;

    public AnuncioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Anuncio o) {
        dados = new ContentValues();
        dados.put(AnuncioDataModel.QTDALUNOS, o.getQtdAlunos());
        dados.put(AnuncioDataModel.DESCRICAO, o.getDescricao());
        dados.put(AnuncioDataModel.CDDISCIPLINA, o.getCdDisciplina());
        dados.put(AnuncioDataModel.CDUSUARIOPROFESSOR, o.getCdUsuarioProfessor());
        dados.put(AnuncioDataModel.VALOR, o.getValor());
        return insert(AnuncioDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Anuncio o) {
        dados = new ContentValues();
        dados.put(AnuncioDataModel.ID, o.getId());
        dados.put(AnuncioDataModel.QTDALUNOS, o.getQtdAlunos());
        dados.put(AnuncioDataModel.DESCRICAO, o.getDescricao());
        dados.put(AnuncioDataModel.CDDISCIPLINA, o.getCdDisciplina());
        dados.put(AnuncioDataModel.CDUSUARIOPROFESSOR, o.getCdUsuarioProfessor());
        dados.put(AnuncioDataModel.VALOR, o.getValor());
        return update(AnuncioDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(AnuncioDataModel.TABELA, id);
    }

    @Override
    public List<Anuncio> listar() {
        return getAllAnuncio(AnuncioDataModel.TABELA);
    }
}

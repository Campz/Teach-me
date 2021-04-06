package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import com.example.teach_me.datamodel.DisciplinaDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Disciplina;

public class DisciplinaController extends AppDataBase implements ICRUD<Disciplina> {

    ContentValues dados;
    private static DisciplinaController disciplinaController;

    public DisciplinaController(Context context) {
        super(context);
    }


    public static DisciplinaController getInstance(Context context){
        if (disciplinaController == null){
            disciplinaController = new DisciplinaController(context);
            return disciplinaController;
        }else{
            return  disciplinaController;
        }
    }

    @Override
    public boolean incluir(Disciplina o) {
        dados = new ContentValues();
        dados.put(DisciplinaDataModel.NMDISCIPLINA, o.getNmDisciplina());
        dados.put(DisciplinaDataModel.CDTIPO, o.getCdTipo());
        return insert(DisciplinaDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Disciplina o) {
        dados = new ContentValues();
        dados.put(DisciplinaDataModel.ID, o.getId());
        dados.put(DisciplinaDataModel.NMDISCIPLINA, o.getNmDisciplina());
        dados.put(DisciplinaDataModel.CDTIPO, o.getCdTipo());
        return update(DisciplinaDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(DisciplinaDataModel.TABELA, id);
    }

    @Override
    public List<Disciplina> listar() {
        return getAllDisciplinas(DisciplinaDataModel.TABELA);
    }

    public Disciplina getDisciplina(Integer id) throws Exception {
        return getDisciplinaById(DisciplinaDataModel.TABELA, id);
    }
}

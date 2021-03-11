package com.example.teach_me.datamodel;

public class DisciplinaDataModel {
    public static final String TABELA = "disciplina";

    public static final String ID = "id";
    public static final String NMDISCIPLINA = "nmDisciplina";
    public static final String CDTIPO = "cdTipo";

    public static  String query_criar_tabela = "";

    public static String criarTabela() {
        query_criar_tabela += "CREATE TABLE " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += NMDISCIPLINA + " text, ";
        query_criar_tabela += CDTIPO + " text";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }
}

package com.example.teach_me.datamodel;

public class AnuncioDataModel {

    public static final String TABELA = "anuncio";

    public static final String ID = "id";
    public static final String QTDALUNOS = "qtdAlunos";
    public static final String DESCRICAO = "descricao";
    public static final String CDDISCIPLINA = "cdDisciplina";
    public static final String CDUSUARIOPROFESSOR = "cdUsuarioProfessor";
    public static final String VALOR = "valor";

    public static  String query_criar_tabela = "";

    public static String criarTabela(){
        query_criar_tabela += "CREATE TABLE " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += QTDALUNOS + " text, ";
        query_criar_tabela += DESCRICAO + " text";
        query_criar_tabela += CDDISCIPLINA + " text";
        query_criar_tabela += CDUSUARIOPROFESSOR + " text";
        query_criar_tabela += VALOR + " text";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }


}

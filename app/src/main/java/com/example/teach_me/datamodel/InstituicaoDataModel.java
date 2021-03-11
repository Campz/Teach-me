package com.example.teach_me.datamodel;

public class InstituicaoDataModel {
    public static final String TABELA = "instituicao";

    public static final String ID = "id";
    public static final String NMINSTITUICAO = "nmInstituicao";
    public static final String ENDERECO = "endereco";

    public static  String query_criar_tabela = "";

    public static String criarTabela() {
        query_criar_tabela += "CREATE TABLE " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += NMINSTITUICAO + " text, ";
        query_criar_tabela += ENDERECO + " text";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }
}

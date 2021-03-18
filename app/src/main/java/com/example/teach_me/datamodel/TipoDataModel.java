package com.example.teach_me.datamodel;

public class TipoDataModel {
    public static final String TABELA = "tipo";

    public static final String ID = "id";
    public static final String NMTIPO = "nmTipo";

    public static  String query_criar_tabela = "";

    public static String criarTabela() {
        query_criar_tabela += "CREATE TABLE " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += NMTIPO + " text ";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }
}

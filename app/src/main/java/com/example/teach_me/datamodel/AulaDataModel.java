package com.example.teach_me.datamodel;

public class AulaDataModel {
    public static final String TABELA = "aula";

    public static final String ID = "id";
    public static final String CDUSUARIOALUNO = "cdUsuarioAluno";
    public static final String CDANUNCIO = "cdAnuncio";
    public static final String HORARIO = "horario";
    public static final String TITULO = "titulo";
    public static final String DESCRICAO = "descricao";
    public static final String AVALIACAO = "avaliacao";
    public static final String ISAVALIADO = "isAvaliado";

    public static String query_criar_tabela = "";

    public static String criarTabela() {
        query_criar_tabela += "CREATE TABLE IF NOT EXISTS " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += CDUSUARIOALUNO + " integer, ";
        query_criar_tabela += CDANUNCIO + " text, ";
        query_criar_tabela += HORARIO + " text, ";
        query_criar_tabela += TITULO + " text, ";
        query_criar_tabela += DESCRICAO + " text, ";
        query_criar_tabela += AVALIACAO + " real, ";
        query_criar_tabela += ISAVALIADO + " integer";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }
}

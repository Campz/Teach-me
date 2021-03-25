package com.example.teach_me.datamodel;

public class UsuarioDataModel {
    public static final String TABELA = "usuario";

    public static final String ID = "id";
    public static final String NMUSUARIO = "nmUsuario";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String SENHA = "senha";
    public static final String DTNASCIMENTO = "dtNascimento";
    public static final String AVALIACAO = "avaliacao";
    public static final String DESCRICAO = "descricao";
    public static final String FOTO = "foto";
    public static final String CDINSTITUICAO = "cdInstituicao";

    public static String query_criar_tabela = "";

    public static String criarTabela() {
        query_criar_tabela += "CREATE TABLE IF NOT EXISTS " + TABELA + "( ";
        query_criar_tabela += ID + " integer primary key autoincrement, ";
        query_criar_tabela += NMUSUARIO + " text, ";
        query_criar_tabela += EMAIL + " text, ";
        query_criar_tabela += LOGIN + " text, ";
        query_criar_tabela += SENHA + " text, ";
        query_criar_tabela += DTNASCIMENTO + " text, ";
        query_criar_tabela += AVALIACAO + " text, ";
        query_criar_tabela += DESCRICAO + " text, ";
        query_criar_tabela += FOTO + " text, ";
        query_criar_tabela += CDINSTITUICAO + " text";
        query_criar_tabela += ")";

        return query_criar_tabela;
    }
}

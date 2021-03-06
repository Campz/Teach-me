package com.example.teach_me.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.teach_me.api.AppUltil;
import com.example.teach_me.datamodel.AnuncioDataModel;
import com.example.teach_me.datamodel.AulaDataModel;
import com.example.teach_me.datamodel.DisciplinaDataModel;
import com.example.teach_me.datamodel.InstituicaoDataModel;
import com.example.teach_me.datamodel.TipoDataModel;
import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Tipo;
import com.example.teach_me.model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "TeachMe.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase database;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(InstituicaoDataModel.criarTabela());
        database.execSQL(TipoDataModel.criarTabela());
        database.execSQL(DisciplinaDataModel.criarTabela());
        database.execSQL(AnuncioDataModel.criarTabela());
        database.execSQL(AulaDataModel.criarTabela());
        database.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados){

        database = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = database.insert(tabela, null, dados) > 0;
        }catch (Exception e){
            Log.i(AppUltil.TAG, "insert: " + e.getMessage());
        }

        return retorno;
    }

    public boolean deleteById(String tabela, int id){

        database = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = database.delete(tabela, "id = ?", new String[] {String.valueOf(id)}) > 0;
        }catch (Exception e){
            Log.i(AppUltil.TAG, "deleteById : " + e.getMessage());
        }

        return retorno;
    }



    public boolean update(String tabela, ContentValues dados){

        database = getWritableDatabase();

        boolean retorno = false;

        try {
            retorno = database.update(tabela, dados, "id = ?", new String[] {String.valueOf(dados.get("id"))}) > 0;
        }catch (Exception e){
            Log.i(AppUltil.TAG, "update : " + e.getMessage());
        }

        return retorno;
    }

    public List<Anuncio> getAllAnuncios(String tabela){

        database = getWritableDatabase();
        Anuncio a;
        List<Anuncio> anuncios = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                a = new Anuncio();
                a.setId(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.ID)));
                a.setQtdAlunos(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.QTDALUNOS)));
                a.setDescricao(cursor.getString(cursor.getColumnIndex(AnuncioDataModel.DESCRICAO)));
                a.setCdDisciplina(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.CDDISCIPLINA)));
                a.setCdUsuarioProfessor(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.CDUSUARIOPROFESSOR)));
                a.setValor(cursor.getString(cursor.getColumnIndex(AnuncioDataModel.VALOR)));
                anuncios.add(a);
            }while(cursor.moveToNext());
        }

        return anuncios;
    }
    public Anuncio getAnuncioById(String tabela, Integer id) throws Exception {

        database = getWritableDatabase();
        Anuncio anuncio = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                anuncio = new Anuncio();
                anuncio.setId(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.ID)));
                anuncio.setQtdAlunos(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.QTDALUNOS)));
                anuncio.setDescricao(cursor.getString(cursor.getColumnIndex(AnuncioDataModel.DESCRICAO)));
                anuncio.setCdDisciplina(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.CDDISCIPLINA)));
                anuncio.setCdUsuarioProfessor(cursor.getInt(cursor.getColumnIndex(AnuncioDataModel.CDUSUARIOPROFESSOR)));
                anuncio.setValor(cursor.getString(cursor.getColumnIndex(AnuncioDataModel.VALOR)));
            }while(cursor.moveToNext());
        }

        if (anuncio == null){
            throw new Exception("NÃO EXISTE NO BANCO");
        }else{
            return anuncio;
        }
    }

    public List<Aula> getAllAulas(String tabela){

        database = getWritableDatabase();
        Aula a;
        List<Aula> aulas = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                a = new Aula();
                a.setId(cursor.getInt(cursor.getColumnIndex(AulaDataModel.ID)));
                a.setHorario(cursor.getString(cursor.getColumnIndex(AulaDataModel.HORARIO)));
                a.setTitulo(cursor.getString(cursor.getColumnIndex(AulaDataModel.TITULO)));
                a.setDescricao(cursor.getString(cursor.getColumnIndex(AulaDataModel.DESCRICAO)));
                a.setAvaliacao(cursor.getDouble(cursor.getColumnIndex(AulaDataModel.AVALIACAO)));
                a.setIsAvaliado(cursor.getInt(cursor.getColumnIndex(AulaDataModel.ISAVALIADO)));
                a.setCdAnuncio(cursor.getInt(cursor.getColumnIndex(AulaDataModel.CDANUNCIO)));
                a.setCdUsuarioAluno(cursor.getInt(cursor.getColumnIndex(AulaDataModel.CDUSUARIOALUNO)));
                aulas.add(a);
            }while(cursor.moveToNext());
        }

        return aulas;
    }
    public Aula getAulaById(String tabela, Integer id) throws Exception {

        database = getWritableDatabase();
        Aula aula = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                aula = new Aula();
                aula.setId(cursor.getInt(cursor.getColumnIndex(AulaDataModel.ID)));
                aula.setHorario(cursor.getString(cursor.getColumnIndex(AulaDataModel.HORARIO)));
                aula.setTitulo(cursor.getString(cursor.getColumnIndex(AulaDataModel.TITULO)));
                aula.setDescricao(cursor.getString(cursor.getColumnIndex(AulaDataModel.DESCRICAO)));
                aula.setAvaliacao(cursor.getDouble(cursor.getColumnIndex(AulaDataModel.AVALIACAO)));
                aula.setIsAvaliado(cursor.getInt(cursor.getColumnIndex(AulaDataModel.ISAVALIADO)));
                aula.setCdAnuncio(cursor.getInt(cursor.getColumnIndex(AulaDataModel.CDANUNCIO)));
                aula.setCdUsuarioAluno(cursor.getInt(cursor.getColumnIndex(AulaDataModel.CDUSUARIOALUNO)));

            }while(cursor.moveToNext());
        }
        if (aula == null){
            throw new Exception("NÃO EXISTE NO BANCO");
        }else{
            return aula;
        }
    }

    public Disciplina getDisciplinaById(String tabela, Integer id) throws Exception {
        database = getWritableDatabase();
        Disciplina disciplina = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;
        cursor = database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                disciplina = new Disciplina();
                disciplina.setId(cursor.getInt(cursor.getColumnIndex(DisciplinaDataModel.ID)));
                disciplina.setNmDisciplina(cursor.getString(cursor.getColumnIndex(DisciplinaDataModel.NMDISCIPLINA)));
                disciplina.setCdTipo(cursor.getInt(cursor.getColumnIndex(DisciplinaDataModel.CDTIPO)));
            }while(cursor.moveToNext());
        }
        if (disciplina == null){
            throw new Exception("NÃO EXISTE NO BANCO");
        }else{
            return disciplina;
        }
    }

    public List<Disciplina> getAllDisciplinas(String tabela){

        database = getWritableDatabase();
        Disciplina d;
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                d = new Disciplina();
                d.setId(cursor.getInt(cursor.getColumnIndex(DisciplinaDataModel.ID)));
                d.setNmDisciplina(cursor.getString(cursor.getColumnIndex(DisciplinaDataModel.NMDISCIPLINA)));
                d.setCdTipo(cursor.getInt(cursor.getColumnIndex(DisciplinaDataModel.CDTIPO)));
                disciplinas.add(d);
            }while(cursor.moveToNext());
        }
        return disciplinas;
    }

    public Instituicao getInstituicaoById(String tabela, Integer id) throws Exception {

        database = getWritableDatabase();
        Instituicao instituicao = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;
        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                instituicao = new Instituicao();
                instituicao.setId(cursor.getInt(cursor.getColumnIndex(InstituicaoDataModel.ID)));
                instituicao.setEndereco(cursor.getString(cursor.getColumnIndex(InstituicaoDataModel.ENDERECO)));
                instituicao.setNmInstituicao(cursor.getString(cursor.getColumnIndex(InstituicaoDataModel.NMINSTITUICAO)));
            }while(cursor.moveToNext());
        }
        if(instituicao == null){
            throw  new Exception("NÃO EXISTE NO BANCO");
        }else {
            return instituicao;
        }
    }

    public List<Instituicao> getAllInstituicoes(String tabela){

        database = getWritableDatabase();
        Instituicao i;
        List<Instituicao> inst = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                i = new Instituicao();
                i.setId(cursor.getInt(cursor.getColumnIndex(InstituicaoDataModel.ID)));
                i.setEndereco(cursor.getString(cursor.getColumnIndex(InstituicaoDataModel.ENDERECO)));
                i.setNmInstituicao(cursor.getString(cursor.getColumnIndex(InstituicaoDataModel.NMINSTITUICAO)));
                inst.add(i);
            }while(cursor.moveToNext());
        }
        return inst;
    }

    public List<Tipo> getAllTipos(String tabela){

        database = getWritableDatabase();
        Tipo t;
        List<Tipo> tipos = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                t = new Tipo();
                t.setId(cursor.getInt(cursor.getColumnIndex(TipoDataModel.ID)));
                t.setNmTipo(cursor.getString(cursor.getColumnIndex(TipoDataModel.NMTIPO)));
                tipos.add(t);
            }while(cursor.moveToNext());
        }
        return tipos;
    }

    public Tipo getTipoById(String tabela, Integer id) throws Exception {

        database = getWritableDatabase();
        Tipo tipo = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                tipo = new Tipo();
                tipo.setId(cursor.getInt(cursor.getColumnIndex(TipoDataModel.ID)));
                tipo.setNmTipo(cursor.getString(cursor.getColumnIndex(TipoDataModel.NMTIPO)));
            }while(cursor.moveToNext());
        }
        if (tipo == null){
            throw new Exception("USUÁRIO NÃO ENCONTRADO");
        }else{
            return tipo;
        }
    }

    public Usuario getUsuarioById(String tabela, Integer id) throws Exception {
        database = getWritableDatabase();
        Usuario usuario = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".ID = " + id.toString();
        Cursor cursor;
        cursor = database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                usuario.setNmUsuario(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NMUSUARIO)));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                usuario.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.LOGIN)));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.SENHA)));
                usuario.setDtNascimento(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DTNASCIMENTO)));
                usuario.setAvaliacao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.AVALIACAO)));
                usuario.setDescricao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DESCRICAO)));
                usuario.setFoto(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.FOTO)));
                usuario.setCdInstituicao(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.CDINSTITUICAO)));

            }while(cursor.moveToNext());
        }
        if (usuario == null){
            throw new Exception("USUÁRIO NÃO ENCONTRADO");
        }else{
            return usuario;
        }
    }

    public Usuario getUsuarioByLogin(String tabela, String login, String senha) throws Exception {
        database = getWritableDatabase();
        Usuario usuario = null;
        String sql = "SELECT * FROM " + tabela + " WHERE " + tabela + ".LOGIN = '" + login + "' AND " + tabela + ".SENHA = '" + senha+ "'";
        System.out.println(sql);
        Cursor cursor;
        cursor = database.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                usuario.setNmUsuario(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NMUSUARIO)));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                usuario.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.LOGIN)));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.SENHA)));
                usuario.setDtNascimento(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DTNASCIMENTO)));
                usuario.setAvaliacao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.AVALIACAO)));
                usuario.setDescricao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DESCRICAO)));
                usuario.setFoto(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.FOTO)));
                usuario.setCdInstituicao(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.CDINSTITUICAO)));

            }while(cursor.moveToNext());
        }
        if (usuario == null){
            throw new Exception("LOGIN OU SENHA INCORRETA");
        }else{
            return usuario;
        }
    }

    public List<Usuario> getAllUsuarios(String tabela){

        database = getWritableDatabase();
        Usuario u;
        List<Usuario> usuarios = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                u = new Usuario();
                u.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                u.setNmUsuario(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NMUSUARIO)));
                u.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                u.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.LOGIN)));
                u.setSenha(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.SENHA)));
                u.setDtNascimento(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DTNASCIMENTO)));
                u.setAvaliacao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.AVALIACAO)));
                u.setDescricao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DESCRICAO)));
                u.setFoto(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.FOTO)));
                u.setCdInstituicao(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.CDINSTITUICAO)));
                usuarios.add(u);
            }while(cursor.moveToNext());
        }
        return usuarios;
    }
}

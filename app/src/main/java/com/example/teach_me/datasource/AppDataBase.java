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
import com.example.teach_me.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "Teachme.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase database;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(AnuncioDataModel.criarTabela());
        database.execSQL(AulaDataModel.criarTabela());
        database.execSQL(DisciplinaDataModel.criarTabela());
        database.execSQL(InstituicaoDataModel.criarTabela());
        database.execSQL(TipoDataModel.criarTabela());
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

    public List<Usuario> getAllUsuario(String tabela){
        database = getWritableDatabase();
        Usuario usuario;
        List<Usuario> listUsuario = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
        Cursor cursor;
        cursor = database.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                usuario.setNmUsuario(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NMUSUARIO)));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.EMAIL)));
                usuario.setLogin(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.LOGIN)));
                usuario.setDtNascimento(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DTNASCIMENTO)));
                usuario.setAvaliacao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.AVALIACAO)));
                usuario.setDescricao(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.DESCRICAO)));
                usuario.setFoto(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.FOTO)));
                usuario.setCdInstituicao(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.CDINSTITUICAO)));
                listUsuario.add(usuario);
            }while(cursor.moveToNext());
        }

        return listUsuario;
    }public List<Anuncio> getAllAnuncio(String tabela){
        database = getWritableDatabase();
        Anuncio anuncio;
        List<Anuncio> listAnuncio = new ArrayList<>();
        String sql = " SELECT * FROM " + tabela;
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
                listAnuncio.add(anuncio);
            }while(cursor.moveToNext());
        }

        return listAnuncio;
    }

}

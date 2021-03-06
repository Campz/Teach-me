package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Usuario;

public class UsuarioController extends AppDataBase implements ICRUD<Usuario> {

    private static UsuarioController usuarioController;
    private ContentValues dados;
    private Usuario usuarioLogado;

    private UsuarioController(Context context) {
        super(context);
        usuarioLogado = null;
    }

    public static UsuarioController getInstance(Context context){
        if (usuarioController == null){
            usuarioController = new UsuarioController(context);
            return usuarioController;
        }else{
            return  usuarioController;
        }
    }

    @Override
    public boolean incluir(Usuario o) {
        dados = new ContentValues();
        dados.put(UsuarioDataModel.NMUSUARIO, o.getNmUsuario());
        dados.put(UsuarioDataModel.EMAIL, o.getEmail());
        dados.put(UsuarioDataModel.LOGIN, o.getLogin());
        dados.put(UsuarioDataModel.SENHA, o.getSenha());
        dados.put(UsuarioDataModel.DTNASCIMENTO, o.getDtNascimento());
        dados.put(UsuarioDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(UsuarioDataModel.DESCRICAO, o.getDescricao());
        dados.put(UsuarioDataModel.FOTO, o.getFoto());
        dados.put(UsuarioDataModel.CDINSTITUICAO, o.getCdInstituicao());
        return insert(UsuarioDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Usuario o) {
        dados = new ContentValues();
        dados.put(UsuarioDataModel.ID, o.getId());
        dados.put(UsuarioDataModel.NMUSUARIO, o.getNmUsuario());
        dados.put(UsuarioDataModel.EMAIL, o.getEmail());
        dados.put(UsuarioDataModel.LOGIN, o.getLogin());
        dados.put(UsuarioDataModel.SENHA, o.getSenha());
        dados.put(UsuarioDataModel.DTNASCIMENTO, o.getDtNascimento());
        dados.put(UsuarioDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(UsuarioDataModel.DESCRICAO, o.getDescricao());
        dados.put(UsuarioDataModel.FOTO, o.getFoto());
        dados.put(UsuarioDataModel.CDINSTITUICAO, o.getCdInstituicao());
        return update(UsuarioDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(UsuarioDataModel.TABELA, id);
    }

    @Override
    public List<Usuario> listar() {
        return getAllUsuarios(UsuarioDataModel.TABELA);
    }

    @Override
    public Usuario get(Integer id) throws Exception {
        return getUsuarioById(UsuarioDataModel.TABELA,id);
    }

    public boolean validaLogin(String login, String senha){
        try{
            setUsuarioLogado(getUsuarioByLogin(UsuarioDataModel.TABELA,login,senha));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isLogado(){
        return this.usuarioLogado != null;
    }

    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuario){
        this.usuarioLogado = usuario;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int calculaIdade(String data){

        //1999-12-17
        String dtStart = data;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dtStart);
            int ano = date.getYear();
            Date d = new Date();
            int ano2 =d.getYear();
            return ano2 - ano;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public double getValorAvaliacao(int idUsuario, AulaController aulaController){

        double soma = 0;
        int qtdAval = 0;

        List<Aula> aulas = aulaController.listar();

        for (Aula a : aulas){
            //pega as aulas daquele id
            if(a.getCdUsuarioAluno() == idUsuario){
                //Pega os valores de todas as avaliações
                if(a.getIsAvaliado() == 1){
                    soma = soma + a.getAvaliacao();
                    qtdAval++;
                }
            }
        }

        double resultado = soma/qtdAval;

        return resultado;
    }
}

package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;
import java.util.List;
import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.datasource.AppDataBase;
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
}

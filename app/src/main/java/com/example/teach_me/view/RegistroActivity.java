package com.example.teach_me.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    TextView txt_usuario, txt_senha, txt_email, txt_nome, txt_dtNascimento, txt_instituicao;
    ImageView bt_back;
    Button bt_registrar;
    Usuario novoUsuario;
    UsuarioController usuarioController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponents();
        buttonsEvents();
    }

    private void buttonsEvents() {
        // Voltar para a tela de Login
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
        // Registrar um novo usuário no sistema
        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if(TextUtils.isEmpty(txt_usuario.getText())){
                    isDadosOK = false;
                    txt_usuario.setError("Digite o nome de usuário");
                    txt_usuario.requestFocus();
                }

                if(TextUtils.isEmpty(txt_senha.getText())){
                    isDadosOK = false;
                    txt_senha.setError("Digite uma senha");
                    txt_senha.requestFocus();
                }

                if(TextUtils.isEmpty(txt_email.getText())){
                    isDadosOK = false;
                    txt_email.setError("Digite o email");
                    txt_email.requestFocus();
                }

                if(TextUtils.isEmpty(txt_nome.getText())){
                    isDadosOK = false;
                    txt_nome.setError("Digite seu nome");
                    txt_nome.requestFocus();
                }

                if(TextUtils.isEmpty(txt_dtNascimento.getText())){
                    isDadosOK = false;
                    txt_dtNascimento.setError("Digite sua data de nascimento");
                    txt_dtNascimento.requestFocus();
                }

                if(TextUtils.isEmpty(txt_instituicao.getText())){
                    isDadosOK = false;
                    txt_instituicao.setError("Digite o nome da instituição");
                    txt_instituicao.requestFocus();
                }

                if(isDadosOK){
                    // Cadastra o usuario no banco de dados com sucesso
                    novoUsuario.setLogin(txt_usuario.getText().toString());
                    novoUsuario.setSenha(txt_senha.getText().toString());
                    novoUsuario.setEmail(txt_email.getText().toString());
                    novoUsuario.setNmUsuario(txt_nome.getText().toString());
                    novoUsuario.setDtNascimento(txt_dtNascimento.getText().toString());
                    novoUsuario.setAvaliacao("0");
                    novoUsuario.setDescricao("");
                    novoUsuario.setFoto(null);
                    usuarioController.incluir(novoUsuario);
                    Log.i("log_add_usuario","onClick: Dados corretos...");
                }else{
                    // Notifica o usuário para corrigir os erros
                    Log.e("log_add_usuario","onClick: Dados incorretos...");
                }

                Intent intent = new Intent(RegistroActivity.this, ImagemPerfilActivity.class);
                startActivity(intent);

            }
        });
        //
    }

    private void initComponents() {
        txt_usuario = findViewById(R.id.editText_login);
        txt_senha = findViewById(R.id.editText_senha);
        txt_email = findViewById(R.id.editText_email);
        txt_nome = findViewById(R.id.editText_nome);
        txt_dtNascimento = findViewById(R.id.editText_DtNascimento);
        txt_instituicao = findViewById(R.id.editText_Instituicao);
        bt_back = findViewById(R.id.bt_back);
        bt_registrar = findViewById(R.id.bt_registrar);

        novoUsuario = new Usuario();
        usuarioController = UsuarioController.getInstance(this);
    }

}

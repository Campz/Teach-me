package com.example.teach_me.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.teach_me.R;
import com.example.teach_me.controller.InstituicaoController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Usuario;
import java.util.Calendar;
import java.util.List;

import java.text.DateFormat;

public class RegistroActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView txt_usuario, txt_senha, txt_email, txt_nome, txt_dtNascimento;
    Spinner spnInst;
    ImageView bt_back;
    Button bt_registrar;
    Usuario novoUsuario;

    UsuarioController usuarioController;
    InstituicaoController instituicaoController;

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

                if(spnInst == null && spnInst.getSelectedItem() == null ){
                    isDadosOK = false;
                    ((TextView)spnInst.getSelectedView()).setError("Selecione uma instituição");
                    spnInst.requestFocus();
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
                    Instituicao i = (Instituicao) spnInst.getSelectedItem();
                    novoUsuario.setCdInstituicao(i.getId());
                    usuarioController.incluir(novoUsuario);
                    Log.i("log_add_usuario","onClick: Dados corretos...");
                    //Intent intent = new Intent(RegistroActivity.this, ImagemPerfilActivity.class);
                    //startActivity(intent);
                    Toast.makeText(RegistroActivity.this, "Registrado com sucesso!", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    // Notifica o usuário para corrigir os erros
                    Log.e("log_add_usuario","onClick: Dados incorretos...");
                }


            }
        });
        txt_dtNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        //
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String ano, mes, dia;
        if(c.get(Calendar.MONTH) < 10){
            mes = "0" + String.valueOf(c.get(Calendar.MONTH)+1);
        }else{
            mes = String.valueOf(c.get(Calendar.MONTH));
        }
        if (c.get(Calendar.DAY_OF_MONTH) < 10){
            dia = "0" + String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }else{
            dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }
        ano = String.valueOf(c.get(Calendar.YEAR));

        String dataString = ano+"-"+mes+"-"+dia;
        txt_dtNascimento.setText(dataString);
    }

    private void initComponents() {
        txt_usuario = findViewById(R.id.editText_login);
        txt_senha = findViewById(R.id.editText_senha);
        txt_email = findViewById(R.id.editText_email);
        txt_nome = findViewById(R.id.editText_nome);
        txt_dtNascimento = findViewById(R.id.editText_DtNascimento);
        spnInst = findViewById(R.id.spnInstituicao);
        bt_back = findViewById(R.id.bt_back);
        bt_registrar = findViewById(R.id.bt_registrar);

        novoUsuario = new Usuario();
        usuarioController = UsuarioController.getInstance(this);
        instituicaoController = InstituicaoController.getInstance(this);

        //Preenche o Spinner
        List<Instituicao> instituicoes = instituicaoController.listar();
        ArrayAdapter<Instituicao> dataAdapter = new ArrayAdapter<Instituicao>(this,
                android.R.layout.simple_spinner_item, instituicoes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnInst.setAdapter(dataAdapter);

        spnInst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Instituicao i = (Instituicao) parent.getSelectedItem();
                displayInstData(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSelectedInst(View v){
        Instituicao i = (Instituicao) spnInst.getSelectedItem();
        displayInstData(i);
    }

    private void displayInstData(Instituicao i){
        String nmInstituicao = i.getNmInstituicao();
        int id = i.getId();
        String endereco = i.getEndereco();

        String instData = "Instituição: " + nmInstituicao;
    }

}

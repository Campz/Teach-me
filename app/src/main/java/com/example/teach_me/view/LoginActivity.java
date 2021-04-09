package com.example.teach_me.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    TextView txt_registrar;
    TextView txt_pular;
    TextView txt_login;
    TextView txt_senha;
    View img_chapeu;
    ImageView campo_usuario;
    ImageView ic_usuario;
    Button bt_login;
    UsuarioController usuarioController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        buttonsEvents();
        txt_pular.setVisibility(View.INVISIBLE);
    }

    private void buttonsEvents(){

        // Pular etapa de login
        txt_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Ir para tela de registro
        txt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                // Check if we're running on Android 5.0 or higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Apply activity transition
                    // create the transition animation - the images in the layouts
                    // of both activities are defined with android:transitionName="chapeu"
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(LoginActivity.this, img_chapeu, "chapeu");
                    // start the new activity
                    startActivity(intent, options.toBundle());
                } else {
                    // Swap without transition
                    startActivity(intent);
                }
            }
        });

        // Efetuar login
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if(TextUtils.isEmpty(txt_login.getText())){
                    isDadosOK = false;
                    txt_login.setError("Digite o nome de usuário");
                    txt_login.requestFocus();
                }

                if(TextUtils.isEmpty(txt_senha.getText())){
                    isDadosOK = false;
                    txt_senha.setError("Digite uma senha");
                    txt_senha.requestFocus();
                }
                if (isDadosOK){
                    if (usuarioController.validaLogin(txt_login.getText().toString(),txt_senha.getText().toString())){
                        Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Login ou senha incorreto!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void initComponents() {
        img_chapeu = findViewById(R.id.img_chapeu);
        txt_pular = findViewById(R.id.txt_pular);
        txt_registrar = findViewById(R.id.txt_registrar);
        txt_login = findViewById(R.id.editText_login);
        txt_senha = findViewById(R.id.editText_senha);
        bt_login = findViewById(R.id.bt_login);

        usuarioController = UsuarioController.getInstance(this);
    }
}

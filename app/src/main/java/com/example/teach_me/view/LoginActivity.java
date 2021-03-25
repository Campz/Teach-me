package com.example.teach_me.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;

public class LoginActivity extends AppCompatActivity {

    TextView txt_registrar;
    TextView txt_pular;
    View img_chapeu;
    ImageView campo_usuario;
    ImageView ic_usuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();

        txt_pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
    }

    private void initComponents() {
        img_chapeu = findViewById(R.id.img_chapeu);
        txt_pular = findViewById(R.id.txt_pular);
        txt_registrar = findViewById(R.id.txt_registrar);
    }
}

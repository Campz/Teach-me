package com.example.teach_me.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.teach_me.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theartofdev.edmodo.cropper.CropImage;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImagemPerfilActivity extends AppCompatActivity {

    CircleImageView img_upload_image;
    Button bt_confirmar;
    FloatingActionButton bt_pular;
    TextView txt_ola;
    Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagem_perfil);
        initComponents();
        buttonsEvents();
    }

    public void buttonsEvents(){
        // Selecionar imagem da galeria/camera
        img_upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity().start(ImagemPerfilActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){
                imageUri = result.getUri();
                img_upload_image.setImageURI(imageUri);
            }
            else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception e = result.getError();
                Toast.makeText(this, "Erro: "+ e,Toast.LENGTH_SHORT);
            }
        }
    }

    private void initComponents(){
        img_upload_image = findViewById(R.id.img_upload_image);
        bt_confirmar = findViewById(R.id.bt_confirmar);
        bt_pular = findViewById(R.id.bt_pular_imagem);
        txt_ola = findViewById(R.id.txt_ola);
    }
}

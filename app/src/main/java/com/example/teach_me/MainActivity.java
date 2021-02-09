package com.example.teach_me;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.teach_me.models.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> destaques = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        destaques.add(new Usuario());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Button buscarAula = findViewById(R.id.bt_buscar);
        final Usuario usu = new Usuario();
        buscarAula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuario> call = new RetrofitClientInstance().getUsuarioService().buscarUsuario(usu.toString());
                Log.d("Teste", usu.toString());
            }
        });
    }
}

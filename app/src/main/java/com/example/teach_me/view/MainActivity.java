package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.teach_me.R;
import com.example.teach_me.api.AppUltil;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.InstituicaoController;
import com.example.teach_me.controller.TipoController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Tipo;
import com.example.teach_me.model.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.teach_me.Repositorio;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static Usuario usuarioLogado;

    TipoController tipoController;
    AulaController aulaController;
    AnuncioController anuncioController;
    DisciplinaController disciplinaController;
    InstituicaoController instituicaoController;
    UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_pesquisa, R.id.navigation_aulas, R.id.navigation_perfil)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // ********************************** POVOAMENTO **************************************************** \\
        tipoController = new TipoController(this.getApplicationContext());
        if(tipoController.listar().size() == 0)
            Repositorio.povoamentoTipo(tipoController);
        Toast.makeText(MainActivity.this, "Importação de TIPOS", Toast.LENGTH_LONG).show();

        instituicaoController = InstituicaoController.getInstance(this.getApplicationContext());
        if(instituicaoController.listar().size() == 0)
            Repositorio.povoamentoInstituicao(instituicaoController);
        Toast.makeText(MainActivity.this, "Importação de INSTITUIÇÕES", Toast.LENGTH_LONG).show();

        disciplinaController = new DisciplinaController(this.getApplicationContext());
        if(disciplinaController.listar().size() == 0)
            Repositorio.povoamentoDisciplina(disciplinaController);
        Toast.makeText(MainActivity.this, "Importação de DISCIPLINAS", Toast.LENGTH_LONG).show();

        usuarioController = UsuarioController.getInstance(this.getApplicationContext());
        if(usuarioController.listar().size() == 0)
            Repositorio.povoamentoUsuario(usuarioController);
        Toast.makeText(MainActivity.this, "Importação de USUÁRIOS", Toast.LENGTH_LONG).show();

        anuncioController = AnuncioController.getInstance(this.getApplicationContext());
        if(anuncioController.listar().size() == 0)
            Repositorio.povoamentoAnuncio(anuncioController);
        Toast.makeText(MainActivity.this, "Importação de AÚNUNCIOS", Toast.LENGTH_LONG).show();

        aulaController = AulaController.getInstance(this.getApplicationContext());
        if(aulaController.listar().size() == 0)
            Repositorio.povoamentoAula(aulaController);
        Toast.makeText(MainActivity.this, "Importação de AULAS", Toast.LENGTH_LONG).show();
        // ****************************************************************************************************** \\

        // teste de listagem
        Log.e(AppUltil.TAG, "************************ Teste listagem ********************************");

        Log.e(AppUltil.TAG, "######### TIPOS #########");
        List<Tipo> tipos = tipoController.listar();
        for (int i = 0; i < tipos.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Tipo: ID: " + tipos.get(i).getId() + " - Nome: " + tipos.get(i).getNmTipo());
        }

        Log.e(AppUltil.TAG, "######### USUÁRIOS #########");
        List<Usuario> usuarios = usuarioController.listar();
        for (int i = 0; i < usuarios.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Usuário: ID: " + usuarios.get(i).getId() + " - Nome: " + usuarios.get(i).getNmUsuario());
        }

        Log.e(AppUltil.TAG, "######### INSTITUIÇÕES #########");
        List<Instituicao> instituicoes = instituicaoController.listar();
        for (int i = 0; i < instituicoes.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Instituição: ID: " + instituicoes.get(i).getId() + " - Nome: " + instituicoes.get(i).getNmInstituicao());
        }

        Log.e(AppUltil.TAG, "######### DISCIPLINAS #########");
        List<Disciplina> disciplinas = disciplinaController.listar();
        for (int i = 0; i < disciplinas.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Disciplina: ID: " + disciplinas.get(i).getId() + " - Nome: " + disciplinas.get(i).getNmDisciplina() + " Tipo: " + disciplinas.get(i).getCdTipo());
        }

        Log.e(AppUltil.TAG, "######### ANÚNCIOS #########");
        List<Anuncio> anuncios = anuncioController.listar();
        for (int i = 0; i < anuncios.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Anúncio: ID: " + anuncios.get(i).getId() + " - Descrição: " + anuncios.get(i).getDescricao());
        }

        Log.e(AppUltil.TAG, "######### AULAS #########");
        List<Aula> aulas = aulaController.listar();
        for (int i = 0; i < aulas.size(); i++) {
            Log.e(AppUltil.TAG, "********");
            Log.i(AppUltil.TAG, "Aula: ID: " + aulas.get(i).getId() + " - Horário: " + aulas.get(i).getHorario());
        }

        try {
            Usuario usuario = usuarioController.get(1);
            Log.i(AppUltil.TAG, "Usuário: ID: " + usuario.getId() + " - Nome: " + usuario.getNmUsuario());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(AppUltil.TAG, "DEU RUIM DEMAIS");
        }

    }

}

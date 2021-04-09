package com.example.teach_me.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.AulaController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Usuario;

import java.util.List;

public class ContratarAulaActivity extends AppCompatActivity {

    TextView txt_nmDisciplina, txt_nmProfessor, txt_Valor;
    CheckBox checkSeg, checkTer, checkQua, checkQui, checkSex;
    Spinner spinnerHorario;
    ImageView bt_confirma, bt_cancela;

    AnuncioController anuncioController;
    DisciplinaController disciplinaController;
    UsuarioController usuarioController;
    AulaController aulaController;

    Anuncio anuncio;
    Disciplina disciplina;
    Usuario professor;
    String horario;
    String horarioSelecionado;
    int idAnuncio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratar_aula);
        initComponents();
        buttonsEvents();
        Intent intent = getIntent();
        idAnuncio = Integer.parseInt(intent.getExtras().getString("idAnuncio"));

        //Busca o anuncio da aula a ser contratada e a disciplina ofetada nele
        try {
            anuncio = anuncioController.get(idAnuncio);
            professor = usuarioController.get(anuncio.getCdUsuarioProfessor());
            disciplina = disciplinaController.get(anuncio.getCdDisciplina());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Preenche os campos da nova aula
        txt_nmDisciplina.setText(disciplina.getNmDisciplina());
        txt_nmProfessor.setText(professor.getNmUsuario());
        txt_Valor.setText(intent.getExtras().getString("Valor"));

        //Configurando o spinner de horários
        ArrayAdapter<CharSequence> horario_adapter = ArrayAdapter.createFromResource(this, R.array.horario_array, android.R.layout.simple_spinner_item);
        horario_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHorario.setAdapter(horario_adapter);
        spinnerHorario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                horarioSelecionado = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initComponents(){
        txt_nmDisciplina = findViewById(R.id.txt_nmDisciplinaAula);
        txt_nmProfessor = findViewById(R.id.txt_nmProfessorAula);
        txt_Valor = findViewById(R.id.txt_valorAula);
        spinnerHorario = findViewById(R.id.spinnerDia);
        checkSeg = findViewById(R.id.checkSeg);
        checkTer = findViewById(R.id.checkTer);
        checkQua = findViewById(R.id.checkQua);
        checkQui = findViewById(R.id.checkQui);
        checkSex = findViewById(R.id.checkSex);
        bt_confirma = findViewById(R.id.img_confirmaAula);
        bt_cancela = findViewById(R.id.img_cancelarAula);

        anuncioController = AnuncioController.getInstance(this);
        disciplinaController = DisciplinaController.getInstance(this);
        usuarioController = UsuarioController.getInstance(this);
        aulaController = AulaController.getInstance(this);
        anuncio = new Anuncio();
        disciplina = new Disciplina();
    }

    private void buttonsEvents(){
        bt_cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horario = "";
                if (checkSeg.isChecked()){
                    horario += "Segunda, ";
                }
                if (checkTer.isChecked()){
                    horario += "Terça, ";
                }
                if (checkQua.isChecked()){
                    horario += "Quarta, ";
                }
                if (checkQui.isChecked()){
                    horario += "Quinta, ";
                }
                if (checkSex.isChecked()){
                    horario += "Sexta, ";
                }
                horario += horarioSelecionado + ".";

                if(verificaContratacao()) {
                    Toast.makeText(ContratarAulaActivity.this, "Você já contratou esta aula!", Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    if(verificaSeEstaMatriculandoNaPropriaAula()){
                        Toast.makeText(ContratarAulaActivity.this, "Você não pode se matricular na sua própria aula!", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        if(verificaQtdVagas()) {
                            if(verificaInstituicao()){
                                Aula aula;
                                aula = new Aula();
                                aula.setCdAnuncio(idAnuncio);
                                aula.setCdUsuarioAluno(usuarioController.getUsuarioLogado().getId()); // pega a id do usuario logado
                                aula.setHorario(horario);
                                aula.setIsAvaliado(0);
                                aulaController.incluir(aula);
                                Toast.makeText(ContratarAulaActivity.this, "Aula contratada com sucesso!", Toast.LENGTH_LONG).show();
                                finish();
                            }else{
                                Toast.makeText(ContratarAulaActivity.this, "Instituição diferente!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }else{
                            Toast.makeText(ContratarAulaActivity.this, "Turma cheia!", Toast.LENGTH_LONG).show();
                            finish();
                        }

                    }
                }
            }
        });
    }

    private boolean verificaContratacao(){
        Usuario aluno = usuarioController.getUsuarioLogado();
        List<Aula> aulas = aulaController.listar();
        boolean contratado = false;

        for(Aula a: aulas){
            if(a.getCdUsuarioAluno() == aluno.getId() && a.getCdAnuncio() == idAnuncio){
                contratado = true;
                break;
            }
        }
        return contratado;
    }

    private boolean verificaSeEstaMatriculandoNaPropriaAula(){
        Usuario aluno = usuarioController.getUsuarioLogado();
        List<Anuncio> anuncios = anuncioController.listar();
        Anuncio anuncio = new Anuncio();
        boolean alunoProfessor = false;

        //Pega o anúncio pelo id
        for(Anuncio a : anuncios){
            if(a.getId() == idAnuncio){
                anuncio = a;
                break;
            }
        }

        if(anuncio.getCdUsuarioProfessor() == aluno.getId())
            alunoProfessor = true;

        return alunoProfessor;
    }

    private boolean verificaQtdVagas(){
        List<Aula> aulas = aulaController.listar();
        List<Anuncio> anuncios = anuncioController.listar();
        Anuncio anuncio = new Anuncio();

        boolean temVaga = true;
        int qtdVagas = 0;
        int qtdVagasOcupadas = 0;

        //Pega o anúncio pelo id
        for(Anuncio a : anuncios){
            if(a.getId() == idAnuncio){
                qtdVagas = a.getQtdAlunos();
                break;
            }
        }

        for(Aula a: aulas){
            if(a.getCdAnuncio() == idAnuncio){
                qtdVagasOcupadas++;
            }
        }

        if(qtdVagasOcupadas >= qtdVagas)
            temVaga = false;
        else
            temVaga = true;

        return temVaga;
    }

    private boolean verificaInstituicao(){
        Usuario aluno = usuarioController.getUsuarioLogado();
        List<Anuncio> anuncios = anuncioController.listar();
        List<Usuario> usuarios = usuarioController.listar();
        Usuario professor = new Usuario();
        Anuncio anuncio = new Anuncio();

        boolean mesmaInst = false;

        //Pega o anúncio pelo id
        for(Anuncio a : anuncios){
            if(a.getId() == idAnuncio){
                anuncio = a;
                break;
            }
        }

        for(Usuario u : usuarios){
            if(u.getId() == anuncio.getCdUsuarioProfessor()){
                professor = u;
                break;
            }
        }

        if(professor.getCdInstituicao() == aluno.getCdInstituicao()){
            mesmaInst = true;
        }

        return mesmaInst;
    }
}

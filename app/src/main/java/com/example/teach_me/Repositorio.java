package com.example.teach_me;

import android.widget.Toast;

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
import com.example.teach_me.view.MainActivity;

public class Repositorio {

    public static void povoamentoTipo(TipoController tipoController){
        Tipo tipo;

        // 1
        tipo = new Tipo();
        tipo.setNmTipo("Cálculo");
        tipoController.incluir(tipo);

        // 2
        tipo = new Tipo();
        tipo.setNmTipo("Física");
        tipoController.incluir(tipo);

        // 3
        tipo = new Tipo();
        tipo.setNmTipo("Engenharia de Software");
        tipoController.incluir(tipo);

        // 4
        tipo = new Tipo();
        tipo.setNmTipo("Programação");
        tipoController.incluir(tipo);

        // 5
        tipo = new Tipo();
        tipo.setNmTipo("Álgebra");
        tipoController.incluir(tipo);
    }

    public static void povoamentoInstituicao(InstituicaoController instituicaoController){
        Instituicao instituicao;

        //1
        instituicao = new Instituicao();
        instituicao.setNmInstituicao("Cefet Timóteo");
        instituicao.setEndereco("R. Dezenove de Novembro, 121 - Centro, Timóteo - MG");
        instituicaoController.incluir(instituicao);

        //2
        instituicao = new Instituicao();
        instituicao.setNmInstituicao("Cefet BH - Campus I");
        instituicao.setEndereco("Av. Amazonas, 5253 - Nova Suíça, Belo Horizonte - MG");
        instituicaoController.incluir(instituicao);

        //3
        instituicao = new Instituicao();
        instituicao.setNmInstituicao("Cefet BH - Campus II");
        instituicao.setEndereco("Av. Amazonas, 7675 - Nova Gameleira, Belo Horizonte - MG");
        instituicaoController.incluir(instituicao);

        //4
        instituicao = new Instituicao();
        instituicao.setNmInstituicao("Cefet Divinópolis");
        instituicao.setEndereco("R. Álvares de Azevedo, 400 - Bela Vista, Divinópolis - MG");
        instituicaoController.incluir(instituicao);

        //5
        instituicao = new Instituicao();
        instituicao.setNmInstituicao("Cefet Nepomuceno");
        instituicao.setEndereco("Av. Monsenhor Luís de Gonzaga, 103 - Centro, Nepomuceno");
        instituicaoController.incluir(instituicao);
    }

    public static void povoamentoDisciplina(DisciplinaController disciplinaController){
        Disciplina disciplina;

        //1
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Cálculo I");
        disciplina.setCdTipo(1);
        disciplinaController.incluir(disciplina);

        //2
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Cálculo II");
        disciplina.setCdTipo(1);
        disciplinaController.incluir(disciplina);

        //3
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Cálculo III");
        disciplina.setCdTipo(1);
        disciplinaController.incluir(disciplina);

        //4
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Cálculo IV");
        disciplina.setCdTipo(1);
        disciplinaController.incluir(disciplina);

        //5
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Geometria Analítica e Álgebra Vetorail");
        disciplina.setCdTipo(5);
        disciplinaController.incluir(disciplina);

        //6
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Álgebra Linear");
        disciplina.setCdTipo(5);
        disciplinaController.incluir(disciplina);

        //7
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Programação de Computadores I");
        disciplina.setCdTipo(4);
        disciplinaController.incluir(disciplina);

        //8
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Programação de Computadores II");
        disciplina.setCdTipo(4);
        disciplinaController.incluir(disciplina);

        //9
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Algoritmos e Estruturas de Dados I");
        disciplina.setCdTipo(4);
        disciplinaController.incluir(disciplina);

        //10
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Algoritmos e Estruturas de Dados II");
        disciplina.setCdTipo(4);
        disciplinaController.incluir(disciplina);

        //11
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Física I");
        disciplina.setCdTipo(2);
        disciplinaController.incluir(disciplina);

        //12
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Física II");
        disciplina.setCdTipo(2);
        disciplinaController.incluir(disciplina);

        //13
        disciplina = new Disciplina();
        disciplina.setNmDisciplina("Física III");
        disciplina.setCdTipo(2);
        disciplinaController.incluir(disciplina);
    }

    public static void povoamentoUsuario(UsuarioController usuarioController){
        Usuario usuario;

        //1
        usuario = new Usuario();
        usuario.setNmUsuario("Ruan Kenned");
        usuario.setEmail("ruankennedm@gmail.com");
        usuario.setLogin("ruanK");
        usuario.setSenha("ruan123");
        usuario.setDtNascimento("1999-12-17");
        usuario.setAvaliacao("4.5");
        usuario.setDescricao("Aluno do 6º período do curso de Engenharia de Computação");
        usuario.setFoto("https://i.imgur.com/7K0ddlm.jpg");
        usuario.setCdInstituicao(1);
        usuarioController.incluir(usuario);

        //2
        usuario = new Usuario();
        usuario.setNmUsuario("Rafael Campos");
        usuario.setEmail("rafacampz@gmail.com");
        usuario.setLogin("rafael");
        usuario.setSenha("rafael22");
        usuario.setDtNascimento("2000-03-03");
        usuario.setAvaliacao("5.0");
        usuario.setDescricao("Aluno do 6º período do curso de Engenharia de Computação");
        usuario.setFoto("https://i.imgur.com/8oNiaF1.jpg");
        usuario.setCdInstituicao(2);
        usuarioController.incluir(usuario);

        //3
        usuario = new Usuario();
        usuario.setNmUsuario("Arthur Zatta");
        usuario.setEmail("zatta@gmail.com");
        usuario.setLogin("ZattaZ");
        usuario.setSenha("zatta24");
        usuario.setDtNascimento("2000-03-03");
        usuario.setAvaliacao("3.0");
        usuario.setDescricao("Aluno do 6º período do curso de Engenharia de Computação");
        usuario.setFoto("https://i.imgur.com/UfGabgl.jpg");
        usuario.setCdInstituicao(3);
        usuarioController.incluir(usuario);

        //4
        usuario = new Usuario();
        usuario.setNmUsuario("Luiz Sei lá");
        usuario.setEmail("luizinho@gmail.com");
        usuario.setLogin("LuizLuiz");
        usuario.setSenha("prolixo");
        usuario.setDtNascimento("2000-03-03");
        usuario.setAvaliacao("0.5");
        usuario.setDescricao("Aluno do 6º período do curso de Engenharia de Computação");
        usuario.setFoto("https://i.imgur.com/VgVS9Ep.jpg");
        usuario.setCdInstituicao(3);
        usuarioController.incluir(usuario);
    }

    public static void povoamentoAnuncio(AnuncioController anuncioController) {
        Anuncio anuncio;

        //1
        anuncio = new Anuncio();
        anuncio.setCdDisciplina(1);
        anuncio.setDescricao("Intensivo de revisão para prova");
        anuncio.setQtdAlunos(5);
        anuncio.setCdUsuarioProfessor(1);
        anuncio.setValor("25,00");
        anuncioController.incluir(anuncio);

        //2
        anuncio = new Anuncio();
        anuncio.setCdDisciplina(3);
        anuncio.setDescricao("Resolução de exercícios e reforço de teoria");
        anuncio.setQtdAlunos(2);
        anuncio.setCdUsuarioProfessor(2);
        anuncio.setValor("20,00");
        anuncioController.incluir(anuncio);

        //4
        anuncio = new Anuncio();
        anuncio.setCdDisciplina(4);
        anuncio.setDescricao("Monitoria particular");
        anuncio.setQtdAlunos(3);
        anuncio.setCdUsuarioProfessor(1);
        anuncio.setValor("30,00");
        anuncioController.incluir(anuncio);
    }

    public static void povoamentoAula(AulaController aulaController) {
        Aula aula;

        //1
        aula = new Aula();
        aula.setCdAnuncio(1);
        aula.setCdUsuarioAluno(3);
        aula.setHorario("23M34");
        aulaController.incluir(aula);

        //2
        aula = new Aula();
        aula.setCdAnuncio(2);
        aula.setCdUsuarioAluno(4);
        aula.setHorario("56T12");
        aulaController.incluir(aula);
    }
}

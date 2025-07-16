package service;

import dao.AlunoDAO;
import dao.CursoDAO;
import model.Aluno;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class Gerenciamento {
    private AlunoDAO listaAluno = new AlunoDAO();
    private CursoDAO listaCurso = new CursoDAO();

    public void listarAlunos(){
        List<Aluno> lista = AlunoDAO.listar();
        for (Aluno aluno : lista){
            System.out.println("ID: " + aluno.getId() + " | NOME: " + aluno.getNome() + " | EMAIL: " + aluno.getEmail());
        }
    }

    public void listarCursos(){
        List<Curso> lista = CursoDAO.listar();
        for (Curso curso : lista){
            System.out.println("ID: " + curso.getId() + " | NOME: " + curso.getNome() + " | DESCRIÇÃO: " + curso.getDescricao());
        }
    }

    public void cadastrarAluno(Scanner sc){
        sc.nextLine();

        System.out.println("Digite nome do aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite email do aluno: ");
        String email = sc.nextLine();

        Aluno aluno = new Aluno(nome, email);
        listaAluno.inserir(aluno);
    }

    public void cadastrarCurso(Scanner sc){
        sc.nextLine();

        System.out.println("Digite nome do curso: ");
        String nome = sc.nextLine();

        System.out.println("Digite a descrição do curso: ");
        String descricao = sc.nextLine();

        Curso curso = new Curso(nome, descricao);
        listaCurso.inserir(curso);
    }

    public void matricularAluno(){

    }

    public void listarCursosAlunos(){

    }

    public void listarAlunosSemCurso(){

    }

    public void deletarAluno(Scanner sc){

    }

    public void deletarCurso(Scanner sc){

    }
}

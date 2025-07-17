package service;

import dao.AlunoDAO;
import dao.CursoDAO;
import dao.MatriculaDAO;
import model.Aluno;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class Gerenciamento {
    private AlunoDAO listaAluno = new AlunoDAO();
    private CursoDAO listaCurso = new CursoDAO();
    private MatriculaDAO listaMatricula = new MatriculaDAO();


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

    public void matricularAluno(Scanner sc){
        sc.nextLine();

        System.out.println("\nDigite ID do aluno que deseja matricular: ");
        int id = sc.nextInt();

        System.out.println("\nCursos disponiveis: ");
        listarCursos();

        System.out.println("Digite ID do curso que deseja matricular aluno: ");
        int idCurso = sc.nextInt();

        listaMatricula.inserir(id, idCurso);
    }

    // Listar todos os cursos com seus alunos
    public void listarCursosAlunos(){
        listaMatricula.listarCursosAlunos();
    }

    // Listar alunos não matriculados em nenhum curso
    public void listarAlunosSemCurso(){
        listaMatricula.listarAlunosSemCurso();
    }

    // Desafio extra - Cursos sem nenhum aluno.
    public void listarCursoSemAluno(){
        listaMatricula.ListarCursoSemAluno();
    }

    // Desafio extra - Total de alunos por curso.
    public void totalAlunoPorCurso(Scanner sc){
        sc.nextLine();

        System.out.println("Digite ID do curso que deseja saber total de alunos: ");
        int id = sc.nextInt();

        int total = listaMatricula.totalAlunoCurso(id);

        System.out.println(total);
    }

    public void deletarAluno(Scanner sc){
        sc.nextLine();

        System.out.println("Digite ID do aluno que deseja deletar: ");
        int id = sc.nextInt();

        Aluno aluno = new Aluno(id, "", "");
        listaAluno.deletar(aluno);
    }

    public void deletarCurso(Scanner sc){
        sc.nextLine();

        System.out.println("Digite ID do curso que deseja deletar: ");
        int id = sc.nextInt();

        Curso curso = new Curso(id, "", "");
        listaCurso.deletar(curso);
    }
}

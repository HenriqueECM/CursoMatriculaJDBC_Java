package controller;

import service.Gerenciamento;
import java.util.Scanner;

public class MenuController {
    private static Scanner sc = new Scanner(System.in);
    Gerenciamento ger = new Gerenciamento();

    public void menu(){
        int opcao;

        do {
            System.out.println("""
                    \n--- Sistema de Cursos e Matrículas ---
                    
                    1 - Listar todos os alunos
                    2 - Cadastrar novo aluno
                    3 - Cadastrar novo curso
                    4 - Matricular aluno em curso
                    5 - Listar todos os cursos com seus alunos
                    6 - Listar alunos não matriculados em nenhum curso
                    7 - Excluir aluno
                    8 - Excluir curso
                    0 - Sair
                    
                    Escolha uma operação do sistema:
                    """);
            opcao = sc.nextInt();

            switch (opcao){
                case 0:
                    System.out.println("\nEncerrando o Sistema...");
                    break;
                case 1: ger.listarAlunos(); break;
                case 2: ger.cadastrarAluno(sc); break;
                case 3: ger.cadastrarCurso(sc); break;
                case 4: ger.matricularAluno(sc); break;
                case 5: ger.listarCursosAlunos(); break;
                case 6: ger.listarAlunosSemCurso(); break;
                case 7: ger.deletarAluno(sc); break;
                case 8: ger.deletarCurso(sc); break;
                default:
                    System.out.println("Opção Inválida! Tente Novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}

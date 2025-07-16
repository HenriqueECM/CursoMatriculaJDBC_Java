package dao;

import model.Aluno;
import model.Conexao;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO {

    public void inserir(int idAluno, int idCurso){
        String sql = "INSERT INTO matricula (aluno_id, curso_id) VALUES (?,?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setInt(1, idAluno);
            stmt.setInt(2, idCurso);
            stmt.executeUpdate();

            System.out.println("\nAluno inserido no curso com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listarCursosAlunos() {
        String sql = """
        SELECT c.nome AS curso, a.nome AS aluno
        FROM curso c
        JOIN matricula m ON c.id = m.curso_id
        JOIN aluno a ON m.aluno_id = a.id
        ORDER BY c.nome, a.nome
    """;

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {

            String cursoAtual = "";

            while (rs.next()) {
                String curso = rs.getString("curso");
                String aluno = rs.getString("aluno");

                // Evitar repetir o nome do curso várias vezes
                if (!curso.equals(cursoAtual)) {
                    System.out.println("\nCurso: " + curso);
                    cursoAtual = curso;
                }
                System.out.println("  - " + aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void listarAlunosSemCurso() {
        String sql = """
        SELECT a.id, a.nome
        FROM aluno a
        LEFT JOIN matricula m ON a.id = m.aluno_id
        WHERE m.curso_id IS NULL
    """;

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Alunos não matriculados em nenhum curso:");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                System.out.printf("ID: %d - Nome: %s%n", id, nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ListarCursoSemAluno () {
        String sql = """
                SELECT c.id, c.nome
                FROM curso c
                LEFT JOIN matricula m ON c.id = m.curso_id
                WHERE m.aluno_id IS NULL
                """;

        try (Connection connection = Conexao.conectar();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            System.out.println("Cursos sem alunos matriculados: ");

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                System.out.printf("ID: %d - Nome: %s%n", id, nome);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

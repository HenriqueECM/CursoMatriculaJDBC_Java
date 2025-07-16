package dao;

import model.Aluno;
import model.Conexao;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    public void inserir(Curso curso){
        String sql = "INSERT INTO curso (nome, descricao) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.executeUpdate();

            System.out.println("\nCurso inserido com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Curso curso){
        String sql = "DELETE FROM curso WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, curso.getNome());
            stmt.executeUpdate();

            System.out.println("\nCurso excluido com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Curso> listar(){
        String sql = "SELECT id, nome, descricao FROM curso";
        List<Curso> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");

                Curso curso = new Curso(id, nome, descricao);
                lista.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

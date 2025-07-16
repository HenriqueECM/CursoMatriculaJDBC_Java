package dao;

import model.Aluno;
import model.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public void inserir(Aluno aluno){
        String sql = "INSERT INTO aluno (nome, email) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.executeUpdate();

            System.out.println("\nAluno " + aluno.getNome() + " inserido com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletar(Aluno aluno){
        String sql = "DELETE FROM aluno WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, aluno.getNome());
            stmt.executeUpdate();

            System.out.println("\nAluno" + aluno.getNome() + " excluido com sucesso!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Aluno> listar(){
        String sql = "SELECT id, nome, email FROM aluno";
        List<Aluno> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Aluno aluno = new Aluno(id, nome, email);
                lista.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

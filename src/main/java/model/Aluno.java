package model;

public class Aluno {
    private int id;
    private String nome, email;

    public Aluno(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public Aluno(int id, String nome, String email){
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

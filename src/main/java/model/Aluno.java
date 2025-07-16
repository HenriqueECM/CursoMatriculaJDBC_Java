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
}

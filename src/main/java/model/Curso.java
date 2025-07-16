package model;

public class Curso {
    private int id;
    private String nome, descricao;

    public Curso (String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public Curso (int id, String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

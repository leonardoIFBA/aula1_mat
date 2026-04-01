package model;

public class Curso {
    private int id;
    private String nome;
    private int duracao;
    public Curso() {
    }
    public Curso(int id, String nome, int duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
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
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", duracao=" + duracao + "]";
    }

    
}

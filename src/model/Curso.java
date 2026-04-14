package model;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  */
public class Curso {
    //**** Atributos do objeto Aluno */  
    private int id;
    private String nome;
    private int duracao;

    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos */
    public Curso() {
    }
    public Curso(int id, String nome, int duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    //**** Metodos getters e Setters dos atributos (Encapsulamento) */
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

    /**** permite visualiza as informações do objeto  */
    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", duracao=" + duracao + "]";
    }

    
}

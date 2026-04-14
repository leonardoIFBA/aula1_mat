package model;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  */
public class Aluno {
    //**** Atributos do objeto Aluno */    
    private String nome;
    private int idade;
    private String cpf;
    private Curso curso;
    
    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos */
    public Aluno() {
    }

    public Aluno(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    //**** Metodos getters e Setters dos atributos (Encapsulamento) */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    /**** permite visualiza as informações do objeto  */
    @Override
    public String toString() {
        return "Aluno [nome=" + nome + "| idade=" + idade 
            + "| cpf=" + cpf + "| curso=" + curso.getNome() + "]";
    }
}

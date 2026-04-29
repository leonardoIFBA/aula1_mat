package model;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  
   * Ela herda as caracteristicas da classe Pessoa */
public class Aluno extends Pessoa{

    /**** Atributos do objeto Aluno */  
    private int idade;
    private String cpf;
    private Curso curso;

    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos alunos */
    public Aluno(){}

    public Aluno(int idade, String cpf, Curso curso) {
        this.idade = idade;
        this.cpf = cpf;
        this.curso = curso;
    }

    public Aluno(int id, String nome, String email, int idade, String cpf, Curso curso) {
        super(id, nome, email);
        this.idade = idade;
        this.cpf = cpf;
        this.curso = curso;
    }

    /**** Metodos getters e Setters dos atributos (Encapsulamento) */
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**** Implementação concreta do métodoo herdado da classe Pessoa  */
    @Override
    public double calcularBonus() {
        return 1000 * 1.10;
    }

    /**** permite visualiza as informações do objeto Aluno */
    @Override
    public String toString() {
        return super.toString() + ", idade=" + idade + ", cpf=" + cpf + ", curso=" + curso.getNome() ;
    }

    
}

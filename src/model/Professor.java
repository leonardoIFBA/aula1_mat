package model;

/*** As classe do model representam a estrutura de dados (entidades/tabelas) e a lógica de negócios da aplicação.  
   * Ela herda as caracteristicas da classe Pessoa */
public class Professor extends Pessoa {
    /**** Atributos do objeto Professor */ 
    private String siape;

    /*** Construtor vazio e com parametros, auxiliam na criação dos objetos professores */
    public Professor(){}

    public Professor(int id, String nome, String email, String siape){
        super(id, nome, email);
        this.siape = siape;

    }

    /**** Metodos getters e Setters dos atributos (Encapsulamento) */
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    /**** Implementação concreta do métodoo herdado da classe Pessoa  */
    @Override
    public double calcularBonus() {
        return 2000 * 1.10;
    }

    /**** permite visualiza as informações do objeto Professor*/
    @Override
    public String toString() {
        return "Professor " + super.toString() + ", siape=" + siape;
    }

    
    
}

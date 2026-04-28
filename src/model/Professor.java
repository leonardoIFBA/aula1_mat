package model;

public class Professor extends Pessoa {
    private String siape;

    public Professor(){}

    public Professor(int id, String nome, String email, String siape){
        super(id, nome, email);
        this.siape = siape;

    }

    

    @Override
    public double calcularBonus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularBonus'");
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Override
    public String toString() {
        return "Professor " + super.toString() + ", siape=" + siape;
    }

    
    
}

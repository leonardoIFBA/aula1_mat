package repository;

import java.util.ArrayList;
import java.util.List;

import model.Professor;

/**** As classes da camada repository em projetos Java, servem para abstrair o acesso aos dados. 
 * Elas isolam a regra de negócio da tecnologia de persistência */
public class ProfessorRepository {
    /** A lista de professores irá simular nossa tabela do banco de dados */
    private List<Professor> professores = new ArrayList<>();
    /**** simula o identificador do objeto cadastrado */
    private static int contadorId = 1;

    /**** salva um objeto professor na lista de professores */
    public void salvar(Professor professor) {
        professor.setId(contadorId++);
        professores.add(professor);
    }

    /**** exclui um objeto professor na lista de professores */
    public void excluir(Professor professor) {
        professores.remove(professor);
    }

    /**** devolve uma lista de objetos professor */
    public List<Professor> listarTodos() {
        return professores;
    }
    
}

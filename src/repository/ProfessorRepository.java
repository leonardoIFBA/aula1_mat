package repository;

import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();
    private static int contadorId = 1;

    public ProfessorRepository(){
        professores.add(new Professor(contadorId++, "leonardo", "leo@ifba.edu.br", "123456"));
    }

    public void salvar(Professor professor){
        professor.setId(contadorId++);
        professores.add(professor);
    }

    public void excluir(Professor professor){
        professores.remove(professor);
    }

    public List<Professor> listarTodos(){
        return professores;
    }

}

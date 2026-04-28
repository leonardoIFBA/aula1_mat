package service;

import java.util.*;

import model.Aluno;
import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
    private List<Professor> listaProfessores = new ArrayList<>();
    private ProfessorRepository repoProf = new ProfessorRepository();
    private Scanner scanner = new Scanner(System.in);

    public void listar(){
        //** busca no repositorio a lista de professores cadastrados */
        listaProfessores = repoProf.listarTodos();

        // testa se a lista esta vazia, se estiver sai do método
        if(listaProfessores.isEmpty()){
            System.out.println("Lista Vazia!");
            return;
        }

        System.out.println("\n***** Lista de professores cadastrados *****");
        // Este for intera na lista de objetos e carrega o objeto
        // na variável c
        for(Professor a: listaProfessores){
            System.out.println(a);
        }

        System.out.println("Total: " + listaProfessores.size() + " professores");
    }


}

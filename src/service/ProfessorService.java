package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
    private List<Professor> listaProfessores = new ArrayList<>();
    private ProfessorRepository repoProfessor = new ProfessorRepository();
    private Scanner scanner = new Scanner(System.in);

    public void listar() {
        listaProfessores = repoProfessor.listarTodos();
        if(listaProfessores.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        System.out.println("\n=== Lista de Professores ===");
        for(Professor a : listaProfessores) {
            System.out.println(a);
        }
        System.out.println("Total: " + listaProfessores.size() + " professores");
    }

    public void adicionar() {
        System.out.println("\n--- Novo Professor ---");
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email do professor: ");
        String email = scanner.nextLine();
        System.out.print("Digite o Siape do professor: ");
        String siape = scanner.nextLine();
        
        Professor novoProfessor = new Professor(0, nome, email, siape);
        repoProfessor.salvar(novoProfessor);
      
        System.out.println("Professor adicionado com sucesso! ID: " + novoProfessor.getId());
    }

    public void remover() {
        listar();
        if(listaProfessores.isEmpty()) return;
        
        System.out.print("Digite o ID do professor para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        boolean removido = listaProfessores.removeIf(c -> c.getId() == id);
        
        if(removido) {
            System.out.println("Professor deletado com sucesso!");
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    public void atualizar() {
        listar();
        if(listaProfessores.isEmpty()) return;
        
        System.out.print("Digite o ID do professor para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Professor professorSelecionado = null; //cria um professor temporário
        for (Professor p : listaProfessores){
            if(p.getId() == id) {
                professorSelecionado = p;
                break;
            }
        }

        if(professorSelecionado == null) {
            System.out.println("Professor não encontrado!");
            return;
        }
        
        System.out.println("\nAtualizando professor: " + professorSelecionado.getNome());
        
        System.out.print("Novo nome (Enter para manter): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()) {
            professorSelecionado.setNome(nome);
        }
        
        System.out.print("Novo email (Enter para manter): ");
        String email = scanner.nextLine();
        if(!nome.isEmpty()) {
            professorSelecionado.setEmail(email);
        }

        System.out.print("Novo Siape (Enter para manter): ");
        String siape = scanner.nextLine();
        if(!nome.isEmpty()) {
            professorSelecionado.setSiape(siape);
        }

        System.out.println("Professor atualizado com sucesso!");
    }

    public void buscar() {
        listaProfessores = repoProfessor.listarTodos();
        
        System.out.print("\nDigite o nome para buscar: ");
        String nome = scanner.nextLine().toLowerCase();
        
        ArrayList<Professor> resultados = new ArrayList<>();
        for(Professor c : listaProfessores) {
            if(c.getNome().toLowerCase().contains(nome)) {
                resultados.add(c);
            }
        }
        
        if(resultados.isEmpty()) {
            System.out.println("Nenhum professor encontrado.");
        } else {
            System.out.println("\n--- Resultados da Busca ---");
            for(Professor c : resultados) {
                System.out.println(c);
            }
            System.out.println("Encontrados: " + resultados.size() + " professores");
        }
    }

}
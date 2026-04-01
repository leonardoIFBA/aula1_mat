package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Curso;
import repository.CursoRepository;

public class CursoService {
    private static List<Curso> listaCursos;
    private static Scanner scanner;
    private CursoRepository repo;

    public CursoService(){
        listaCursos = new ArrayList<>();
        scanner = new Scanner(System.in);
        repo = new CursoRepository();
    }
    
    public void listar(){
        /** pega no "banco de dados" a lista de cursos e carrega na 
         * na variavel listarCursos */
        listaCursos = repo.listarTodos();
        if(listaCursos.isEmpty()){
            System.out.println("Lista Vazia...");
            return;
        }

        System.out.println("\n=== Lista de cursos ===");
        for(Curso c : listaCursos){
            System.out.println(c);
        }

        System.out.println("Total: " + listaCursos.size() + " cursos");

    }

    public void adicionar(){
        System.out.println("\n=== Novo curso ===");
        System.out.println("Digite o nome o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a duração do curso: ");
        int duracao = scanner.nextInt();

        Curso c = new Curso(0, nome, duracao);
        repo.salvar(c);

        System.out.println("Adicionado com sucesso! ID: "+ c.getId());
    }

    public void atualizar(){
        listar();
        if(listaCursos.isEmpty()) 
            return;
        
        System.out.println("Digite o ID do curso para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso cursoSelecionado = null;
        for(Curso c : listaCursos)
            if(c.getId() == id){
                cursoSelecionado = c;
                break;
            }
        
        if(cursoSelecionado == null)
            System.out.println("Curso não encontrado!!!");

        System.out.println("\n=== Atualizando curso: " 
                        + cursoSelecionado.getNome());
        System.out.println("Novo nome (ENTER para manter): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()){
            cursoSelecionado.setNome(nome);
        }

        System.out.println("Nova duração (0 para manter): ");
        int duracao = scanner.nextInt();
        if(duracao > 0){
            cursoSelecionado.setDuracao(duracao);
        }

        //Não precisa dessa linha
        //repo.salvar(cursoSelecionado);

        System.out.println("Curso atualizado com sucesso!!!");
    }

    public void excluir(){
        listar();
        if (listaCursos.isEmpty())
            return;
        
        System.out.println("Digite o ID do curso para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removido = listaCursos.removeIf(c -> c.getId()==id);

        if (removido)
            System.out.println("Curso excluído com sucesso!!!");
        else   
            System.out.println("Curso não encontrado");
    }

    public void buscar(){
        /** guarda a lista de cursos atual */
        listaCursos = repo.listarTodos();

        System.out.println("Digite o nome do curso: ");
        String nome = scanner.nextLine().toLowerCase();

        List<Curso> resultados = new ArrayList<>();
        for(Curso c : listaCursos){
            if (c.getNome().toLowerCase().contains(nome)){
                resultados.add(c);
            }
        }

        if (resultados.isEmpty())
            System.out.println("Nenhum curso encontrado.");
        else{
            System.out.println("\n--- Resultado da busca ---");
            for (Curso c : resultados)
                System.out.println(c);

            System.out.println("Encontrados: " + resultados.size() 
                                    + " cursos");
        }
    }

}

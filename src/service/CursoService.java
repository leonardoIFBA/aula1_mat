package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Curso;
import repository.CursoRepository;

/**** As classes da camada de service servem para encapsular a lógica de negócios, 
 * separando-a dos controladores (Controller) e do acesso a dados (Repository). */
public class CursoService {
    /*** trabala a lista de cursos que vem do repositório */
    private static List<Curso> listaCursos;
    /*** Cria um scanner para capturar as informações do usuário, via teclado */
    private static Scanner scanner;
    /*** Cria uma instancia do repositório para ter acesso aos metodos do repositório */
    private CursoRepository repo;

    /*** O construtor da classe inicializa os atributos da classe */
    public CursoService(){
        listaCursos = new ArrayList<>();
        scanner = new Scanner(System.in);
        repo = new CursoRepository();
    }
    
    /*** retorna os cursos do "BD" */
    public void listar(){
        /** pega no "banco de dados" a lista de cursos e carrega na 
         * na variavel listarCursos */
        listaCursos = repo.listarTodos();
        if(listaCursos.isEmpty()){
            System.out.println("Lista Vazia...");
            return;
        }

        /*** imprime para o usuário a lista de cursos encontrada */
        System.out.println("\n=== Lista de cursos ===");
        for(Curso c : listaCursos){
            System.out.println(c);
        }

        /*** exibe o total de cursos encontrados */
        System.out.println("Total: " + listaCursos.size() + " cursos");

    }

    /*** adiciona um novo curso no "BD" */
    public void adicionar(){
        System.out.println("\n=== Novo curso ===");
        System.out.println("Digite o nome o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a duração do curso: ");
        int duracao = scanner.nextInt();

        /*** cria um objeto curso e carrega as informações dos atributos, que foram passados pelo usuário */
        Curso c = new Curso(0, nome, duracao);
        /*** chama o método salvar, do repositório, para salvar o novo objeto criado */
        repo.salvar(c);

        /*** imprime uma mensagem de sucesso para o usuário */
        System.out.println("Adicionado com sucesso! ID: "+ c.getId());
    }

    /*** ataliza as informações de um objeto curso */
    public void atualizar(){
        /*** apresenta os objetos do "BD" que poderiam ser atualizados */
        listar();
        /*** se a não houver cursos ele sai do método */
        if(listaCursos.isEmpty()) 
            return;
        
        System.out.println("Digite o ID do curso para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso cursoSelecionado = null;
        /*** percorre a lista de cursos do "BD" procurando pelo ID passado pelo usuário. Se encontrar, carrega no objeto cursoSelecionado */
        for(Curso c : listaCursos)
            if(c.getId() == id){
                cursoSelecionado = c;
                break;
            }
        
        if(cursoSelecionado == null)
            System.out.println("Curso não encontrado!!!");

        /*** Atualiza o curso com novas informações */
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

    /*** Exclui um curso do "BD" */
    public void excluir(){
        /*** apresenta os objetos do "BD" que poderiam ser atualizados */
        listar();
        /*** se a não houver cursos ele sai do método */
        if (listaCursos.isEmpty())
            return;
        
        System.out.println("Digite o ID do curso para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        /*** atraves de expressão lambda (Java 8) exclui o curso de mesmo ID */
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

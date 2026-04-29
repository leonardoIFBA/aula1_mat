package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Curso;
import repository.CursoRepository;

/**** As classes da camada de serviço servem para encapsular a lógica de negócios, 
 * separando-a dos controladores (Controller) e do acesso a dados (Repository). */
public class CursoService {
    /*** trabala a lista de cursos que vem do repositório */
    private List<Curso> listaCursos;
    /*** Cria um scanner para capturar as informações do usuário, via teclado */
    private Scanner scanner;
    /*** Cria uma instancia do repositório para ter acesso aos metodos do repositório */
    private CursoRepository cursoRepo;
 
    /*** O construtor da classe inicializa os atributos da classe */
    public CursoService(){
        this.listaCursos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.cursoRepo = new CursoRepository();
    }
 
    /*** adiciona um novo curso no "BD" */
    public void adicionar() {
        System.out.println("\n--- Novo Curso ---");
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a duração do curso: ");
        int duracao = scanner.nextInt();

        /*** cria um objeto curso e carrega as informações dos atributos, que foram passados pelo usuário */
        Curso novoCurso = new Curso(nome, duracao);
        cursoRepo.salvar(novoCurso);
      
        /*** imprime uma mensagem de sucesso para o usuário */
        System.out.println("Adicionado com sucesso! ID: " + novoCurso.getId());
    }

    /*** retorna os cursos do "BD" */
    public void listar() {
         /** pega no "banco de dados" a lista de cursos e carrega na na variavel listarCursos */
        listaCursos = cursoRepo.listarTodos();
        if(listaCursos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        /*** imprime para o usuário a lista de cursos encontrada */
        System.out.println("\n=== Lista de Cursos ===");
        for(Curso c : listaCursos) {
            System.out.println(c);
        }
        /*** exibe o total de cursos encontrados */
        System.out.println("Total: " + listaCursos.size() + " cursos");
    }

    /*** Exclui um curso do "BD" */
    public void remover() {
        /*** apresenta os objetos do "BD" que poderiam ser atualizados */
        listar();
        /*** se a não houver cursos ele sai do método */
        if(listaCursos.isEmpty()) return;
        
        System.out.print("Digite o ID do curso para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        /*** atraves de expressão lambda (Java 8) exclui o curso de mesmo ID */
        boolean removido = listaCursos.removeIf(c -> c.getId() == id);
        
        if(removido) {
            System.out.println("Curso deletado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    /*** ataliza as informações de um objeto curso */
    public void atualizar() {
        /*** apresenta os objetos do "BD" que poderiam ser atualizados */
        listar();
        /*** se a não houver cursos ele sai do método */
        if(listaCursos.isEmpty()) return;
        
        System.out.print("Digite o ID do curso para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso cursoSelecionado = null; //cria um curso temporário
        /*** percorre a lista de cursos do "BD" procurando pelo ID passado pelo usuário. Se encontrar, carrega no objeto cursoSelecionado */
        for (Curso c : listaCursos){
            if(c.getId() == id) {
                cursoSelecionado = c;
                break;
            }
        }

        if(cursoSelecionado == null) {
            System.out.println("Curso não encontrado!");
            return;
        }
        
        System.out.println("\nAtualizando curso: " + cursoSelecionado.getNome());
        
        /*** Atualiza o curso com novas informações */
        System.out.print("Novo nome (Enter para manter): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()) {
            cursoSelecionado.setNome(nome);
        }
        
        System.out.print("Nova duração (0 para manter): ");
        int duracao = scanner.nextInt();
        if(duracao > 0) {
            cursoSelecionado.setDuracao(duracao);
        }

        scanner.nextLine();
        
        System.out.println("Curso atualizado com sucesso!");
    }

    public void buscar() {
        /** guarda a lista de cursos atual */
        listaCursos = cursoRepo.listarTodos();
        
        System.out.print("\nDigite o nome para buscar: ");
        String nome = scanner.nextLine().toLowerCase();
        
        /** cria uma lista para guardar os cursos encontrados na busca */
        ArrayList<Curso> resultados = new ArrayList<>();
        for(Curso c : listaCursos) {
            if(c.getNome().toLowerCase().contains(nome)) {
                resultados.add(c);
            }
        }
        
        if(resultados.isEmpty()) {
            System.out.println("Nenhum curso encontrado.");
        } else {
            System.out.println("\n--- Resultados da Busca ---");
            for(Curso c : resultados) {
                System.out.println(c);
            }
            System.out.println("Encontrados: " + resultados.size() + " cursos");
        }
    }
}

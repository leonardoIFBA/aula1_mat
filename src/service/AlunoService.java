package service;

import java.util.*;

import model.Aluno;
import model.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;

/**** As classes da camada de service servem para encapsular a lógica de negócios, 
 * separando-a dos controladores (Controller) e do acesso a dados (Repository). */
public class AlunoService {
    /*** cria uma lista de alunos para guardar os alunos que vem do repositório */
    private List<Aluno> listaAlunos;
    /*** cria uma lista de cursos para guardar os cursos cadastrados no repositório */
    private List<Curso> listaCursos;
    /*** Cria um scanner para capturar as informações do usuário, via teclado */
    private Scanner scanner;
    /*** Cria uma instancia do repositório de alunos para ter acesso aos metodos do AlunoRepositório */
    private AlunoRepository repoAluno;
    /*** Cria uma instancia do repositório de cursos para ter acesso aos metodos do CursoRepositório */
    private CursoRepository repoCurso;

    /*** O construtor da classe inicializa os atributos da classe */
    public AlunoService(){
        this.repoCurso = new CursoRepository();
        this.listaAlunos = new ArrayList<>();
        this.listaCursos = repoCurso.listarTodos();
        this.scanner = new Scanner(System.in);
        this.repoAluno = new AlunoRepository();
    }

    /*** retorna os alunos do "BD" */
    public void listar() {
        /** pega no "Banco de Dados" a lista de alunos e carrega na 
         * na variavel listarAlunos */
        listaAlunos = repoAluno.listarTodos();     
        if(listaAlunos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        /*** imprime para o usuário a lista de alunos encontrada */
        System.out.println("\n=== Lista de Alunos ===");
        for(Aluno a : listaAlunos) {
            System.out.println(a);
        }
        System.out.println("Total: " + listaAlunos.size() + " alunos");
    }

    /*** adiciona um novo aluno no "BD" */
    public void adicionar() {
        System.out.println("\n--- Novo Aluno ---");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        /*** Apresenta os cursos disponiveis no BD para a escolha do usuário 
        *   Lembrando que os cursos foram carregados no construtor da classe */
        System.out.println("\n=== Lista de Cursos ===");
        for(Curso c : listaCursos) {
            System.out.println("      " + c);
        }   
        System.out.println("Escolha um curso:");     
        int idCurso = scanner.nextInt();

        /*** Percorre a lista cursos para pegar o curso de mesmo ID indicado pelo usuário
        *    ao encontrar guarda no objeto cursoSelecionado */
        Curso cursoSelecionado = null; //cria um curso temporário
        for (Curso c : listaCursos){
            if(c.getId() == idCurso) {
                cursoSelecionado = c;
                break;
            }
        }

        /*** cria um objeto aluno e carrega as informações dos atributos, que foram passados pelo usuário */
        Aluno novoAluno = new Aluno(nome, idade, cpf, cursoSelecionado);
        repoAluno.salvar(novoAluno);
      
        System.out.println("Aluno adicionado com sucesso! ID: " + novoAluno.getId());
    }

    /*** Exclui um aluno do "BD" */
    public void remover() {
        /*** apresenta os alunos do "BD" que poderiam ser atualizados */
        listar();
        /*** se a não houver alunos ele sai do método */
        if(listaAlunos.isEmpty()) return;
        
        System.out.print("Digite o ID do aluno para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        /*** atraves de expressão lambda (Java 8) e o método removeIf do objeto List, exclui o aluno de mesmo ID */
        boolean removido = listaAlunos.removeIf(a -> a.getId() == id);
        
        if(removido) {
            System.out.println("Aluno deletado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    /*** ataliza as informações de um objeto aluno */
    public void atualizar() {
        /*** apresenta os objetos alunis que poderiam ser atualizados */
        listar();
        /*** se a não houver alunos ele sai do método */
        if(listaAlunos.isEmpty()) return;
        
        System.out.print("Digite o ID do aluno para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno alunoSelecionado = null; //cria um aluno temporário
        /*** percorre a lista de alunos do "BD" procurando pelo ID passado pelo usuário. Se encontrar, carrega no objeto alunoSelecionado */
        for (Aluno c : listaAlunos){
            if(c.getId() == id) {
                alunoSelecionado = c;
                break;
            }
        }

        if(alunoSelecionado == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        /*** Atualiza o aluno com as novas informações */
        System.out.println("\nAtualizando Aluno: " + alunoSelecionado.getNome());
        
        System.out.print("Novo nome (Enter para manter): ");
        String nome = scanner.nextLine();
        if(!nome.isEmpty()) {
            alunoSelecionado.setNome(nome);
        }
        
        System.out.print("Nova idade (0 para manter): ");
        int idade = scanner.nextInt();
        if(idade > 0) {
            alunoSelecionado.setIdade(idade);
        }

        System.out.print("Novo CPF (Enter para manter): ");
        String cpf = scanner.nextLine();
        if(!cpf.isEmpty()) {
            alunoSelecionado.setCpf(cpf);
        }

        System.out.println("\n=== Lista de Cursos ===");
        for(Curso c : listaCursos) {
            System.out.println("      " + c);
        }   
        System.out.println("Novo curso (0 para manter):");     
        int idCurso = scanner.nextInt();

        /*** Atualiza o curso do aluno */
        Curso cursoSelecionado = null; //cria um curso temporário
        for (Curso c : listaCursos){
            if(c.getId() == idCurso) {
                cursoSelecionado = c;
                break;
            }
        }
        if(idCurso > 0)
            alunoSelecionado.setCurso(cursoSelecionado);

        scanner.nextLine();        
        System.out.println("Curso atualizado com sucesso!");
    }

    public void buscar() {
        /** guarda a lista de alunos atual */
        listaAlunos = repoAluno.listarTodos();
        
        System.out.print("\nDigite o nome para buscar: ");
        String nome = scanner.nextLine().toLowerCase();

        /** cria uma lista para guardar os alunos encontrados na busca */
        ArrayList<Aluno> resultados = new ArrayList<>();
        for(Aluno a : listaAlunos) {
            if(a.getNome().toLowerCase().contains(nome)) {
                resultados.add(a);
            }
        }
        
        if(resultados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            System.out.println("\n--- Resultados da Busca ---");
            for(Aluno a : resultados) {
                System.out.println(a);
            }
            System.out.println("Encontrados: " + resultados.size() + " cursos");
        }
    }
}

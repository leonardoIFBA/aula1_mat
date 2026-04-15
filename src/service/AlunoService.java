package service;

import java.util.*;

import model.Aluno;
import model.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;


public class AlunoService {
    private List<Aluno> listaAlunos;
    private List<Curso> listaCursos;
    private Scanner scanner;
    private AlunoRepository repoAluno;
    private CursoRepository repoCurso;

    public AlunoService(){
        this.repoCurso = new CursoRepository();
        this.listaAlunos = new ArrayList<>();
        this.listaCursos = repoCurso.listarTodos();
        this.scanner = new Scanner(System.in);
        this.repoAluno = new AlunoRepository();
    }

    public void listar() {
        listaAlunos = repoAluno.listarTodos();     
        if(listaAlunos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        
        System.out.println("\n=== Lista de Alunos ===");
        for(Aluno a : listaAlunos) {
            System.out.println(a);
        }
        System.out.println("Total: " + listaAlunos.size() + " alunos");
    }

    public void adicionar() {
        System.out.println("\n--- Novo Aluno ---");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        
        System.out.println("\n=== Lista de Cursos ===");
        for(Curso c : listaCursos) {
            System.out.println("      " + c);
        }   
        System.out.println("Escolha um curso:");     
        int idCurso = scanner.nextInt();

        Curso cursoSelecionado = null; //cria um curso temporário
        for (Curso c : listaCursos){
            if(c.getId() == idCurso) {
                cursoSelecionado = c;
                break;
            }
        }

        Aluno novoAluno = new Aluno(nome, idade, cpf, cursoSelecionado);
        repoAluno.salvar(novoAluno);
      
        System.out.println("Aluno adicionado com sucesso! ID: " + novoAluno.getId());
    }

    public void remover() {
        listar();
        if(listaAlunos.isEmpty()) return;
        
        System.out.print("Digite o ID do aluno para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        boolean removido = listaAlunos.removeIf(a -> a.getId() == id);
        
        if(removido) {
            System.out.println("Aluno deletado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void atualizar() {
        listar();
        if(listaAlunos.isEmpty()) return;
        
        System.out.print("Digite o ID do aluno para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno alunoSelecionado = null; //cria um aluno temporário
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
        listaAlunos = repoAluno.listarTodos();
        
        System.out.print("\nDigite o nome para buscar: ");
        String nome = scanner.nextLine().toLowerCase();
        
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
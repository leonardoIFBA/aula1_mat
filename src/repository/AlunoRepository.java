package repository;
import java.util.*;

import model.Aluno;
import model.Curso;

/**** As classes da camada repository em projetos Java, servem para abstrair o acesso aos dados. 
 * Elas isolam a regra de negócio da tecnologia de persistência */
public class AlunoRepository{
    /** A lista de alunos irá simular nossa tabela do banco de dados */
    private List<Aluno> alunos = new ArrayList<>();
    /**** simula o identificador do objeto cadastrado */
    private static int contadorId = 1;

    /*** o construtor da classe cria 3 objetos aluno e adiciona na lista de alunos, simula uma tabela de BD com informações */
    public AlunoRepository(){
        // Adicionar alguns cursos para teste
        Curso c = new Curso(0, "Teste", 1000);
        alunos.add(new Aluno(contadorId++, "João", "joao@mail", 20, "111.222.333.10", c));
        alunos.add(new Aluno(contadorId++, "Maria", "maria@mail", 19, "222.333.444.01", c));
        alunos.add(new Aluno(contadorId++, "Bruxa", "bruxa@mail",120, "333.444.555.12", c));
    }

    /**** salva um objeto aluno na lista de alunos */
    public void salvar(Aluno aluno){
        aluno.setId(contadorId++);
        alunos.add(aluno);
    }

    /**** exclui um objeto aluno na lista de alunos */
    public void excluir(Aluno aluno){
        alunos.remove(aluno);
    }

    /**** devolve uma lista de objetos aluno */
    public List<Aluno> listarTodos(){
        return alunos;
    }

    /**** retorna o valor do id */
    public static int getContadorId() {
        return contadorId;
    }
}
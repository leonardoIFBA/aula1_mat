package repository;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public AlunoRepository(){
        // Um aluno precisa de um curso, criamos um curso para vincular com o aluno
        Curso c = new Curso(0, "Teste", 1000);
        // Adicionar alguns alunos para teste
        alunos.add(new Aluno(contadorId++, "João", 20, "111.222.333.10", c));
        alunos.add(new Aluno(contadorId++, "Maria", 19, "222.333.444.01", c));
        alunos.add(new Aluno(contadorId++, "Bruxa",120, "333.444.555.12", c));
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

    /**** retorna o id */
    public static int getContadorId() {
        return contadorId;
    }
}

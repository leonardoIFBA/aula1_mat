package repository;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public AlunoRepository(){
        // Adicionar alguns cursos para teste
        Curso c = new Curso(0, "Teste", 1000);
        alunos.add(new Aluno(contadorId++, "João", 20, "111.222.333.10", c));
        alunos.add(new Aluno(contadorId++, "Maria", 19, "222.333.444.01", c));
        alunos.add(new Aluno(contadorId++, "Bruxa",120, "333.444.555.12", c));
    }

    public void salvar(Aluno aluno){
        aluno.setId(contadorId++);
        alunos.add(aluno);
    }

    public void excluir(Aluno aluno){
        alunos.remove(aluno);
    }

    public List<Aluno> listarTodos(){
        return alunos;
    }

    public static int getContadorId() {
        return contadorId;
    }
}

package repository;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

/**** As classes da camada repository em projetos Java, servem para abstrair o acesso aos dados. 
 * Elas isolam a regra de negócio da tecnologia de persistência */
public class CursoRepository {
    /** A lista de cursos irá simular nossa tabela do banco de dados */
    private List<Curso> cursos = new ArrayList<>();
    /**** simula o identificador do objeto cadastrado */
    private static int contadorId = 1;

    /*** o construtor da classe cria 3 objetos curso e adiciona na lista de cursos, simula uma tabela de BD com informações */
    public CursoRepository(){
        // Adicionar alguns cursos para teste
        cursos.add(new Curso(contadorId++, "Java Básico", 40));
        cursos.add(new Curso(contadorId++, "Python", 60));
        cursos.add(new Curso(contadorId++, "Excel", 20));
    }

    /**** salva um objeto curso na lista de cursos */
    public void salvar(Curso curso){
        curso.setId(contadorId++);
        cursos.add(curso);
    }

    /**** exclui um objeto curso na lista de cursos */
    public void excluir(Curso curso){
        cursos.remove(curso);
    }

    /**** devolve uma lista de objetos curso */
    public List<Curso> listarTodos(){
        //System.out.println(cursos);
        return cursos;
    }

    /**** retorna o valor do id */
    public static int getContadorId() {
        return contadorId;
    }

    
}

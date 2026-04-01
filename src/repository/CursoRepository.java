package repository;

import java.util.*;

import model.Curso;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();
    private static int contadorId = 1;

    public CursoRepository(){
        cursos.add(new Curso(contadorId++,"Informatica", 3200));
        cursos.add(new Curso(contadorId++,"Edificacoes", 3100));
        cursos.add(new Curso(contadorId++,"Mineracao", 3000));
    }

    public static int getContadorId(){
        return contadorId;
    }

    public void salvar(Curso curso){
        curso.setId(contadorId++);
        cursos.add(curso);
    }

    public void excluir(Curso curso){
        cursos.remove(curso);
    }

    public List<Curso> listarTodos(){
        return cursos;
    }
    

}

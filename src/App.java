import java.util.Scanner;

import service.AlunoService;
import service.CursoService;

public class App {
    CursoService cursoService = new CursoService();
    AlunoService alunoService = new AlunoService();
    Scanner scanner = new Scanner(System.in)    ;
    
    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello, World!");

        Aluno a = new Aluno("Leonardo", 44, "11223345");
        //System.out.println(a.toString());

        Curso c = new Curso(1, "InformÃ¡tica", 40);
        Curso c1 = new Curso(2, "EdificaÃ§Ãµes", 40);
        Curso c2 = new Curso(3, "MineraÃ§Ã£o", 40);

        a.setCurso(c);
        System.out.println(a.toString());
        CursoRepository repo = new CursoRepository();
        repo.salvar(c);
        repo.salvar(c1);
        repo.salvar(c2);

        System.out.println(repo.listarTodos());*/
        new App().execute();
    }

    public void mostrarMenuCurso(){
        System.out.println("\n==== SISTEMA CRUD CURSO =====");
        System.out.println("1 - Adicionar novo curso");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Atualizar um curso");
        System.out.println("4 - Excluir curso");
        System.out.println("5 - Buscar");
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção: ");;
    }

    public void mostrarMenuAluno(){
        System.out.println("\n==== SISTEMA CRUD ALUNO =====");
        System.out.println("1 - Adicionar novo aluno");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Atualizar um aluno");
        System.out.println("4 - Excluir aluno");
        System.out.println("5 - Buscar");
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção: ");
    }

    public void execute(){
        int menuPrincipal, subMenu;
        do{
            System.out.println("\n=== Bem vindo ao Sistema IFBA Aula 2 ===");
            System.out.println("1 - Gerenciar Curso");
            System.out.println("2 - Gerenciar Aluno");
            System.out.println("0 - Fechar o programa");
            System.out.println("Escolha a opção: ");
            menuPrincipal = scanner.nextInt();

            switch (menuPrincipal) {
                case 0: System.out.println("Aplicação finalizada.");         
                    break;
                case 1:
                        do{
                            mostrarMenuCurso();
                            subMenu = scanner.nextInt();
                            scanner.nextLine(); 
                            switch (subMenu) {
                                case 1:cursoService.adicionar(); break;
                                case 2: cursoService.listar(); break;
                                case 3: cursoService.atualizar(); break;
                                case 4: cursoService.excluir(); break;
                                case 5: cursoService.buscar(); break;
                                case 0: System.out.println("Voltar"); break;
                                default: System.out.println("Opção Invalida");
                            }
                        }while (subMenu !=0);
                    break;
                case 2:
                        do{
                            mostrarMenuAluno();
                            subMenu = scanner.nextInt();
                            scanner.nextLine(); 
                            switch (subMenu) {
                                case 1: alunoService.adicionar(); break;
                                case 2: alunoService.listar(); break;
                                case 3: alunoService.atualizar(); break;
                                case 4: alunoService.remover(); break;
                                case 5: alunoService.buscar(); break;
                                case 0: System.out.println("Voltar"); break;
                                default: System.out.println("Opção inválida!"); break;
                            }
                        }while (subMenu !=0);
                    break;
            
                default:
                    break;
            }    
        }while(menuPrincipal != 0);
        scanner.close();
    }

    

}

package AT3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaManager biblioteca = new BibliotecaManager();
        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuario");
            System.out.println("3 - Consultar Livros");
            System.out.println("4 - Consultar Usuarios");
            System.out.println("5 - Realizar Emprestimo");
            System.out.println("6 - Consultar Emprestimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarLivro(biblioteca, scanner);
                    break;
                case 2:
                    cadastrarUsuario(biblioteca, scanner);
                    break;
                case 3:
                    biblioteca.consultarLivros();
                    break;
                case 4:
                    biblioteca.consultarUsuarios();
                    break;
                case 5:
                    realizarEmprestimo(biblioteca, scanner);
                    break;
                case 6:
                    biblioteca.consultarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void cadastrarLivro(BibliotecaManager biblioteca, Scanner scanner) {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        Livro livro = new Livro(0, titulo, autor, ano, true);
        biblioteca.cadastrarLivro(livro);
    }
    
    private static void cadastrarUsuario(BibliotecaManager biblioteca, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();
        
        Usuario usuario = new Usuario(0, nome, email, telefone, endereco);
        biblioteca.cadastrarUsuario(usuario);
    }
    
    private static void realizarEmprestimo(BibliotecaManager biblioteca, Scanner scanner) {
        System.out.print("ID do Livro: ");
        int livroId = scanner.nextInt();
        System.out.print("ID do Usuario: ");
        int usuarioId = scanner.nextInt();
        scanner.nextLine();
        
        biblioteca.realizarEmprestimo(livroId, usuarioId);
    }
}

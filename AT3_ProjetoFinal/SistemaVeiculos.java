import java.util.List;
import java.util.Scanner;

public class SistemaVeiculos {
    private static VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        DatabaseConnection.createTables();
        
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    consultarVeiculos();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
            
        } while (opcao != 3);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE VEICULOS ===");
        System.out.println("1 - Cadastrar Veiculo");
        System.out.println("2 - Consultar Veiculos");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opcao: ");
    }
    
    private static void cadastrarVeiculo() {
        System.out.println("\n=== CADASTRAR VEICULO ===");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        
        System.out.print("Preco: R$ ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        
        Veiculo veiculo;
        
        if (tipo == 1) {
            System.out.print("Numero de portas: ");
            int portas = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Tipo de combustivel (Gasolina/Flex/Eletrico): ");
            String combustivel = scanner.nextLine();
            
            veiculo = new Carro(marca, modelo, ano, preco, portas, combustivel);
        } else {
            System.out.print("Cilindrada (cc): ");
            int cilindrada = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Tipo de partida (Eletrica/Pedal): ");
            String partida = scanner.nextLine();
            
            veiculo = new Moto(marca, modelo, ano, preco, cilindrada, partida);
        }
        
        if (veiculoDAO.cadastrarVeiculo(veiculo)) {
            System.out.println("Veiculo cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar veiculo!");
        }
    }
    
    private static void consultarVeiculos() {
        System.out.println("\n=== CONSULTAR VEICULOS ===");
        System.out.println("1 - Consultar todos");
        System.out.println("2 - Consultar por marca");
        System.out.print("Escolha uma opcao: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        List<Veiculo> veiculos;
        
        if (opcao == 1) {
            veiculos = veiculoDAO.consultarTodos();
        } else {
            System.out.print("Digite a marca: ");
            String marca = scanner.nextLine();
            veiculos = veiculoDAO.consultarPorMarca(marca);
        }
        
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo encontrado!");
        } else {
            System.out.println("\n=== VEICULOS ENCONTRADOS ===");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
        }
    }
}
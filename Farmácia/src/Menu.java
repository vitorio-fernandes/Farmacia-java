import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    InterfaceClientes clientesRepository = new ClientesRepository();
    InterfaceProdutos produtosRepository = new ProdutosRepository();
    public void MenuPrincipal() {
        System.out.println("-------------- SISTEMA DE FARMÁCIA --------------");
        System.out.println("1 - Produtos ");
        System.out.println("2 - Venda ");
        System.out.println("3 - Clientes");
        System.out.println("0 - Sair");
        funcoesPrincipal();
    }

    public void funcoesPrincipal() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuVenda();
                    break;
                case 3:
                    menuClientes();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    MenuPrincipal();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void menuProdutos() {
        System.out.println("-------------- MENU DE PRODUTOS --------------");
        System.out.println("1 - Cadastrar Produtos ");
        System.out.println("2 - Remover Produtos ");
        System.out.println("3 - Listar Produtos ");
        System.out.println("4 - Voltar ");
        funcoesProdutos();
    }

    public void funcoesProdutos() {
        try {
            int opcao_produto = scanner.nextInt();
            scanner.nextLine();
            switch (opcao_produto) {
                case 1:
                    double preco = -1;
                    int estoque = -1;

                    System.out.println("1 - Medicamento 2 - Cosmético");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    if (escolha == 1) {
                        System.out.println("Digite o nome do Medicamento: ");
                        String descricao = scanner.nextLine();
                        while (preco < 0) {
                            System.out.println("Digite o preço do Medicamento: ");
                            preco = scanner.nextDouble();
                        }
                        while (estoque < 0) {
                            System.out.println("Digite a quantidade no estoque: ");
                            estoque = scanner.nextInt();
                        }
                        scanner.nextLine();
                        System.out.println("Digite a validade do Produto: ");
                        String validade = scanner.nextLine();
                        System.out.println("Digite o nome do Fornecedor: ");
                        String fornecedor = scanner.nextLine();

                        Medicamento medicamento = new Medicamento(descricao, preco, estoque, validade,
                                new Fornecedor(fornecedor));

                        produtosRepository.adiconarProdutos(medicamento);
                        System.out.println("Produto cadastrado com sucesso!");
                        menuProdutos();
                    } else if (escolha == 2) {
                        System.out.println("Digite o nome do Cosmético: ");
                        String descricao = scanner.nextLine();
                        while (preco < 0) {
                            System.out.println("Digite o preço do Cosmético: ");
                            preco = scanner.nextDouble();
                        }
                        while (estoque < 0) {
                            System.out.println("Digite a quantidade no estoque: ");
                            estoque = scanner.nextInt();
                        }
                        scanner.nextLine();
                        System.out.println("Digite a validade do Produto: ");
                        String validade = scanner.nextLine();
                        System.out.println("Digite o nome do Fornecedor: ");
                        String fornecedor = scanner.nextLine();
                        Cosmetico cosmetico = new Cosmetico(descricao, preco, estoque, validade,
                                new Fornecedor(fornecedor));
                        produtosRepository.adiconarProdutos(cosmetico);
                        System.out.println("Produto cadastrado com sucesso!");
                        menuProdutos();
                    } else {
                        System.out.println("Opção Inválida !\n");
                        menuProdutos();
                    }
                    break;
                case 2:
                    if (produtosRepository.getProdutos().size() > 0) {
                        produtosRepository.listarProdutos();
                        System.out.println("Digite o índice do produto que deseja remover: ");
                        int remocao = scanner.nextInt();
                        if (remocao < 0 || remocao >= produtosRepository.getProdutos().size()) {
                            System.out.println("Escolha Incorreta \n");
                        } else {
                            produtosRepository.removerProduto(remocao);
                            System.out.println("Produto removido com sucesso!");
                        }
                    } else {
                        System.out.println("Não há Produtos Cadastrados !\n");
                    }

                    menuProdutos();
                    break;
                case 3:
                    if (produtosRepository.getProdutos().size() > 0) {
                        produtosRepository.listarProdutos();
                    } else {
                        System.out.println("Não há produtos cadastrados !\n");
                    }

                    menuProdutos();
                    break;
                case 4:
                    MenuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida !\n");
                    menuProdutos();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
            menuProdutos();
        }
    }

    public void menuVenda() {
        System.out.println("-------------- MENU DE VENDA --------------");
        System.out.println("1 - Realizar Venda");
        System.out.println("2 - Voltar ");
        funcoesVenda();
    }

    public void funcoesVenda() {
        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                produtosRepository.listarProdutos();
                System.out.println("Digite o índice do produto que deseja comprar: ");
                int indiceCompra = scanner.nextInt();
                scanner.nextLine();
                if (indiceCompra <= 0 || indiceCompra > produtosRepository.getProdutos().size()) {
                    System.out.println("Índice incorreto!\n");
                } else {
                    Produto produto = produtosRepository.getProdutos().get(indiceCompra - 1);
                    System.out.println("Digite a quantidade desejada: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidade > 0 && quantidade <= produto.getEstoque()) {
                        double valor = produto.getPreco();
                        double valorTotal = quantidade * valor;
                        System.out.println("O valor total da sua compra foi R$:" + valorTotal);
                        produtosRepository.venderProduto(indiceCompra - 1, quantidade);
                    } else {
                        System.out.println("Quantidade inválida ou estoque insuficiente.");
                    }
                }
                break;
            case 2:
                MenuPrincipal();
                break;
            default:
                System.out.println("Opção Inválida !\n");
                break;
        }
    }

    public void menuClientes() {
        System.out.println("-------------- MENU DE CLIENTES --------------");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Listar Clientes");
        System.out.println("4 - Voltar ");
        funcoes_Clintes();
    }

    public void funcoes_Clintes() {
        int escolha = scanner.nextInt();
        scanner.nextLine();
        switch (escolha) {
            case 1:
                String cpf = "";
                System.out.println("Digite o nome do Cliente: ");
                String nome = scanner.nextLine();
                while (cpf.length() != 11) {
                    System.out.println("Digite o CPF (Sem ponto e traços)");
                    cpf = scanner.nextLine();
                }
                Cliente cliente = new Cliente(nome, cpf);
                clientesRepository.adicionarClientes(cliente);
                System.out.println("Cliente cadastrado com sucesso !\n");
                break;
            case 2:
                if (clientesRepository.getClientes().size() > 0) {
                    clientesRepository.listarClientes();
                    System.out.println("Digite o indíce do cliente: ");
                    int indice_cliente = scanner.nextInt();
                    if (indice_cliente <= 0 || indice_cliente > clientesRepository.getClientes().size()) {
                        System.out.println("Indíce Incoreto !\n");
                    } else {
                        clientesRepository.removerCliente(indice_cliente - 1);
                    }
                } else {
                    System.out.println("Não há clientes cadastrados !\n");
                }

                break;
            case 3:
                if (clientesRepository.getClientes().size() > 0) {
                    clientesRepository.listarClientes();
                } else {
                    System.out.println("Não há clientes cadastrados !\n");
                }

                break;
            case 4:
                MenuPrincipal();
            default:
                System.out.println("Opção Inválida !\n");
                break;
        }
    }
}

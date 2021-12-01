package br.inatel.projeto;
import java.util.Scanner;

import br.inatel.projeto.database.*;

public class Principal {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        VendaDB vendaDB = new VendaDB();
        ClienteDB clienteDB = new ClienteDB();
        VendedorDB vendedorDB = new VendedorDB();
        Venda_has_ProdutoDB venda_has_produtoDB = new Venda_has_ProdutoDB();
        ProdutoDB produtoDB = new ProdutoDB();
        CompradorDB compradorDB = new CompradorDB();
        FornecedorDB fornecedorDB = new FornecedorDB();
        ContaBancariaDB contaBancariaDB = new ContaBancariaDB();


        int opcao1, opcao2, opcao3, opcao4, opcao5, opcao6, opcao7, opcao8, opcao11;

        for (; ;) {

            System.out.println("Informe qual portal deseja ter acesso: ");
            System.out.println("1 - Portal do cliente");
            System.out.println("2 - Portal do funcionario");
            System.out.println("3 - Portal do dono");
            opcao1 = input.nextInt();

            switch (opcao1) {

                //portal do cliente
                case 1:

                    boolean pag1 = true;
                    while (pag1) {

                        System.out.println("Informe o que você deseja fazer: ");
                        System.out.println("1 - Ver meus pedidos");
                        System.out.println("2 - Voltar ao menu anterior");
                        opcao2 = input.nextInt();

                        switch (opcao2) {

                            case 1:

                                String cpf = null;
                                System.out.println("Informe o seu cpf: ");
                                cpf = input.next();

                                clienteDB.researchCliente(cpf);

                                break;

                            case 2:
                                pag1 = false;
                                break;
                        }

                    }
                    break;

                //portal do funcionario
                case 2:


                    boolean pag2 = true;
                    while (pag2) {

                        System.out.println("Informe o que você deseja fazer: ");
                        System.out.println("1 - Acessar o portal de vendedor");
                        System.out.println("2 - Acessar o portal de comprador");
                        System.out.println("3 - Voltar ao menu principal");
                        opcao3 = input.nextInt();

                        switch (opcao3) {

                            //portal do vendedor
                            case 1:

                                boolean pag3 = true;
                                while (pag3) {

                                    System.out.println("Informe o que você deseja fazer: ");
                                    System.out.println("1 - Cadastrar um novo cliente");
                                    System.out.println("2 - Realizar uma venda");
                                    System.out.println("3 - Excluir um cliente do sistema");
                                    System.out.println("4 - Atualizar os dados de um cliente");
                                    System.out.println("5 - Buscar um cliente pelo cpf");
                                    System.out.println("6 - Voltar a pagina anterior");
                                    opcao4 = input.nextInt();

                                    switch (opcao4) {

                                        //cadastrar um cliente
                                        case 1:

                                            String cpf = null;
                                            String nome = null;
                                            String telefone = null;

                                            System.out.println("Informe o cpf: ");
                                            cpf = input.next();
                                            input.nextLine();

                                            if(clienteDB.researchClienteByCpf(cpf)) {
                                                System.out.println("Esse cliente já está cadastrado em nosso sistema!");
                                            } else {
                                                System.out.println("Informe o nome: ");
                                                nome = input.nextLine();
                                                System.out.println("Informe o numero de telefone: ");
                                                telefone = input.next();
                                                Cliente cliente = new Cliente(cpf, nome, telefone);
                                                clienteDB.insertCliente(cliente);
                                                System.out.println("Cliente cadastrado");
                                            }
                                            break;

                                        //realizar uma venda
                                        case 2:

                                            String Cliente_cpf;
                                            String Vendedor_Funcionario_cpf;

                                            System.out.println("Informe o cpf do cliente: ");
                                            Cliente_cpf = input.next();

                                            if (clienteDB.researchClienteByCpf(Cliente_cpf)) {
                                                System.out.println("Informe seu cpf: ");
                                                Vendedor_Funcionario_cpf = input.next();

                                                if(vendedorDB.researchVendedorByCpf(Vendedor_Funcionario_cpf)) {
                                                    Venda venda = new Venda(Cliente_cpf, Vendedor_Funcionario_cpf);
                                                    vendaDB.insertVenda(venda);
                                                    System.out.println("Venda cadastrada");

                                                    boolean pag7 = true;
                                                    while (pag7) {
                                                        System.out.println("1 - Insira produtos a nova venda");
                                                        System.out.println("2 - Fechar venda e gerar nota fiscal");
                                                        opcao6 = input.nextInt();

                                                        switch (opcao6) {

                                                            case 1:
                                                                int Produto_SNProduto;
                                                                int qtdProdutos;

                                                                System.out.println("Informe o SN do produto: ");
                                                                Produto_SNProduto = input.nextInt();
                                                                System.out.println("Informe a quantidade de produtos: ");
                                                                qtdProdutos = input.nextInt();

                                                                Venda_has_Produto venda_has_produto = new Venda_has_Produto(venda.getIdVenda(), Produto_SNProduto, qtdProdutos);
                                                                venda_has_produtoDB.insertVenda_Produto(venda_has_produto);
                                                                venda.setQtdProdutos(venda.getQtdProdutos() + qtdProdutos);
                                                                venda.setValorVenda(venda.getValorVenda() + (produtoDB.research_ValorProduto(Produto_SNProduto) * qtdProdutos));
                                                                break;

                                                            case 2:
                                                                Arquivo arquivo = new Arquivo();
                                                                arquivo.escrever(venda);
                                                                System.out.println("Venda completa, nota fiscal gerada!");
                                                                pag7 = false;
                                                                break;
                                                        }

                                                    }
                                                    break;
                                                } else {
                                                    System.out.println("Esse vendedor não está cadastrado");
                                                    break;
                                                }

                                            } else {
                                                System.out.println("Esse cliente não está cadastrado");
                                                break;
                                            }


                                        //excluir um cliente do sistema
                                        case 3:

                                            String cpf_cliente;

                                            System.out.println("Informe o cpf do cliente: ");
                                            cpf_cliente = input.next();

                                            clienteDB.deleteCliente(cpf_cliente);
                                            System.out.println("Cliente excluído com sucesso!");
                                            break;

                                        //atualizar o telefone de um cliente
                                        case 4:

                                            String cpf_Cliente;
                                            String telefoneAtualizado;

                                            System.out.println("Informe o cpf do cliente que deseja atualizar: ");
                                            cpf_Cliente = input.next();


                                            System.out.println("Informe o novo número de telefone:");
                                            telefoneAtualizado = input.next();
                                            clienteDB.updateCliente(cpf_Cliente, telefoneAtualizado);
                                            System.out.println("Número de telefone atualizado com sucesso!");
                                            break;

                                        //atualizar o telefone de um cliente
                                        case 5:

                                            String cliente_cpf;

                                            System.out.println("Informe o cpf do cliente que deseja buscar: ");
                                            cliente_cpf = input.next();


                                            clienteDB.searchCliente(cliente_cpf);

                                            break;


                                        //voltar a pagina anterior
                                        case 6:
                                            pag3 = false;
                                            break;
                                    }
                                }
                                break;

                            case 2:

                                boolean pag5 = true;

                                while (pag5){

                                    System.out.println("Informe o que você deseja fazer: ");
                                    System.out.println("1 - Cadastrar um novo fornecedor");
                                    System.out.println("2 - Cadastrar um novo produto");
                                    System.out.println("3 - Realizar uma compra");
                                    System.out.println("4 - Voltar a pagina anterior");
                                    opcao8 = input.nextInt();

                                    switch (opcao8){

                                        case 1:

                                            String cnpj;
                                            String nome;
                                            String telefone;
                                            String comprador_cpf;

                                            System.out.println("Informe o cnpj do fornecedor: ");
                                            cnpj = input.next();
                                            input.nextLine();
                                            System.out.println("Informe o nome do fornecedor: ");
                                            nome = input.nextLine();
                                            System.out.println("Informe o telefone do fornecedor: ");
                                            telefone = input.next();
                                            System.out.println("Informe seu cpf: ");
                                            comprador_cpf = input.next();

                                            if ( compradorDB.researchCompradorByCpf(comprador_cpf)) {
                                                Fornecedor fornecedor1 = new Fornecedor(cnpj, nome, telefone, comprador_cpf);
                                                fornecedorDB.insertFornecedor(fornecedor1);

                                                System.out.println("Fornecedor cadastrado com sucesso");
                                                break;
                                            } else {
                                                System.out.println("Não é possivel cadastrar esse fornecedor. " +
                                                        "Esse cpf do comprador não existe");
                                                break;
                                            }

                                        case 2:

                                            int SN;
                                            String nomeProduto;
                                            float valor_compra;
                                            float valor_venda;
                                            String fornecedor_cnpj;

                                            System.out.println("Informe o SN do produto: ");
                                            SN = input.nextInt();
                                            input.nextLine();
                                            System.out.println("Informe o nome do produto: ");
                                            nomeProduto = input.nextLine();
                                            System.out.println("Informe o valor de compra do produto: ");
                                            valor_compra = input.nextFloat();
                                            input.nextLine();
                                            System.out.println("Informe o valor de venda do produto: ");
                                            valor_venda = input.nextFloat();
                                            input.nextLine();
                                            System.out.println("Informe o cnpj do fornecedor que vende o produto: ");
                                            fornecedor_cnpj = input.next();

                                            Produto produto = new Produto(SN, nomeProduto, valor_compra, valor_venda, fornecedor_cnpj);
                                            produtoDB.insertProduto(produto);

                                            System.out.println("Produto cadastrado com sucesso");
                                            break;

                                        case 3:

                                            break;

                                        case 4:
                                            pag5 = false;
                                            break;
                                    }

                                }

                            case 3:
                                pag2 = false;
                                break;

                        }
                    }
                    break;

                case 3:

                    String cpf;
                    String nome;
                    String telefone;
                    String gestor_cpf;
                    int numeroConta;
                    int agenciaConta;

                    boolean pag4 = true;
                    while (pag4) {
                        System.out.println("Informe o que você deseja fazer: ");
                        System.out.println("1 - Cadastrar um novo funcionario");
                        System.out.println("2 - Pagar um funcionario");
                        System.out.println("3 - Voltar ao menu principal");
                        opcao5 = input.nextInt();

                        switch (opcao5) {

                            case 1:

                                System.out.println("Informe qual função o novo funcionário vai exercer: ");
                                System.out.println("1 - Vendedor");
                                System.out.println("2 - Comprador");
                                opcao7 = input.nextInt();

                                switch (opcao7) {
                                    case 1:

                                        System.out.println("Informe o cpf: ");
                                        cpf = input.next();
                                        input.nextLine();
                                        System.out.println("Informe o nome completo: ");
                                        nome = input.nextLine();
                                        System.out.println("Informe o numero de telefone: ");
                                        telefone = input.next();
                                        input.nextLine();
                                        System.out.println("Informe o cpf do gestor responsavel pelo novo funcionario: ");
                                        gestor_cpf = input.next();
                                        System.out.println("Informe o numero da conta bancaria do novo funcionario: ");
                                        numeroConta = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Informe o numero da agencia da conta do novo funcionario: ");
                                        agenciaConta = input.nextInt();
                                        input.nextLine();
                                        Vendedor vendedor1 = new Vendedor(cpf, nome, telefone, gestor_cpf);
                                        ContaBancaria contaBancaria = new ContaBancaria(numeroConta, agenciaConta,cpf);
                                        vendedorDB.insertVendedor(vendedor1);
                                        contaBancariaDB.insertContaBancaria(contaBancaria);
                                        System.out.println("Funcionário cadastrado com sucesso!");
                                        break;

                                    case 2:

                                        System.out.println("Informe o cpf: ");
                                        cpf = input.next();
                                        input.nextLine();
                                        System.out.println("Informe o nome completo: ");
                                        nome = input.nextLine();
                                        System.out.println("Informe o numero de telefone: ");
                                        telefone = input.next();
                                        System.out.println("Informe o cpf do gestor responsavel pelo novo funcionario: ");
                                        gestor_cpf = input.next();
                                        System.out.println("Informe o numero da conta bancaria do novo funcionario: ");
                                        numeroConta = input.nextInt();
                                        System.out.println("Informe o numero da agencia da conta do novo funcionario: ");
                                        agenciaConta = input.nextInt();
                                        Comprador comprador1 = new Comprador(cpf, nome, telefone, gestor_cpf);
                                        ContaBancaria contaBancaria1 = new ContaBancaria(numeroConta, agenciaConta,cpf);
                                        compradorDB.insertComprador(comprador1);
                                        contaBancariaDB.insertContaBancaria(contaBancaria1);
                                        System.out.println("Funcionário cadastrado com sucesso!");
                                        break;
                                }
                                break;

                            case 2:
                                String cpfFunc;
                                float pagamento;
                                System.out.println("Para qual tipo de funcionario deseja realizar o pagamento: ");
                                System.out.println("1 - Vendedor");
                                System.out.println("2 - Comprador");
                                opcao11 = input.nextInt();

                                switch (opcao11){

                                    case 1:
                                        boolean metaBatida = false;
                                        System.out.println("Informe o cpf do funcionario: ");
                                        cpfFunc = input.next();
                                        pagamento = vendedorDB.research_salario(cpfFunc);
                                        contaBancariaDB.updateSalario(cpfFunc, pagamento);
                                        vendedorDB.research_meta(cpfFunc);
                                        System.out.println("Pagamento realizado com sucesso");
                                        break;

                                    case 2:
                                        System.out.println("Informe o cpf do funcionario: ");
                                        cpfFunc = input.next();
                                        pagamento = compradorDB.research_salario(cpfFunc);
                                        contaBancariaDB.updateSalario(cpfFunc, pagamento);
                                        System.out.println("Pagamento realizado com sucesso");
                                        break;

                                }
                                break;

                            case 3:
                                pag4 = false;
                                break;
                        }
                    }
                    break;
            }
        }
    }
}

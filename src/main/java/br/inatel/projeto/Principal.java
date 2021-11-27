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

        /*
        if (clienteDB.researchClienteByCpf("123")) {
            System.out.println("Cliente existe");
            clienteDB.updateCliente("123", "988214789");
            System.out.println("Cliente atualizado");
        } else {
            System.out.println("Cliente não existe");
        }
         */

        int opcao1, opcao2, opcao3, opcao4, opcao5, opcao6;

        for (; ; ) {

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

                                //
                                //
                                //

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
                                    System.out.println("3 - Voltar a pagina anterior");
                                    opcao4 = input.nextInt();

                                    switch (opcao4) {

                                        //cadastrar um cliente
                                        case 1:

                                            String cpf = null;
                                            String nome = null;
                                            String telefone = null;

                                            System.out.println("Informe o cpf: ");
                                            cpf = input.next();
                                            System.out.println("Informe o nome: ");
                                            //não ta dando certo de pegar nome com espaço
                                            nome = input.next();
                                            System.out.println("Informe o numero de telefone: ");
                                            telefone = input.next();

                                            Cliente cliente = new Cliente(cpf, nome, telefone);
                                            clienteDB.insertCliente(cliente);

                                            System.out.println("Cliente cadastrado");
                                            break;

                                        //realizar uma venda
                                        case 2:

                                            System.out.println("realizar venda");
                                            break;

                                            /*
                                            String Cliente_cpf;
                                            String Vendedor_Funcionario_cpf;

                                            System.out.println("Informe o cpf do cliente: ");
                                            Cliente_cpf = input.next();
                                            System.out.println("Informe seu cpf: ");
                                            Vendedor_Funcionario_cpf = input.next();

                                            Venda venda = new Venda(Cliente_cpf, Vendedor_Funcionario_cpf);
                                            vendaDB.insertVenda(venda);

                                            System.out.println("Venda cadastrada, deseja agregar um produto? ");
                                            System.out.println("1 - Agregar produto a nova venda");
                                            System.out.println("2 - Fechar venda e gerar nota fiscal");
                                            System.out.println("3 - Sair do menu");
                                            opcao6 = input.nextInt();

                                            switch (opcao6) {

                                                case 1:
                                                    int Produto_SNProduto;
                                                    int qtdProdutos;

                                                    System.out.println("Informe o SN do produto: ");
                                                    Produto_SNProduto = input.nextInt();
                                                    System.out.println("Informe seu cpf: ");
                                                    qtdProdutos = input.nextInt();

                                                    Venda_has_Produto venda_has_produto = new Venda_has_Produto(venda.getIdVenda(), Produto_SNProduto, qtdProdutos);
                                                    venda_has_produtoDB.insertVenda_Produto(venda_has_produto);
                                                    break;

                                                case 2:
                                                    Arquivo arquivo = new Arquivo;
                                                    arquivo.escrever(venda);

                                                case 3:
                                                    menu = false;
                                                    break;

                                                case 3:
                                                    break;

                                                case 4:

                                            }

                                        */

                                        //voltar a pagina anterior
                                        case 3:
                                            pag3 = false;
                                            break;
                                    }
                                }

                                break;

                            case 2:
                                System.out.println("portal do comprador");
                                break;

                            case 3:
                                pag2 = false;
                                break;

                        }
                    }
                    break;

                case 3:

                    System.out.println("portal do dono");
                    break;

                    /*
                    System.out.println("Informe o que você deseja fazer: ");
                    System.out.println("1 - Cadastrar um novo funcionario");
                    System.out.println("2 - Sair do menu");
                    opcao5 = input.nextInt();

                    switch (opcao5) {

                        case 1:

                            String cpf;
                            String nome;
                            String telefone;
                            String gestor_cpf;

                            System.out.println("Informe o cpf: ");
                            cpf = input.next();
                            System.out.println("Informe o nome completo: ");
                            nome = input.next();
                            System.out.println("Informe o numero de telefone: ");
                            telefone = input.next();
                            System.out.println("Informe o cpf do gestor responsavel pelo novo funcionario: ");
                            gestor_cpf = input.next();
                            Vendedor vendedor1 = new Vendedor(cpf, nome, telefone, gestor_cpf);
                            vendedorDB.insertVendedor(vendedor1);

                        case 2:
                            menu = false;
                            break;

                     */
            }
        }
    }
}

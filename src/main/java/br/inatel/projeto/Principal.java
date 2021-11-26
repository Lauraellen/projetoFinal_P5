package br.inatel.projeto;

import br.inatel.projeto.database.*;

public class Principal {

    public static void main(String[] args) {

        VendaDB vendaDB = new VendaDB();
        ClienteDB clienteDB = new ClienteDB();
        VendedorDB vendedorDB = new VendedorDB();
        Venda_has_ProdutoDB venda_has_produtoDB = new Venda_has_ProdutoDB();
        ProdutoDB produtoDB = new ProdutoDB();
        CompradorDB compradorDB = new CompradorDB();
        FornecedorDB fornecedorDB = new FornecedorDB();

        Cliente cliente1 = new Cliente();
        cliente1.setCpf("123");
        cliente1.setNome("Daiane");
        cliente1.setTelefone("35999533564");

        Vendedor vendedor1 = new Vendedor("456", "Laura", "3599475684", "Vendas",5000, "456",5, 100);

        Comprador comprador1 = new Comprador("789","Joao", "35987658972","Compras", 4000,"456","Brasil");

        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setNome("Camisas JK");
        fornecedor1.setCompradorCpf("789");
        fornecedor1.setCpf("987");
        fornecedor1.setPais("Brasil");
        fornecedor1.setTelefone("35946785864");

        Produto produto1 = new Produto();
        produto1.setSN_produto(1235456);
        produto1.setNomeProduto("Camisa G");
        produto1.setForncedor_cnpj("987");
        produto1.setValorCompra(50);
        produto1.setValorVenda(100);

        Venda venda1 = new Venda("123", "456");

        Venda_has_Produto venda_has_produto1 = new Venda_has_Produto(1, 1235456,3);

        //clienteDB.insertCliente(cliente1);
        //vendedorDB.insertVendedor(vendedor1);
        //compradorDB.insertComprador(comprador1);
        //fornecedorDB.insertFornecedor(fornecedor1);
        //produtoDB.insertProduto(produto1);
        //vendaDB.insertVenda(venda1);
        //venda_has_produtoDB.insertVenda_Produto(venda_has_produto1);
        venda_has_produtoDB.researchVenda_Produto();
    }
}

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

        if (clienteDB.researchClienteByCpf("123")) {
            System.out.println("Cliente existe");
            clienteDB.updateCliente("123", "988214789");
            System.out.println("Cliente atualizado");
        } else {
            System.out.println("Cliente não existe");
        }

    }
}

package br.inatel.projeto.database;

import br.inatel.projeto.Venda_has_Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public class Venda_has_ProdutoDB extends Database {

    //adiciona um produto a uma venda
    public boolean insertVenda_Produto(Venda_has_Produto venda_has_produto) {

        connect();
        String sql = "INSERT INTO Venda_has_Produto (Venda_idVenda, Produto_SNProduto, qtdProdutos) VALUES (?, ? ,?)";
        VendaDB vendaDB = new VendaDB();
        ProdutoDB produtoDB = new ProdutoDB();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda_has_produto.getVenda_idVenda());
            preparedStatement.setInt(2, venda_has_produto.getProduto_SNProduto());
            preparedStatement.setInt(3, venda_has_produto.getQtdProdutos());
            preparedStatement.execute();
            check = true;

            vendaDB.updateVenda(venda_has_produto.getVenda_idVenda(),venda_has_produto.getProduto_SNProduto(),venda_has_produto.getQtdProdutos());
            produtoDB.updateEstoqueVenda(venda_has_produto.getProduto_SNProduto(),venda_has_produto.getQtdProdutos());

        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Erro ao finalizar " + e.getMessage());
            }
        }

        return check;
    }
}

package br.inatel.projeto.database;

import br.inatel.projeto.Venda;
import br.inatel.projeto.Venda_has_Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public class Venda_has_ProdutoDB extends Database {

    public boolean insertVenda_Produto(Venda_has_Produto venda_has_produto) {

        connect();
        String sql = "INSERT INTO Venda_has_Produto (Venda_idVenda, Produto_SNProduto, qtdProdutos) VALUES (?, ? ,?)";
        VendaDB vendaDB = new VendaDB();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda_has_produto.getVenda_idVenda());
            preparedStatement.setInt(2, venda_has_produto.getProduto_SNProduto());
            preparedStatement.setInt(3, venda_has_produto.getQtdProdutos());
            preparedStatement.execute();
            check = true;

            vendaDB.updateVenda(venda_has_produto.getVenda_idVenda(),venda_has_produto.getProduto_SNProduto(),venda_has_produto.getQtdProdutos());

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

    public ArrayList <Venda_has_Produto> researchVenda_Produto() {

        connect();
        ArrayList <Venda_has_Produto> venda_has_produtos = new ArrayList<>();
        String sql = "SELECT * FROM Venda_has_Produto";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Venda_has_Produto venda_has_produtoTemp = new Venda_has_Produto(result.getInt("Venda_idVenda"), result.getInt("Produto_SNProduto"), result.getInt("qtdProdutos"));
                System.out.println("ID da Venda = " + venda_has_produtoTemp.getVenda_idVenda());
                System.out.println("SN do produto = " + venda_has_produtoTemp.getProduto_SNProduto());
                System.out.println("Qtd de produtos = " + venda_has_produtoTemp.getQtdProdutos());
                System.out.println("------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao finalizar " + e.getMessage());
            }
        }
        return venda_has_produtos;
    }
}

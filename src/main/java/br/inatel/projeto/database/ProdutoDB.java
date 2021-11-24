package br.inatel.projeto.database;
import br.inatel.projeto.Produto;

import java.sql.SQLException;

public class ProdutoDB extends Database {

    public boolean insertProduto(Produto produto) {
        connect();
        String sql = "INSERT INTO Produto (SN_produto, nomeProduto, valorCompra, valorVenda, Fornecedor_cnpj) VALUES (?, ? ,?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, produto.getSN_produto());
            preparedStatement.setString(2, produto.getNomeProduto());
            preparedStatement.setFloat(3, produto.getValorCompra());
            preparedStatement.setFloat(4, produto.getValorVenda());
            preparedStatement.setString(4, produto.getForncedor_cnpj());

            preparedStatement.execute();
            check = true;
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

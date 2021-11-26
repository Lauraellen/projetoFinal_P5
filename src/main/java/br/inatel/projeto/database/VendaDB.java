package br.inatel.projeto.database;

import br.inatel.projeto.Venda;

import java.sql.SQLException;

public class VendaDB extends Database {

    public boolean insertVenda(Venda venda) {

        connect();
        String sql = "INSERT INTO Venda (idVenda, Cliente_cpf, Vendedor_Funcionario_cpf, qtdProdutos, valorVenda) VALUES (?, ? ,?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda.getIdVenda());
            preparedStatement.setString(2, venda.getCliente_cpf());
            preparedStatement.setString(3, venda.getVendedor_Funcionario_cpf());
            preparedStatement.setInt(4, venda.getQtdProdutos());
            preparedStatement.setFloat(5, venda.getValorVenda());
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

    public boolean updateVenda(int idVenda, int SN_produto, int qtdProdutos) {
        float aux = 0;
        ProdutoDB produtoDB = new ProdutoDB();
        connect();
        String sql1 = "UPDATE Venda SET qtdProdutos = qtdProdutos + ? WHERE idVenda = ?";
        String sql2 = "UPDATE Venda SET valorVenda = valorVenda + ? WHERE idVenda = ?";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, qtdProdutos);
            preparedStatement.setInt(2, idVenda);
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(sql2);
            aux = produtoDB.research_ValorProduto(SN_produto);
            aux= aux * qtdProdutos;
            preparedStatement.setFloat(1, aux);
            preparedStatement.setInt(2, idVenda);
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
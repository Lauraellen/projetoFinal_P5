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
}
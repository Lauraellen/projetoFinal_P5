package br.inatel.projeto.database;

import br.inatel.projeto.Fornecedor;
import br.inatel.projeto.Produto;

import java.sql.SQLException;

public class FornecedorDB extends Database {

    public boolean insertFornecedor(Fornecedor fornecedor) {
        connect();
        String sql = "INSERT INTO Fornecedor (cnpj, nome, telefone, Comprador_Funcionario_cpf) VALUES (? ,?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fornecedor.getCpf());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getTelefone());
            preparedStatement.setString(4, fornecedor.getCompradorCpf());

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

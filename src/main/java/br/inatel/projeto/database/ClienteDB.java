package br.inatel.projeto.database;

import br.inatel.projeto.Cliente;
import br.inatel.projeto.Produto;

import java.sql.SQLException;

public class ClienteDB extends Database {

    public boolean insertCliente(Cliente cliente) {
        connect();
        String sql = "INSERT INTO Cliente (cpf, nome, telefone) VALUES (?, ? ,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getTelefone());

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

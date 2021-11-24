package br.inatel.projeto.database;

import br.inatel.projeto.Comprador;

import java.sql.SQLException;

public class CompradorDB extends Database {

    public boolean insertComprador(Comprador comprador) {
        connect();
        String sql1 = "INSERT INTO Funcionario (cpf, nome, telefone, setor, salario, gestor_cpf) VALUES (?, ? ,?, ?, ?, ?)";
        String sql2 = "INSERT INTO Comprador (Funcionario_cpf, paisVenda) VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, comprador.getCpf());
            preparedStatement.setString(2, comprador.getNome());
            preparedStatement.setString(3, comprador.getTelefone());
            preparedStatement.setString(4, comprador.getSetor());
            preparedStatement.setFloat(5, comprador.getSalario());
            preparedStatement.setString(6, comprador.getGestor_cpf());
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, comprador.getCpf());
            preparedStatement.setString(2, comprador.getPaisVenda());
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

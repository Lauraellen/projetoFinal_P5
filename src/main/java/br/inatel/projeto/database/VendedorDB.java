package br.inatel.projeto.database;

import br.inatel.projeto.Vendedor;

import java.sql.SQLException;

public class VendedorDB extends Database {

    public boolean insertVendedor(Vendedor vendedor) {
        connect();
        String sql1 = "INSERT INTO Funcionario (cpf, nome, telefone, setor, salario, gestor_cpf) VALUES (?, ? ,?, ?, ?, ?)";
        String sql2 = "INSERT INTO Vendedor (Funcionario_cpf, numVendas, metaMes, comissao) VALUES (?, ? ,?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, vendedor.getCpf());
            preparedStatement.setString(2, vendedor.getNome());
            preparedStatement.setString(3, vendedor.getTelefone());
            preparedStatement.setString(4, vendedor.getSetor());
            preparedStatement.setFloat(5, vendedor.getSalario());
            preparedStatement.setString(6, vendedor.getGestor_cpf());
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, vendedor.getCpf());
            preparedStatement.setInt(2, vendedor.getNumVendas());
            preparedStatement.setInt(3, vendedor.getMetaMes());
            preparedStatement.setFloat(4, vendedor.getComissao());
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

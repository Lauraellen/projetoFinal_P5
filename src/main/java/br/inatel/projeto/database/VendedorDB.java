package br.inatel.projeto.database;

import br.inatel.projeto.Vendedor;

import java.sql.SQLException;

public class VendedorDB extends Database {

    public boolean insertVendedor(Vendedor vendedor) {
        connect();
        String sql = "INSERT INTO Vendedor (cpf, nome, telefone, setor, salario, gestor_cpf, numVendas, metaMes, comissao) VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vendedor.getCpf());
            preparedStatement.setString(2, vendedor.getNome());
            preparedStatement.setString(3, vendedor.getTelefone());
            preparedStatement.setString(4, vendedor.getSetor());
            preparedStatement.setFloat(5, vendedor.getSalario());
            preparedStatement.setString(6, vendedor.getGestor_cpf());
            preparedStatement.setInt(7, vendedor.getNumVendas());
            preparedStatement.setInt(8, vendedor.getMetaMes());
            preparedStatement.setFloat(9, vendedor.getComissao());
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

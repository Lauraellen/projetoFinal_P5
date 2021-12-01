package br.inatel.projeto.database;

import br.inatel.projeto.Cliente;
import br.inatel.projeto.Comprador;

import java.sql.SQLException;

public class CompradorDB extends Database {

    public boolean insertComprador(Comprador comprador) {
        connect();
        String sql1 = "INSERT INTO Funcionario (cpf, nome, telefone, salario, gestor_cpf) VALUES (?,?, ?, ?, ?)";
        String sql2 = "INSERT INTO Comprador (Funcionario_cpf) VALUES (?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, comprador.getCpf());
            preparedStatement.setString(2, comprador.getNome());
            preparedStatement.setString(3, comprador.getTelefone());
            preparedStatement.setFloat(4, comprador.getSalario());
            preparedStatement.setString(5, comprador.getGestor_cpf());
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, comprador.getCpf());
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

    public boolean researchCompradorByCpf( String cpf) {

        connect();
        Comprador comprador  = new Comprador();
        boolean compradorExist = false;
        String sql = "SELECT * FROM comprador WHERE Funcionario_cpf = " + cpf;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            if(result != null && result.next()){
                comprador = new Comprador(result.getString("Funcionario_cpf"));
                compradorExist = true;
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
        return compradorExist;
    }

    public float research_salario(String cpf) {
        float aux = 0;
        connect();

        String sql = "SELECT salario FROM Funcionario WHERE cpf = " + cpf;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if (result != null && result.next()) {
                aux = result.getInt("salario");
            }

        }catch (SQLException e) {
            System.out.println("Erro ao finalizar " + e.getMessage());
        }
        return aux;
    }

}

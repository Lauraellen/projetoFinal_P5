package br.inatel.projeto.database;

import br.inatel.projeto.Comprador;
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

    public boolean researchVendedorByCpf( String cpf) {

        connect();
        Vendedor vendedor  = new Vendedor();
        boolean vendedorExist = false;
        String sql = "SELECT * FROM vendedor WHERE cpf = " + cpf;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            if(result != null && result.next()){
                vendedor = new Vendedor(result.getString("cpf"), result.getString("nome"), result.getString("telefone"),
                        result.getString("gestor_cpf"));
                vendedorExist = true;
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
        return vendedorExist;
    }

    public float research_salario(String cpf) {
        int aux1 = 0;
        float aux2 = 0;
        float aux3 = 0;
        connect();

        String sql1 = "SELECT numVendas FROM Vendedor WHERE Funcionario_cpf = " + cpf;
        String sql2 = "SELECT comissao FROM Vendedor WHERE Funcionario_cpf = " + cpf;
        String sql3 = "SELECT salario FROM Funcionario WHERE cpf = " + cpf;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql1);
            if (result != null && result.next()) {
                aux1 = result.getInt("numVendas");
            }

            result = statement.executeQuery(sql2);
            if (result != null && result.next()) {
                aux2 = result.getFloat("comissao");
            }

            result = statement.executeQuery(sql3);
            if (result != null && result.next()) {
                aux3 = result.getFloat("salario");
            }

        }catch (SQLException e) {
            System.out.println("Erro ao finalizar " + e.getMessage());
        }
        return ((aux1*aux2) + aux3);
    }

    public boolean updateVenda(String cpf){
        connect();
        String sql = "UPDATE Vendedor SET numVendas = numVendas + 1 WHERE Funcionario_cpf = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}

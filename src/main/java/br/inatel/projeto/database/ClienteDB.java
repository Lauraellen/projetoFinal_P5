package br.inatel.projeto.database;

import br.inatel.projeto.Cliente;
import br.inatel.projeto.Produto;
import br.inatel.projeto.Venda_has_Produto;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Cliente> researchCliente() {

        connect();
        ArrayList <Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Cliente clienteTemp = new Cliente(result.getString("cpf"), result.getString("nome"), result.getString("telefone"));
                System.out.println("Nome: " + clienteTemp.getNome());
                System.out.println("Cpf: " + clienteTemp.getCpf());
                System.out.println("Telefone: " + clienteTemp.getTelefone());
                System.out.println("------------");
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
        return clientes;
    }

    public boolean researchCliente( String cpf) {

        connect();
        Cliente cliente  = new Cliente();
        boolean clientExist = false;
        String sql = "call viewsVendas('" + cpf +  "')";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {

                System.out.println("Identificador da venda: " + result.getString("ID"));
                System.out.println("Vendedor: " + result.getString("Vendedor"));
                System.out.println("Total da venda: " + result.getString("Total"));
                System.out.println("-----------------------------------------");

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
        return clientExist;
    }

    public boolean searchCliente( String cpf) {

        connect();
        Cliente cliente  = new Cliente();
        boolean clientExist = false;
        String sql = "select * from cliente where cpf=" + cpf;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {


                System.out.println("Nome: " + result.getString("nome"));
                System.out.println("CPF: " + result.getString("cpf"));
                System.out.println("Telefone: " + result.getString("telefone"));
                System.out.println("-----------------------------------------");

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
        return clientExist;
    }

    public boolean researchClienteByCpf( String cpf) {

        connect();
        Cliente cliente  = new Cliente();
        boolean clientExist = false;
        String sql = "SELECT * FROM Cliente WHERE cpf = " + cpf;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                cliente = new Cliente(result.getString("cpf"), result.getString("nome"), result.getString("telefone"));
                clientExist = true;
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
        return clientExist;
    }



    public boolean updateCliente (String cpf, String telefone) {

        connect();
        String sql = "Update cliente set telefone=? WHERE cpf=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, telefone);
            preparedStatement.setString(2, cpf);
            preparedStatement.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação " + e.getMessage());
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

    public boolean deleteCliente (String cpf) {

        connect();
        String sql = "DELETE FROM cliente WHERE cpf=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            preparedStatement.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação " + e.getMessage());
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

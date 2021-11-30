package br.inatel.projeto.database;

import br.inatel.projeto.Arquivo;
import br.inatel.projeto.Cliente;
import br.inatel.projeto.Venda;
import br.inatel.projeto.Venda_has_Produto;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public float research_ValorVenda(int idVenda) {

        float aux = 0;
        connect();
        String sql = "SELECT valorVenda FROM Venda WHERE idVenda = " + idVenda;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            if(result != null && result.next()){
                aux = result.getFloat("valorVenda");
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
        return aux;
    }

    public int research_qtdProdutos(int idVenda) {

        int aux = 0;
        connect();
        String sql = "SELECT qtdProdutos FROM Venda WHERE idVenda = " + idVenda;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            if(result != null && result.next()){
                aux = result.getInt("qtdProdutos");
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
        return aux;
    }

    public ArrayList<Venda> research_vendaByCpf(String cpf_cliente) {

        connect();
        ArrayList<Venda> vendas = new ArrayList<>();

        String sql = "SELECT * FROM Venda WHERE Cliente_cpf = " + cpf_cliente;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Venda vendasCliente = new Venda(result.getInt("IdVenda"), result.getString("Cliente_cpf"), result.getString("Vendedor_Funcionario_cpf"),
                        result.getInt("qtdProdutos"), result.getFloat("valorVenda"));

                System.out.println("Identificador da compra: " + vendasCliente.getIdVenda());
                System.out.println("O vendedor foi: " + vendasCliente.getVendedor_Funcionario_cpf());
                System.out.println("O total de peças é de: " + vendasCliente.getQtdProdutos());
                System.out.println("Você realizou uma compra no total de: " + vendasCliente.getValorVenda());
                System.out.println("---------------------------");
                vendas.add(vendasCliente);
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
        return vendas;
    }
}
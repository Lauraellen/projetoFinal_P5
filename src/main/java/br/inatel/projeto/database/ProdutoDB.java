package br.inatel.projeto.database;
import br.inatel.projeto.Produto;
import br.inatel.projeto.Venda_has_Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDB extends Database {

    public boolean insertProduto(Produto produto) {
        connect();
        String sql = "INSERT INTO Produto (SN_produto, nomeProduto, valorCompra, valorVenda, Fornecedor_cnpj, estoque) VALUES (?, ?, ? ,?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, produto.getSN_produto());
            preparedStatement.setString(2, produto.getNomeProduto());
            preparedStatement.setFloat(3, produto.getValorCompra());
            preparedStatement.setFloat(4, produto.getValorVenda());
            preparedStatement.setString(5, produto.getForncedor_cnpj());
            preparedStatement.setInt(6, produto.getEstoque());

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

    public float research_ValorProduto(int SN_produto) {

        float aux = 0;
        connect();
        String sql = "SELECT valorVenda FROM Produto WHERE SN_produto = " + SN_produto;

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

    public boolean updateEstoqueVenda(int SN, int qtd){
        connect();
        String sql = "UPDATE Produto SET estoque = estoque - ? WHERE SN_Produto = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, qtd);
            preparedStatement.setInt(2, SN);
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

    public boolean updateEstoqueCompra(int SN, int qtd){
        connect();
        String sql = "UPDATE Produto SET estoque = estoque + ? WHERE SN_Produto = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, qtd);
            preparedStatement.setInt(2, SN);
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

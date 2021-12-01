package br.inatel.projeto.database;

import br.inatel.projeto.ContaBancaria;

import java.sql.SQLException;

public class ContaBancariaDB extends Database {

    //insere uma nova conta
    public boolean insertContaBancaria(ContaBancaria contaBancaria) {
        connect();
        String sql = "INSERT INTO ContaBancaria (numero, agencia, saldo, Funcionario_cpf) VALUES (?, ? ,?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contaBancaria.getNumero());
            preparedStatement.setInt(2, contaBancaria.getAgencia());
            preparedStatement.setFloat(3, contaBancaria.getSaldo());
            preparedStatement.setString(4, contaBancaria.getFuncionario_cpf());
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

    //atualiza o saldo da conta
    public boolean updateSalario(String cpf, float salario){
        connect();
        String sql = "UPDATE contaBancaria SET saldo = saldo + ? WHERE Funcionario_cpf=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, salario);
            preparedStatement.setString(2, cpf);
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

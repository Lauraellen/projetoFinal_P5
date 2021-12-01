package br.inatel.projeto.database;

import br.inatel.projeto.Comprador;
import br.inatel.projeto.Vendedor;

import java.sql.SQLException;

public class VendedorDB extends Database {

    //insere um novo vendedor
    public boolean insertVendedor(Vendedor vendedor) {
        connect();
        String sql1 = "INSERT INTO Funcionario (cpf, nome, telefone, salario, gestor_cpf) VALUES (?,?, ?, ?, ?)";
        String sql2 = "INSERT INTO Vendedor (Funcionario_cpf, numVendas, metaMes, comissao) VALUES (?, ? ,?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, vendedor.getCpf());
            preparedStatement.setString(2, vendedor.getNome());
            preparedStatement.setString(3, vendedor.getTelefone());
            preparedStatement.setFloat(4, vendedor.getSalario());
            preparedStatement.setString(5, vendedor.getGestor_cpf());
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

    //verifica se o vendedor está cadastrado
    public boolean researchVendedorByCpf( String cpf) {

        connect();
        Vendedor vendedor  = new Vendedor();
        boolean vendedorExist = false;
        String sql = "SELECT * FROM vendedor WHERE Funcionario_cpf = " + cpf;

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            if(result != null && result.next()){
                vendedor = new Vendedor(result.getString("Funcionario_cpf"));
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

    //busca o salario do vendedor
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

    //atualiza o numero de vendas
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

    //busca a meta do funcionario
    public void research_meta(String cpf) {

        int metaMes = 0;
        int numVendas = 0;

        connect();

        String sql = "SELECT metaMes FROM Vendedor WHERE Funcionario_cpf = " + cpf;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            if (result != null && result.next()) {
                metaMes = result.getInt("metaMes");
            }

            numVendas = research_numVendas(cpf);
            if(numVendas >= metaMes)
                updateMeta(cpf);

        }catch (SQLException e) {
            System.out.println("Erro ao finalizar " + e.getMessage());
        }
    }

    //busca o numero de vendas
    public int research_numVendas(String cpf) {

        connect();
        int aux = 0;

        String sql1 = "SELECT numVendas FROM Vendedor WHERE Funcionario_cpf = " + cpf;

        try {

            statement = connection.createStatement();
            result = statement.executeQuery(sql1);
            if (result != null && result.next()) {
                aux = result.getInt("numVendas");
            }

        }catch (SQLException e) {
            System.out.println("Erro ao finalizar " + e.getMessage());
        }
        return aux;
    }

    //atualiza a meta
    public boolean updateMeta(String cpf){
        connect();
        String sql = "UPDATE Vendedor SET metaMes = metaMes + 5 WHERE Funcionario_cpf = ?";
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

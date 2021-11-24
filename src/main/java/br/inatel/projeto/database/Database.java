package br.inatel.projeto.database;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Database {

    Connection connection;
    Statement statement;
    Resultset result;
    PreparedStatement preparedStatement;

    static final String user = "Dono";
    static  final String password = "1234";     //senha do usuário
    static final String database = "loja";              //nome do banco de dados

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    //static final String url = "jdbc:mysql://localhost:3306/" + database";
    public boolean check = false;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: " + connection) ;

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

}

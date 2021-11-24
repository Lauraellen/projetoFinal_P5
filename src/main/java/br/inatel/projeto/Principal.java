package br.inatel.projeto;

import br.inatel.projeto.database.Database;
import br.inatel.projeto.database.CompradorDB;
import br.inatel.projeto.database.ContaBancariaDB;
import br.inatel.projeto.database.VendedorDB;

public class Principal {

    public static void main(String[] args) {

        Database database = new Database();
        database.connect();
    }
}

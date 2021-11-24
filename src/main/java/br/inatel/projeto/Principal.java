package br.inatel.projeto;

import br.inatel.projeto.database.Database;

public class Principal {

    public static void main(String[] args) {
        Database db = new Database();
        db.connect();
    }
}

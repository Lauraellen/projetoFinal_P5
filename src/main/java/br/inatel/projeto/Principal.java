package br.inatel.projeto;

import br.inatel.projeto.database.CompradorDB;
import br.inatel.projeto.database.FornecedorDB;
import br.inatel.projeto.database.ProdutoDB;
import br.inatel.projeto.database.VendedorDB;

public class Principal {

    public static void main(String[] args) {

        VendedorDB vendedorDB = new VendedorDB();
        Vendedor vendedor1 = new Vendedor("123","Daiane", "35999533564", "MIDC", 2000, "123", 5,500);
        vendedorDB.insertVendedor(vendedor1);


    }
}

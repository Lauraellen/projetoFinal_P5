package br.inatel.projeto;

import br.inatel.projeto.Produto;

public class Venda {

    private static int contador = 1;
    private int idVenda;
    private String Cliente_cpf;
    private String Vendedor_Funcionario_cpf;
    private int qtdProdutos;
    private float valorVenda;

    public Venda(String Cliente_cpf, String Vendedor_Funcionario_cpf){
        idVenda = contador;
        contador++;
        this.Cliente_cpf = Cliente_cpf;
        this.Vendedor_Funcionario_cpf = Vendedor_Funcionario_cpf;
        qtdProdutos = 0;
        valorVenda = 0;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public String getCliente_cpf() {
        return Cliente_cpf;
    }

    public String getVendedor_Funcionario_cpf() {
        return Vendedor_Funcionario_cpf;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public float getValorVenda() {
        return valorVenda;
    }
}

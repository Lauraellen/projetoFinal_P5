package br.inatel.projeto;

public class Vendedor extends Funcionario{

    private int numVendas;
    private int metaMes;
    private float comissao;

    public Vendedor (String cpf, String nome, String telefone, String gestor_cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.gestor_cpf = gestor_cpf;
        salario = 2000;
        metaMes = 100;
        comissao = 100;
        numVendas = 0;
    }

    public Vendedor() {
    }

    public Vendedor (String cpf) {
        this.cpf = cpf;
    }


    public int getNumVendas() {
        return numVendas;
    }
    public int getMetaMes() {
        return metaMes;
    }
    public float getComissao() {
        return comissao;
    }
}

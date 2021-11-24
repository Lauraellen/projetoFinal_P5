package br.inatel.projeto;

public class Vendedor extends Funcionario{

    private int numVendas = 0;
    private int metaMes;
    private float comissao;

    public Vendedor (String cpf, String nome, String telefone, String setor, float salario, String gestor_cpf, int metaMes, float comissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
        this.gestor_cpf = gestor_cpf;
        this.metaMes = metaMes;
        this.comissao = comissao;
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

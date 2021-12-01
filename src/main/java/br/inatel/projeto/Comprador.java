package br.inatel.projeto;

public class Comprador extends Funcionario{

    private String paisVenda;

    public Comprador (String cpf, String nome, String telefone, String gestor_cpf, String paisVenda){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.gestor_cpf = gestor_cpf;
        this.paisVenda = paisVenda;
        setor = "Compras";
        salario = 2500;
    }

    public Comprador() {
    }

    public String getPaisVenda() {
        return paisVenda;
    }
}

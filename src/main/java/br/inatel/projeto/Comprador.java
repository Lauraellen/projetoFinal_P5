package br.inatel.projeto;

public class Comprador extends Funcionario{

    private String paisVenda;

    public Comprador (String cpf, String nome, String telefone, String setor, float salario, String gestor_cpf, String paisVenda){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
        this.gestor_cpf = gestor_cpf;
        this.paisVenda = paisVenda;
    }

    public String getPaisVenda() {
        return paisVenda;
    }
}

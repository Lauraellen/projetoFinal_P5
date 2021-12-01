package br.inatel.projeto;

public class Comprador extends Funcionario{


    public Comprador (String cpf, String nome, String telefone, String gestor_cpf){
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.gestor_cpf = gestor_cpf;
        salario = 2500;
    }

    public Comprador() {
    }

    public Comprador (String cpf){
        this.cpf = cpf;
    }


}

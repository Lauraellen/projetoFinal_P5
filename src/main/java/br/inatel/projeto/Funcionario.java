package br.inatel.projeto;

public abstract class Funcionario {

    protected String cpf;
    protected String nome;
    protected String telefone;
    protected float salario;
    protected String gestor_cpf;

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public float getSalario() {
        return salario;
    }
    public String getGestor_cpf() {
        return gestor_cpf;
    }
}

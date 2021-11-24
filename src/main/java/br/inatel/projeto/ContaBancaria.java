package br.inatel.projeto;

public class ContaBancaria{

    private int numero;
    private int agencia;
    private float saldo;
    private String Funcionario_cpf;

    public ContaBancaria(int numero, int agencia, String Funcionario_cpf){
        this.numero = numero;
        this.agencia = agencia;
        this.Funcionario_cpf = Funcionario_cpf;
        saldo = 0;
    }

    public int getNumero() {
        return numero;
    }
    public int getAgencia() {
        return agencia;
    }
    public float getSaldo() {
        return saldo;
    }
    public String getFuncionario_cpf() {
        return Funcionario_cpf;
    }
}

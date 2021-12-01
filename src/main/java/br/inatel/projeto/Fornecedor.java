package br.inatel.projeto;

public class Fornecedor {
    private String cnpj;
    private String nome;
    private String telefone;
    private String compradorCpf;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String nome, String telefone, String compradorCpf) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.compradorCpf = compradorCpf;
    }

    public String getCpf() {
        return cnpj;
    }

    public void setCpf(String cpf) {
        this.cnpj = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCompradorCpf() {
        return compradorCpf;
    }

    public void setCompradorCpf(String compradorCpf) {
        this.compradorCpf = compradorCpf;
    }
}

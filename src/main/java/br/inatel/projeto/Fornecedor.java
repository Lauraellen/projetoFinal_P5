package br.inatel.projeto;

public class Fornecedor {
    private String cnpj;
    private String nome;
    private String telefone;
    private String pais;

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

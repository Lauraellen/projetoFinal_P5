package br.inatel.projeto;

public class Produto {

    private int SN_produto;
    private String nomeProduto;
    private float valorCompra;
    private float valorVenda;
    private String Fornecedor_cnpj;
    private int estoque;

    public Produto() {
    }

    public Produto(int SN_produto, String nomeProduto, float valorCompra, float valorVenda, String forncedor_cnpj) {
        this.SN_produto = SN_produto;
        this.nomeProduto = nomeProduto;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.Fornecedor_cnpj = forncedor_cnpj;
        estoque = 0;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getSN_produto() {
        return SN_produto;
    }

    public void setSN_produto(int SN_produto) {
        this.SN_produto = SN_produto;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valor_compra) {
        this.valorCompra = valor_compra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valor_venda) {
        this.valorVenda = valor_venda;
    }

    public String getForncedor_cnpj() {
        return Fornecedor_cnpj;
    }

    public void setForncedor_cnpj(String forncedor_cnpj) {
        Fornecedor_cnpj = forncedor_cnpj;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

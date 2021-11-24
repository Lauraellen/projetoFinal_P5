package br.inatel.projeto;

public class Produto {

    private int SN_produto;
    private float valor_compra;
    private float valor_venda;
    private Fornecedor fornecedor;

    public int getSN_produto() {
        return SN_produto;
    }

    public void setSN_produto(int SN_produto) {
        this.SN_produto = SN_produto;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}

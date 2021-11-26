package br.inatel.projeto;

public class Venda_has_Produto {

    private int Venda_idVenda;
    private int Produto_SNProduto;
    private int qtdProdutos;

    public Venda_has_Produto(int Venda_idVenda, int Produto_SNProduto, int qtdProdutos){
        this.Venda_idVenda = Venda_idVenda;
        this.Produto_SNProduto = Produto_SNProduto;
        this.qtdProdutos = qtdProdutos;
    }

    public Venda_has_Produto() {
    }

    public int getVenda_idVenda() {
        return Venda_idVenda;
    }

    public int getProduto_SNProduto() {
        return Produto_SNProduto;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }
}

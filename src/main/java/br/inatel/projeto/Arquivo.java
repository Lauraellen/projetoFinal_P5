package br.inatel.projeto;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Arquivo {

    public void escrever(Venda v1) {

        OutputStream os = null;
        OutputStreamWriter osr = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        try {
            os = new FileOutputStream("Nota fiscal.txt", true); //salvar no arquivo
            osr = new OutputStreamWriter(os); //conversor
            bw = new BufferedWriter(osr); //o q vai digitar

            //escrever
            bw.write("Venda " + v1.getIdVenda());
            bw.newLine();
            bw.write("CPF do cliente: " + v1.getCliente_cpf() + "\n");
            bw.write("CPF do vendedor: " + v1.getVendedor_Funcionario_cpf() + "\n");
            bw.write("Valor total da venda: " + v1.getValorVenda() + "\n");
            bw.write("Quantidade de produtos: " + v1.getQtdProdutos() + "\n");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

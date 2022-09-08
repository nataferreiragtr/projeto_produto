package projetoATIVIDADE.app;

import projetoATIVIDADE.service.ProdutoService;

import javax.swing.*;

public class AppFindByName {
    public static void main(String[] args) {
        var service = new ProdutoService();

        var respostaList = service.findByName("Café").stream().map(produto -> "Produto.nome: " + produto.getNome() + "\n" + "Produto.marca: " + produto.getMarca() + "\n" + "Produto.codigo: " + produto.getCodigo() + "\n" + "Produto.tipo: " + produto.getTipo() + "\n\n").toList();
        JOptionPane.showMessageDialog(null, respostaList, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
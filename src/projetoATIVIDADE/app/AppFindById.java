package projetoATIVIDADE.app;

import projetoATIVIDADE.service.ProdutoService;

import javax.swing.*;

public class AppFindById {
    public static void main(String[] args) {
        var service = new ProdutoService();

        var pro = service.findById(1L);

        var msg = "Projeto.nome: " + pro.getNome() + "\n" + "Projeto.marca: " + pro.getMarca() + "\n" + "Projeto.codigo: " + pro.getCodigo() + "\n" + "Projeto.tipo: " + pro.getTipo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
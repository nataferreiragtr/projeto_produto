package projetoATIVIDADE.app;

import projetoATIVIDADE.model.Produto;
import projetoATIVIDADE.service.ProdutoService;

import javax.swing.*;

public class AppSave {
    public static void main(String[] args) {
        var service = new ProdutoService();
        Produto pro;
        pro = new Produto();
        var nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        pro.setNome(nome);

        var marca = JOptionPane.showInputDialog(null, "Informe a marca: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        pro.setMarca(marca);

        var codigo = JOptionPane.showInputDialog(null, "Informe o codigo do produto: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        pro.setCodigo(Integer.parseInt(codigo));

        var tipo = JOptionPane.showInputDialog(null, "Informe o tipo(comida/bebida):  ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        pro.setTipo(tipo);

        var situacao = "Ocorreu uma falha na gravação. Verifique o log";
        var iconeStatus = JOptionPane.ERROR_MESSAGE;

        var response = service.save(pro);
        if(response) {
            situacao = "Gravado";
            iconeStatus = JOptionPane.INFORMATION_MESSAGE;
        }

        var msg = "Situação da gravação no banco: " + situacao + "\n\n" + "Produto.nome: " + pro.getNome() + "\n" + "Produto.marca: " + pro.getMarca() + "\n" + "Produto.codigo: " + pro.getCodigo() + "\n" + "Produto.tipo: " + pro.getTipo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", iconeStatus);
    }
}
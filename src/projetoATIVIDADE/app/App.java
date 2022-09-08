package projetoATIVIDADE.app
        ;
import projetoATIVIDADE.model.Produto;
import projetoATIVIDADE.model.Produto;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Produto pro;
        pro = new Produto();

        var nome  = JOptionPane.showInputDialog(null, "Informe o nome do produto: ", "Input nome", JOptionPane.QUESTION_MESSAGE);
        pro.setNome(nome);

        var marca  = JOptionPane.showInputDialog(null, "Informe a marca do produto: ", "Input nome", JOptionPane.QUESTION_MESSAGE);
        pro.setMarca(marca);

        var codigo  = JOptionPane.showInputDialog(null, "Informe o codigo do produto: ", "Input nome", JOptionPane.QUESTION_MESSAGE);
        pro.setCodigo(Integer.parseInt(codigo));

        var tipo  = JOptionPane.showInputDialog(null, "Informe o tipo do produto: ", "Input nome", JOptionPane.QUESTION_MESSAGE);
        pro.setTipo(tipo);

        var msg = pro.getNome() + "\n" + pro.getMarca() + "\n" + pro.getCodigo() + "\n" + pro.getTipo();
        JOptionPane.showInputDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}

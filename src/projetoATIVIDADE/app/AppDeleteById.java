package projetoATIVIDADE.app;
import projetoATIVIDADE.model.Produto;
import projetoATIVIDADE.service.ProdutoService;
import javax.swing.*;

public class AppDeleteById {
    public static void main(String[] args) {
        var service = new ProdutoService();

        var status = service.deleteById(1L);

        var msg = "Status da exclusão: " + (status ? "Exito" : "Erro");
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}
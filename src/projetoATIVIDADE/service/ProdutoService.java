package projetoATIVIDADE.service;

import projetoATIVIDADE.model.Produto;
import projetoATIVIDADE.persist.ProdutoDAO;

import java.util.List;

public class ProdutoService {
    private ProdutoDAO dao;

    public ProdutoService() {
        dao = new ProdutoDAO();
    }

    public boolean save(Produto produto) {
        return dao.save(produto);
    }

    public List<Produto> findAll() {
        return dao.findAll();
    }

    public Produto findById(long id) {
        return dao.findById(id);
    }

    public List<Produto> findByName(String nome) {
        return dao.findByName(nome);
    }

    public Produto findByCodigo(int codigo) {
        return dao.findByCodigo(codigo);
    }

    public Produto findByMarca(String marca) {
        return dao.findByMarca(marca);
    }

    public boolean deleteById(long id) {
        return dao.deleteById(id);
    }
}
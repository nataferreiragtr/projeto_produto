package projetoATIVIDADE.model;

public class Produto {
    private String nome;
    private String marca;
    private int codigo;
    private String tipo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo () {
        return codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }






    public void conferirProduto() {
        System.out.println("O produto está disponivel !!");
    }

    public String efetuarPergunta() {
        return "O gerente perguntou se o produto está disponivel";
    }

    public Produto retornaProduto() {
        return this;
    }
}
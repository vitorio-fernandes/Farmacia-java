public abstract class Produto {

    private String descricao;
    private double preco;
    private int estoque;
    private String validade;
    protected Fornecedor fornecedor;

    Produto(String descricao, double preco, int estoque, String validade, Fornecedor fornecedor) {
        this.descricao = descricao;
        this.estoque = estoque;
        this.preco = preco;
        this.validade = validade;
        this.fornecedor = fornecedor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public String getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return "Descrição: " + getDescricao() + "\nPreço: " + getPreco() + "\nEstoque: " + getEstoque() +
                "\nValidade: " + getValidade() + "\nFornecedor: " + fornecedor.getNomeFornecedor() + "\n";
    }
}
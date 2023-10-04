import java.util.ArrayList;

public interface InterfaceProdutos  {
    public void adiconarProdutos(Produto produto);
    public void listarProdutos();
    public void removerProduto(int indice);
    public void venderProduto(int indice, int quantidade);
    public ArrayList<Produto> getProdutos();
    
}

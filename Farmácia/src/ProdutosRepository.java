
import java.util.ArrayList;


public class ProdutosRepository implements InterfaceProdutos {
    ArrayList<Produto> produtos = new ArrayList<>();


    public void adiconarProdutos(Produto produto){
        produtos.add(produto);
    }

    public void listarProdutos(){
        for (int i = 0 ; i < produtos.size();i++){
            System.out.println(i+1+")");
            System.out.println(produtos.get(i));
        }
    }

    public void removerProduto(int indice){
        produtos.remove(indice-1);
    }

    public void venderProduto(int indice, int quantidade){
        Produto produto = produtos.get(indice);
        int estoqueAtual = produto.getEstoque();

        if (quantidade > 0 && quantidade <= estoqueAtual) {
            produto.setEstoque(estoqueAtual - quantidade);
        }

    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
}

import java.util.ArrayList;

public class ClientesRepository implements InterfaceClientes {
    
    ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionarClientes(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(int indice){
        clientes.remove(indice);
    }

    public void listarClientes(){
        for (int i = 0; i < clientes.size(); i++){
            System.out.println(i+1+")");
            System.out.println(clientes.get(i));
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
}

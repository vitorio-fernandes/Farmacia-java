
import java.util.ArrayList;

public interface InterfaceClientes {
    public void adicionarClientes(Cliente cliente);

    public void removerCliente(int indice);

    public void listarClientes();

    public ArrayList<Cliente> getClientes();
}

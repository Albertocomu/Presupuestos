package presupuestos;

import java.io.Serializable;
import java.util.*;

public class ClienteList implements Serializable {

    private Map <Integer, Cliente> ClienteMapTelefono = new HashMap<>();


    public ClienteList() {
        ClienteMapTelefono = new HashMap<>();
    }

    public Map<Integer, Cliente> getLista() {return ClienteMapTelefono;}

    public void setLista(Map<Integer, Cliente> lista) {this.ClienteMapTelefono = lista;}

    public void alta(Cliente cliente) {
        if (!ClienteMapTelefono.containsKey(cliente.getTelefono())) {
            ClienteMapTelefono.put(cliente.getTelefono(), cliente);
        }else{
            System.out.println("El telefono ya está registrado.");
        }
    }

    public Cliente obtenerClientePorTelefono(int telefono){
        return ClienteMapTelefono.get(telefono);
    }

    public int cantidadPresupuestos(){
        return ClienteMapTelefono.size();
    }

    public boolean existe (int telefono){
        boolean existe = false;
        if (ClienteMapTelefono.containsKey(telefono)) {
            existe = true;
        }
        return existe;
    }

}

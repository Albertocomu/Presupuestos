package presupuestos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteList implements Serializable {

    private Map <Integer, Cliente> ClienteMapTelefono = new HashMap<>();

    public void alta(Cliente cliente) {
        if (!ClienteMapTelefono.containsKey(cliente.getTelefono())) {
            ClienteMapTelefono.put(cliente.getTelefono(), cliente);
        }
    }
}

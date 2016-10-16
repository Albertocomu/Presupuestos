package presupuestos;
import java.io.Serializable;
import java.util.ArrayList;

public class PresupuestoList implements Serializable{

    private ArrayList<Cliente> lista;

    public PresupuestoList() {
        lista = new ArrayList<>();
    }

    public ArrayList<Cliente> getLista() {return lista;}

    public void setLista(ArrayList<Cliente> lista) {this.lista = lista;}

}

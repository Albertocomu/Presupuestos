package presupuestos;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PresupuestoList implements Serializable {

    private Map<Integer, Presupuesto> PresupuestoMapTelefono;

    public PresupuestoList() {
        PresupuestoMapTelefono = new HashMap<>();
    }

    public void añadirPresupuesto(Presupuesto presupuesto) {
        PresupuestoMapTelefono.put(presupuesto.getNumPresupuesto(), presupuesto);
    }

    public Presupuesto getPresupuesto(Integer id){
        return PresupuestoMapTelefono.get(id);
    }

    public Collection<Presupuesto> obtenerPresupuestos(){
        return PresupuestoMapTelefono.values();
    }

    public List<Presupuesto> obtenerPresupuestosEstado(String estado){
            return obtenerPresupuestos()
                    .stream()
                    .filter(presupuesto -> presupuesto.getEstado().equalsIgnoreCase(estado))
                    .collect(Collectors.toList());
        }

    public Map<Integer, Presupuesto> getPresupuestoMapTelefono() {
        return PresupuestoMapTelefono;
    }

    public void setPresupuestoMapTelefono(Map<Integer, Presupuesto> presupuestoMapTelefono) {
        PresupuestoMapTelefono = presupuestoMapTelefono;
    }

    @Override
    public String toString() {
        return "PresupuestoList{" +
                "PresupuestoMapTelefono=" + PresupuestoMapTelefono +
                '}';
    }
}

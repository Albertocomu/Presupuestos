package presupuestos;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable{
    private String nombre;
    private String apellidos;
    private int telefono;
    private boolean vip;
    private PresupuestoList presupuestos;

    public Cliente() {}

    public Cliente(String nombre, String apellidos, int telefono, boolean vip) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.vip = vip;
        this.presupuestos = new PresupuestoList();
    }

    public String getNombre() {return nombre;}
    public String getApellidos() {return apellidos;}
    public int getTelefono() {return telefono;}
    public boolean isVip() {return vip;}

    public PresupuestoList getPresupuestos() {
        return presupuestos;
    }

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public void setVip(boolean vip) {this.vip = vip;}

    public void setPresupuestos(PresupuestoList presupuestos) {
        this.presupuestos = presupuestos;
    }

    public int cantidadPresupuestos(){
        return getPresupuestos().getPresupuestoMapTelefono().size();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                ", vip=" + vip +
                ", presupuestos=" + presupuestos +
                '}';
    }
}

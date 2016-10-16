package presupuestos;

import java.io.Serializable;

public class Presupuesto implements Serializable {
    int numPresupuesto;
    String concepto;
    double precioNeto;
    int estado;

    public Presupuesto(int numPresupuesto, String concepto, double precioNeto, int estado) {
        this.numPresupuesto = numPresupuesto;
        this.concepto = concepto;
        this.precioNeto = precioNeto;
        this.estado = estado;
    }

    public int getNumPresupuesto() {return numPresupuesto;}
    public String getConcepto() {return concepto;}
    public double getPrecioNeto() {return precioNeto;}
    public int getEstado() {return estado;}

    public void setNumPresupuesto(int numPresupuesto){this.numPresupuesto = numPresupuesto;}
    public void setConcepto(String concepto) {this.concepto = concepto;}
    public void setPrecioNeto(double precioNeto) {this.precioNeto = precioNeto;}
    public void setEstado(int estado) {this.estado = estado;}
}

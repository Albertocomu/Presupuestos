package presupuestos;

import java.io.Serializable;

public class Presupuesto implements Serializable {
    private int numPresupuesto;
    private String concepto;
    private double precioNeto;
    private String estado;

    public Presupuesto() {}

    public Presupuesto(int numPresupuesto, String concepto, double precioNeto, String estado) {
        this.numPresupuesto = numPresupuesto;
        this.concepto = concepto;
        this.precioNeto = precioNeto;
        this.estado = estado;
    }

    public int getNumPresupuesto() {return numPresupuesto;}
    public String getConcepto() {return concepto;}
    public double getPrecioNeto() {return precioNeto;}
    public String getEstado() {return estado;}

    public void setNumPresupuesto(int numPresupuesto){this.numPresupuesto = numPresupuesto;}
    public void setConcepto(String concepto) {this.concepto = concepto;}
    public void setPrecioNeto(double precioNeto) {this.precioNeto = precioNeto;}
    public void setEstado(String estado) {this.estado = estado;}

    @Override
    public String toString() {
        return "Presupuesto {" +
                "numPresupuesto=" + numPresupuesto +
                ", concepto='" + concepto + '\'' +
                ", precioNeto=" + precioNeto +
                ", estado='" + estado + '\'' +
                '}';
    }
}

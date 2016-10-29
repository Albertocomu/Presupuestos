package presupuestos;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import utilidades.EntradaDatos;
import utilidades.Fichero;

import java.util.stream.Collectors;

import static utilidades.EntradaDatos.pedirEntero;

public class Main {

    private static ClienteList misClientes;
    private static Fichero miFichero;


    public static void main(String[] args) {
        miFichero = new Fichero("clientes.xml");
        misClientes = (ClienteList) miFichero.leer();

        if (misClientes == null) {
            misClientes = new ClienteList();
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    nuevoPresupuesto();
                    break;
                case 3:
                    mostrarPendientes();
                    break;
                case 4:
                    mostrarPorClienteTelefono();
                    break;
                case 5:
                    mostrarRechazados();
                    break;
                case 6:
                    mostrarClientesPresupuestos();
                    break;
                case 7:
                    cambiarEstadoPresupuesto();
                    break;
                case 8:
                    System.out.println("Hasta la proxima.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 8);
    }

    private static void altaCliente() {
        String nombre;
        nombre = pedirCadenaNoVacia("Nombre: ");
        String apellidos;
        do {
            apellidos = EntradaDatos.pedirCadena("Apellidos");
            if (nombre.equals("")) {
                System.out.println("No se pueden dejar los apellidos en blanco.");
            }
        } while (apellidos.equals(""));
        int telefono;
        do {
            telefono = EntradaDatos.pedirEntero("Telefono");
            if (telefono < 89999999 || telefono > 999999999) {
                System.out.println("Debe ser de 9 dígitos.");
            }
        } while (telefono < 89999999 || telefono > 999999999);
        String vip;
        boolean esVip = false;
        do {
            vip = EntradaDatos.pedirCadena("¿Eres VIP (SI/NO)?");
            if (vip.equalsIgnoreCase("si")) {
                esVip = true;
            } else if (vip.equalsIgnoreCase("no")) {
                esVip = false;
            } else {
                System.out.println("Respuesta incorrecta. Escribe si o no.");
            }
        } while (!vip.equalsIgnoreCase("SI") && !vip.equalsIgnoreCase("no"));
        Cliente c = new Cliente(nombre, apellidos, telefono, esVip);
        misClientes.alta(c);
        miFichero.grabar(misClientes);
    }

    private static void nuevoPresupuesto() {
        int telefono;
        do {
            telefono = EntradaDatos.pedirEntero("Introduzca telefono:");
            if (telefono < 89999999 || telefono > 999999999) {
                System.out.println("Debe ser de 9 dígitos.");
            }
        } while (telefono < 89999999 || telefono > 999999999);
        if (!misClientes.existe(telefono)) {
            System.out.println("El telefono no esta registrado, registrate por favor:");
            altaCliente();
        }
        int num = EntradaDatos.pedirEntero("Numero de presupuesto:");
        String concepto = EntradaDatos.pedirCadena("Concepto:");
        Double precio = EntradaDatos.pedirDouble("Precio:");
        String estado = EntradaDatos.pedirCadena("Estado (aceptado-rechazado-pendiente):");

        Presupuesto p = new Presupuesto(num, concepto, precio, estado);
        misClientes.obtenerClientePorTelefono(telefono).getPresupuestos().añadirPresupuesto(p);
        miFichero.grabar(misClientes);
    }

    private static void mostrarPendientes() {
        for (Cliente c : misClientes.getLista().values()) {
            System.out.println(c.getPresupuestos().obtenerPresupuestosEstado("pendiente"));
        }
    }

    private static void mostrarRechazados() {
        for (Cliente c : misClientes.getLista().values()) {
            System.out.println(c.getPresupuestos().obtenerPresupuestosEstado("rechazado"));
        }
    }

    private static void mostrarTodos() {
        for (Cliente c : misClientes.getLista().values()) {
            System.out.println(c.getPresupuestos());
        }
    }

    private static void mostrarPorClienteTelefono() {
        int telefono = EntradaDatos.pedirEntero("Introduzca telefono:");
        if (telefono < 89999999 || telefono > 999999999) {
            System.out.println("Debe ser de 9 dígitos.");
        }
        while (telefono < 89999999 || telefono > 999999999) ;
        System.out.println(misClientes.obtenerClientePorTelefono(telefono).getPresupuestos());
    }

    private static void mostrarClientesPresupuestos() {
        for (Cliente c : misClientes.getLista().values()) {
            System.out.println(c.getNombre() + " " + c.getApellidos() + ". Presupuestos: " + c.cantidadPresupuestos());
        }
    }

    private static void cambiarEstadoPresupuesto() {

        int idPresupuesto = EntradaDatos.pedirEntero("Introducir id presupuesto: ");
        String nuevoEstado = EntradaDatos.pedirCadena("Nuevo estado:");
        misClientes.getLista().values().forEach(
                cliente -> {
                    Presupuesto presupuesto = cliente.getPresupuestos().getPresupuesto(idPresupuesto);
                    if (presupuesto != null) {
                        presupuesto.setEstado(nuevoEstado);
                    }
                });
        miFichero.grabar(misClientes);
    }

    private static String pedirCadenaNoVacia(String msg) {
        String nombre;
        do {
            nombre = EntradaDatos.pedirCadena(msg);
            if (nombre.equals("")) {
                System.out.println("no se puede dejar el nombre en blanco.");
            }
        } while (nombre.equals(""));
        return nombre;
    }

    private static void mostrarMenu() {
        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes (de aceptar o rechazar)");
        System.out.println("4. Listado de presupuestos de un cliente determinado");
        System.out.println("5. Listado de presupuestos rechazados.");
        System.out.println("6. Listado de clientes");
        System.out.println("7. Cambiar estado de un presupuesto");
        System.out.println("8. Salir");
    }
}

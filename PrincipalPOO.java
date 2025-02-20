package cordi;

import java.io.IOException;
import java.util.ArrayList;

public class PrincipalPOO {
	
	static Lista<Cproducto> productos;

	static String ventas[][]; 
	static int tamventas = 100; 
	static String fecha; 

	public static Lista<Cproducto> CargarProductos() {
	    Lista<Cproducto> producto = new Lista();
              System.out.println("id \t"+"producto\t"+"precio\t"+"stock");
	    producto.insertar(new Cproducto("001", "Arroz 1kg", "35","10" ));
	    producto.insertar(new Cproducto("002", "Azúcar 1kg", "25","10" ));
	    producto.insertar(new Cproducto("003", "Harina 1kg", "28","10" ));
	    producto.insertar(new Cproducto("005", "Leche 1L", "35","10" ));
	    producto.insertar(new Cproducto("006", "Huevos 12 unidades", "45","10" ));
	    producto.insertar(new Cproducto("007", "Fideos 500g", "20" ,"10"));
	    producto.insertar(new Cproducto("008", "Sal 1kg", "15","10" ));
	    producto.insertar(new Cproducto("009", "Pasta de tomate 400g", "25","10" ));
	    producto.insertar(new Cproducto("010", "Atún lata 170g", "35","10" ));
	    
	    return producto;
	} 

	public static void ModificarProducto(Lista<Cproducto> vproductos) throws IOException {
	    String codigo, precio;
	    int posicion;
	    String info = vproductos.MostrarLista();
	    codigo = Libreria.Leer(info + "\nIntroduce el codigo del producto a modificar");
	    if (codigo != null) {
	        Cproducto producto= new Cproducto(codigo,"","",""); 
	        if (vproductos.existe(producto)) {
	            producto = vproductos.obtener(producto);
	            precio = Libreria.Leer("\nIntroduce el precio de " + producto.toString() + " ");
	            if (precio != null) {
	                if (Libreria.EvaluarNumerico(precio, 2) || Libreria.EvaluarNumerico(precio, 1)) {
	                    producto.setPrecio(precio);
	                    vproductos.modificar(vproductos.posicion(producto), producto);
	                } else {
	                    System.out.println("no es un valor numerico");  
	                }
	            } else {
	                System.out.println(" dato nulo"); 
	            }
	        } else {
	            System.out.println("no existe el codigo"); 
	        }
	    } else {
	        System.out.println(" dato nulo");
	    }
	}

	public static void MenuProductos(Lista<Cproducto> vproductos) throws IOException {
	    ArrayList<String> datosmenuproductos = new ArrayList();

	    datosmenuproductos.add("1.-Modificar ");
	    datosmenuproductos.add("2.-Listado ");
	    datosmenuproductos.add("3.-Salida " ); 

	    String opcion = "0"; 
	    do {
	        opcion = Libreria.DesplegarMenu("Opciones de Productos", datosmenuproductos); 
	        if (opcion == null) {
	            System.out.println("opcion incorrecta ");
	        } else {
	            switch (opcion) { 
	                case "1": ModificarProducto(vproductos); break; 
	                case "2": System.out.println(vproductos.MostrarLista()); break; 
	                case "3": 
	                    System.out.println("Salida del Sistema "); break; 
	                default: System.out.println("No existe esta opcion "); break; 
	            }
	        }
	    } while (opcion.compareTo("3") != 0); 
	}

	public static void MenuPrincipal(Lista<Cproducto> vproductos) throws IOException {
	    ArrayList<String> datosmenuprincipal = new ArrayList();
	    datosmenuprincipal.add("1.-Productos ");
	    datosmenuprincipal.add("2.-Punto de Venta ");
	    datosmenuprincipal.add("3.- Inventario");
	    datosmenuprincipal.add("4.-Ventas");
	    datosmenuprincipal.add("5.-Salida "); 
	    String opcion = "0"; 
	    String idticket;
	    do {
	        opcion = Libreria.DesplegarMenu("Menu de Punto de Tienda de Abarrotes la Pequeñita", datosmenuprincipal); 
	        if (opcion == null) {
	            System.out.println("opcion incorrecta ");
	        } else {
	            switch (opcion) { 
	                case "1": MenuProductos(vproductos); break; 
	                case "2": System.out.println("PUNTO DE VENTAS "); break; 
	                case "3": System.out.println("IVENTARIOS"); break;
	                case "4": System.out.println("VENTAS"); break;
	                case "5": 
	                    System.out.println("Salida del Sistema "); break; 
	                default: System.out.println("No existe esta opcion "); break; 
	            }
	        }
	    } while (opcion.compareTo("5") != 0); 
	}

	public static void main(String[] args) throws IOException {
	    try {
	        productos = CargarProductos();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    MenuPrincipal(productos);
	}

}

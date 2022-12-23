
package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;


public class TestServicioSumarWS {
    
    public static void main(String[] args) {
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        
        System.out.println("Ejecutando servicio sumar WS");
        int a = 7, b = 2;
        int resultado = servicioSumar.sumar(a, b);
        System.out.println("resultado = " + resultado);
        System.out.println("Fin de servicio sumar WS");
    }

}

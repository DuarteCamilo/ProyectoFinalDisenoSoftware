/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicios;

import Modelos.Transaccion;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ServiceTransaccionesTest {
    
    public ServiceTransaccionesTest() {
    }

    

    /**
     * Test of buscar method, of class ServiceTransacciones.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object insertion = 1;
        LocalDate fecha = LocalDate.of(2023, Month.OCTOBER, 26);
        LocalTime hora = LocalTime.of(23, 3);
        Transaccion expResult = new Transaccion(1, "Inicio Sesión", fecha, hora, "El usuario incio sesion", 12345);
        Transaccion result = ServiceTransacciones.getINSTANCE().buscar(insertion);
        assertEquals(expResult.getId(), result.getId());
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicios;

import Modelos.PrestamoLibro;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ServiceGestionPrestamosTest {
    
    public ServiceGestionPrestamosTest() {
    }

    /**
     * Test of buscar method, of class ServiceGestionPrestamos.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object insertion = 1;
        ServiceGestionPrestamos instance = ServiceGestionPrestamos.getINSTANCE();
        PrestamoLibro expResult = new PrestamoLibro(1, 123, "789", LocalDate.EPOCH, LocalDate.MIN, LocalDate.EPOCH);
        PrestamoLibro result = instance.buscar(insertion);
        assertEquals(expResult.getId_prestamo(), result.getId_prestamo());
    }
    
}

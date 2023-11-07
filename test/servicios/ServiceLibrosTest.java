/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicios;

import Modelos.Libro;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ServiceLibrosTest {
    
    public ServiceLibrosTest() {
    }


    /**
     * Test of buscar method, of class ServiceLibros.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object insertion = "123";
        ServiceLibros instance = ServiceLibros.getINSTANCE();
        Libro expResult = new Libro(1, "123", "hola", "juan", 1, 1999, 196);
        Libro result = instance.buscar(insertion);
        assertEquals(expResult.getCodigo_libro(), result.getCodigo_libro());
    }
    
}

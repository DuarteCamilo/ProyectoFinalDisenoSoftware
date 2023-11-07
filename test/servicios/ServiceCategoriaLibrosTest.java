/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicios;

import Modelos.Categoria;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ServiceCategoriaLibrosTest {
    
    public ServiceCategoriaLibrosTest() {
    }

    /**
     * Test of buscar method, of class ServiceCategoriaLibros.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object insertion = 1;
        ServiceCategoriaLibros instance = ServiceCategoriaLibros.getINSTANCE();
        Categoria expResult = new Categoria(1, "hola");
        Categoria result = instance.buscar(insertion);
        assertEquals(expResult.getNombre_categoria(), result.getNombre_categoria());
    }
    
}

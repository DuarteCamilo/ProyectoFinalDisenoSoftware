/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package servicios;

import Modelos.Usuario;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ServiceUsuarioTest {
    
    public ServiceUsuarioTest() {
    }

    /**
     * Test of buscar method, of class ServiceUsuario.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Object insertion = 123;
        ServiceUsuario instance = ServiceUsuario.getINSTANCE();
        Usuario expResult = new Usuario(0,123, "camilo", "Duarte", "95566", "1", "1");
        Usuario result = instance.buscar(insertion);
        assertEquals(expResult.getCedula(), result.getCedula());

    }
    
}

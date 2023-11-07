/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controladores;

import Modelos.Transaccion;
import Modelos.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaUsuarioTest {
    
    public ControladorVentanaUsuarioTest() {
    }

    
    /**
     * Test of buscar method, of class ControladorVentanaUsuario.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int cedula = 123;
        ControladorVentanaUsuario instance = new ControladorVentanaUsuario();
        Usuario expResult = new Usuario(0,123, "camilo", "Duarte", "95566", "1", "1");
        Usuario result = instance.buscar(cedula);
        assertEquals(expResult.getCedula(), result.getCedula());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controladores;

import Modelos.Transaccion;
import Modelos.Usuario;
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
public class ControladorTransaccionesTest {
    
    public ControladorTransaccionesTest() {
    }

    /**
     * Test of buscarUsu method, of class ControladorTransacciones.
     */
    @Test
    public void testBuscarUsu() {
        int cedula = 123;
        ControladorVentanaUsuario instance = new ControladorVentanaUsuario();
        Usuario expResult = new Usuario(0,123, "camilo", "Duarte", "95566", "1", "1");
        Usuario result = instance.buscar(cedula);
        assertEquals(expResult.getCedula(), result.getCedula());
    }

    /**
     * Test of buscar method, of class ControladorTransacciones.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 1;
        ControladorTransacciones instance = new ControladorTransacciones();
        LocalDate fecha = LocalDate.of(2023, Month.OCTOBER, 26);
        LocalTime hora = LocalTime.of(23, 3);
        Transaccion expResult = new Transaccion(1, "Inicio Sesión", fecha, hora, "El usuario incio sesion", 12345);
        Transaccion result = instance.buscar(id);
        assertEquals(expResult.getId(), result.getId());       
    }
        
}

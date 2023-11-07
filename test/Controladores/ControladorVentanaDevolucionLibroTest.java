/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import Modelos.PrestamoLibro;
import Modelos.Transaccion;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaDevolucionLibroTest {
    
    public ControladorVentanaDevolucionLibroTest() {
    }

    /**
     * Test of buscarPrestamo method, of class ControladorVentanaDevolucionLibro.
     */
    @Test
    public void testBuscarPrestamo() {
        System.out.println("buscarPrestamo");
        int id_prestamo = 1;
        ControladorVentanaDevolucionLibro instance = new ControladorVentanaDevolucionLibro();
        PrestamoLibro expResult = new PrestamoLibro(1, 123, "789", LocalDate.EPOCH, LocalDate.MIN, LocalDate.EPOCH);
        PrestamoLibro result = instance.buscarPrestamo(id_prestamo);
        assertEquals(expResult.getId_prestamo(), result.getId_prestamo());
    }
    
    
    @Test
    public void testBuscarLibro() {
        System.out.println("buscarLibro");
        String codigo_libro = "123";
        ControladorVentanaGestionLibros instance = new ControladorVentanaGestionLibros();
        Libro expResult = new Libro(1, "123", "hola", "juan", 1, 1999, 196);
        Libro result = instance.buscarLibro(codigo_libro);
        assertEquals(expResult.getCodigo_libro(), result.getCodigo_libro());
    }
}

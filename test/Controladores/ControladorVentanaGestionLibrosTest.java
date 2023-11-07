/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Libro;
import Modelos.Transaccion;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionLibrosTest {
    
    public ControladorVentanaGestionLibrosTest() {
    }

    

    /**
     * Test of buscarLibro method, of class ControladorVentanaGestionLibros.
     */
    @Test
    public void testBuscarLibro() {
        System.out.println("buscarLibro");
        String codigo_libro = "123";
        ControladorVentanaGestionLibros instance = new ControladorVentanaGestionLibros();
        Libro expResult = new Libro(1, "123", "hola", "juan", 1, 1999, 196);
        Libro result = instance.buscarLibro(codigo_libro);
        assertEquals(expResult.getCodigo_libro(), result.getCodigo_libro());
    }
    
    @Test
    public void testBuscarCategoria() {
        System.out.println("buscarCategoria");
        int id_categoria = 1;
        ControladorVentanaGestionCategoria instance = new ControladorVentanaGestionCategoria();
        Categoria expResult = new Categoria(1,"hola" );
        Categoria result = instance.buscarCategoria(id_categoria);
        assertEquals(expResult.getNombre_categoria(), result.getNombre_categoria());
    }

   
}

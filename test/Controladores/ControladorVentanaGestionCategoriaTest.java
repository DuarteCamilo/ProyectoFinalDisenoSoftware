/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Transaccion;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionCategoriaTest {
    
    public ControladorVentanaGestionCategoriaTest() {
    }

   
    /**
     * Test of buscarCategoria method, of class ControladorVentanaGestionCategoria.
     */
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

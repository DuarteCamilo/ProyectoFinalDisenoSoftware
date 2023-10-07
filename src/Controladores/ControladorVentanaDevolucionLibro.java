/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import Modelos.PrestamoLibro;
import java.util.ArrayList;
import servicios.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaDevolucionLibro {

    public ControladorVentanaDevolucionLibro() {
    }

    public ArrayList<PrestamoLibro> traerPrestamos(int cedula) {
        ArrayList<PrestamoLibro> lista = ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula);
        return lista; 
    }

    public  Libro buscarLibro (String codigo_libro){
        Libro libro = ServiceLibros.getINSTANCE().buscarLibro(codigo_libro);
        return libro;
    }

    public void devolucion( int prestamo_id  , String fecha_devolucion) {
        ServiceGestionPrestamos.getINSTANCE().registrarDevolucion(prestamo_id, fecha_devolucion); 
    }
}

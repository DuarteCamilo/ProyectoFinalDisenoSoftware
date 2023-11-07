/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import Modelos.PrestamoLibro;
import Modelos.Transaccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaDevolucionLibro {

    public ControladorVentanaDevolucionLibro() {
    }

    public ArrayList<PrestamoLibro> traerPrestamos(int cedula) {
        return ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula);
         
    }
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }

    public  Libro buscarLibro (String codigo_libro){
        return ServiceLibros.getINSTANCE().buscar(codigo_libro);
    }

    public boolean devolucion( int prestamo_id  , String fecha_devolucion) {
        Object[] values = {prestamo_id, fecha_devolucion};
        return ServiceGestionPrestamos.getINSTANCE().editar(values); 
    }

    public PrestamoLibro buscarPrestamo(int id_prestamo) {
        return ServiceGestionPrestamos.getINSTANCE().buscar(id_prestamo);
    }  
    
    
}

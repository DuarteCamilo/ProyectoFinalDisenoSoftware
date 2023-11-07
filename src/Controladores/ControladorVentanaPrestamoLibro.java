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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaPrestamoLibro {
    
    public ControladorVentanaPrestamoLibro(){
        
    }
    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
    
    public ResultSet getRs(){
        return servicios.ServiceGestionPrestamos.getINSTANCE().getRs();
    }

    public  Libro buscarLibro (String codigo_libro){
        return ServiceLibros.getINSTANCE().buscar(codigo_libro);
    }
    
    
    public ArrayList traerLibros() throws SQLException{
        return ServiceLibros.getINSTANCE().getALL();
    }  
    
    
    public boolean registrarPrestamo(int cedula, String codigo_libro, String fecha_prestamo, String fecha_vencimiento){
        Object[] values = {cedula,codigo_libro,fecha_prestamo,fecha_vencimiento};
        return ServiceGestionPrestamos.getINSTANCE().agregar(values);
    }
    
    public ArrayList<PrestamoLibro> traerPrestamos(int cedula) {
        return ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula); 
    }
    
    
}

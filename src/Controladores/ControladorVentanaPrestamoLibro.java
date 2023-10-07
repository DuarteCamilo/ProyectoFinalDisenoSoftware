/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.*;

/**
 *
 * @author cduar
 */
public class ControladorVentanaPrestamoLibro {
    
    public ControladorVentanaPrestamoLibro(){
        
    }
    
    public ResultSet getRs(){
        ResultSet rs = servicios.ServiceGestionPrestamos.getINSTANCE().getRs();
        return rs;
    }
    public  Libro buscarLibro (String codigo_libro){
        Libro libro = ServiceLibros.getINSTANCE().buscarLibro(codigo_libro);
        return libro;
    }
    
    public ArrayList traerLibros() throws SQLException{
        ArrayList listaLibros = ServiceLibros.getINSTANCE().obtenerLibros();
        return listaLibros; 
    }  
    
    
    public boolean registrarPrestamo(int cedula, String codigo_libro, String fecha_prestamo, String fecha_vencimiento){
        boolean respuesta = ServiceGestionPrestamos.getINSTANCE().registrarPrestamo(cedula, codigo_libro, fecha_prestamo, fecha_vencimiento);
        return  respuesta;
    }
    
    
}

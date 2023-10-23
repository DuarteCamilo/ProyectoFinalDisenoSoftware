/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import Modelos.PrestamoLibro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.ServiceGestionPrestamos;
import servicios.ServiceLibros;

/**
 *
 * @author cduar
 */
public class ControladorVentanaHistoriaPyD {

    public ControladorVentanaHistoriaPyD() {
    }
    
    public  Libro buscarLibro (String codigo_libro){
        try {
            ResultSet rs = ServiceLibros.getINSTANCE().buscar(codigo_libro);
            
            if(rs.next()){
                int id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int categoria = rs.getInt("categoria");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);
                return libro;      
            }else{
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
                return null;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }  
    }
    
    public ArrayList<PrestamoLibro> traerPrestamos(int cedula) {
        return ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula);
         
    }
    
}

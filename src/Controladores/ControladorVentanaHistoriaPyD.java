/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Libro;
import Modelos.PrestamoLibro;
import Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.*;
import Reporte.GenerarReporte;
import com.itextpdf.text.DocumentException;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

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
    
    public ArrayList<PrestamoLibro> traerPrestamosCedula(int cedula) {
        return ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula);        
    }
    
    public ArrayList<PrestamoLibro> traerPrestamos() {
        return ServiceGestionPrestamos.getINSTANCE().getAll();         
    }
    
    public Usuario buscarUsu(int cedula){
        ResultSet rs = ServiceUsuario.getINSTANCE().buscar(cedula);
        try {
            if(rs.next()){
                String contraseniaInterna = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int id_usuario = rs.getInt("id_usuario");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Usuario usuario = new Usuario(id_usuario, cedula, nombre, apellidos, telefono, correo, contraseniaInterna );
                return usuario; 
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
        
    }

    public void enviarDatos(ArrayList<ArrayList<String>> tabla) {
        try {
            GenerarReporte.generarReporte(tabla);
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Categoria obternerCategoria ( int id_categoria ){
        try {
            ResultSet rs = ServiceCategoriaLibros.getINSTANCE().buscar(id_categoria);
            if(rs.next()){
                String nombre_categoria = rs.getString("nombre_categoria");
                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
                return categoria ;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }
    
}

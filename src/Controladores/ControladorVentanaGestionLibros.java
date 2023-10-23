/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Libro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.ServiceCategoriaLibros;
import servicios.ServiceLibros;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionLibros {

    public ControladorVentanaGestionLibros() {
    }
    
    public ResultSet getRs(){
        return servicios.ServiceGestionPrestamos.getINSTANCE().getRs();
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
    
    public ArrayList traerCategorias() throws SQLException{
        return ServiceCategoriaLibros.getINSTANCE().getAll();
    }    
    public boolean aniadirCategoria(String nombre_categoria){
        return ServiceCategoriaLibros.getINSTANCE().agregar(nombre_categoria);         
    }
    
    public boolean agregarLibro(Libro libro) {
        return  ServiceLibros.getINSTANCE().agregar(libro);
    }
    
    public boolean editarLibro(Libro libro) {
        return ServiceLibros.getINSTANCE().editar(libro);
    }
    public boolean eliminarLibro( String codigo_libro) {
        return ServiceLibros.getINSTANCE().eliminar(codigo_libro);
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

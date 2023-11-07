/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Libro;
import Modelos.Transaccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.ServiceCategoriaLibros;
import servicios.ServiceLibros;
import servicios.ServiceTransacciones;

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
    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
    
    
    public  Libro buscarLibro (String codigo_libro){
        return ServiceLibros.getINSTANCE().buscar(codigo_libro);       
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
    
    public Categoria buscarCategoria ( int id_categoria ){
        return ServiceCategoriaLibros.getINSTANCE().buscar(id_categoria);
    }
    
    
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Libro;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.ServiceCategoriaLibros;
import servicios.ServiceLibros;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionLibros {

    public ControladorVentanaGestionLibros() {
    }
    
    
    public  Libro buscarLibro (String codigo_libro){
        Libro libro = ServiceLibros.getINSTANCE().buscarLibro(codigo_libro);
        return libro;
    }
    
    public ArrayList traerCategorias() throws SQLException{
        ArrayList listaCategorias = ServiceCategoriaLibros.getINSTANCE().obtenerCategorias();
        return listaCategorias; 
    }    
    public void aniadirCategoria(String nombre_categoria){
        ServiceCategoriaLibros.getINSTANCE().agregarCategoria(nombre_categoria);  
    }
    
    public boolean agregarLibro(Libro libro) throws SQLException{
        Object[] values = {libro.getCodigo_libro(), libro.getTitulo(), libro.getAutor() , libro.getCategoria() ,   libro.getAnio_publicacion() , libro.getCant_dispo() };
        boolean respuesta = ServiceLibros.getINSTANCE().agregarLibro(values);
        return respuesta;
    }
    
    public boolean editarLibro(Libro libro) throws SQLException{
        Object[] values = {libro.getCodigo_libro(), libro.getTitulo(), libro.getAutor() , libro.getCategoria() ,   libro.getAnio_publicacion() , libro.getCant_dispo() };
        boolean resultado = ServiceLibros.getINSTANCE().editarLibro(values);
        return resultado;
    }
    public void eliminarLibro( String codigo_libro) throws SQLException{
        ServiceLibros.getINSTANCE().eliminarlibro(codigo_libro);
    }
    
    public String obternerCategoria (int id_categoria){
        String categoria = ServiceCategoriaLibros.getINSTANCE().obternerCategoria(id_categoria);
        return categoria;
        
    }
    

}

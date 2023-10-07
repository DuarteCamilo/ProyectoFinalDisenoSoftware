/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.ServiceCategoriaLibros;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionCategoria {

    public ControladorVentanaGestionCategoria() {
    }
    
    
    public void aniadirCategoria(String nombre_categoria){
        ServiceCategoriaLibros.getINSTANCE().agregarCategoria(nombre_categoria);  
    }
    public void editarCategoria(String nombre_categoria , int id_categoria) throws SQLException{       
        ServiceCategoriaLibros.getINSTANCE().editarCategoria(nombre_categoria,id_categoria);
    }
    public void eliminarCategoriaId(int id_categoria) throws SQLException{
        ServiceCategoriaLibros.getINSTANCE().eliminarCategoriaId(id_categoria);
    }
    public void eliminarCategoriaNombre(String nombre_categoria ) throws SQLException{
        ServiceCategoriaLibros.getINSTANCE().eliminarCategoriaNombre( nombre_categoria);
    }

    public ArrayList traerCategorias() throws SQLException{
        ArrayList listaCategorias = ServiceCategoriaLibros.getINSTANCE().obtenerCategorias();
        return listaCategorias; 
    }  
}

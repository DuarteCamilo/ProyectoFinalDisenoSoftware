/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Transaccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import servicios.ServiceCategoriaLibros;
import servicios.ServiceTransacciones;

/**
 *
 * @author cduar
 */
public class ControladorVentanaGestionCategoria {

    public ControladorVentanaGestionCategoria() {
    }

    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
    
    public boolean aniadirCategoria(String nombre_categoria){
       return ServiceCategoriaLibros.getINSTANCE().agregar(nombre_categoria);            
    }
    public boolean editarCategoria(Categoria categoria){ 
        return ServiceCategoriaLibros.getINSTANCE().editar( categoria);  
    }
    
    public boolean eliminar(int id_categoria) {    
        return ServiceCategoriaLibros.getINSTANCE().eliminar(id_categoria);              
    }
    

    public ArrayList traerCategorias() throws SQLException{
        return ServiceCategoriaLibros.getINSTANCE().getAll();
    }  
}

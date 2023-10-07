/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.ServiceCategoriaLibros;
import servicios.ServiceLibros;

/**
 *
 * @author cduar
 */
public class ControladorVentanaFiltroCategorias {

    public ControladorVentanaFiltroCategorias() {
    }
    
    public ResultSet getRs(){
        ResultSet rs = servicios.ServiceGestionPrestamos.getINSTANCE().getRs();
        return rs;
    }
    
    public ArrayList traerCategorias() throws SQLException{
        ArrayList listaCategorias = ServiceCategoriaLibros.getINSTANCE().obtenerCategorias();
        return listaCategorias; 
    }  
    public ArrayList filtrarLibros(int id_categoria) throws SQLException{
        ArrayList listaProductos = ServiceLibros.getINSTANCE().obtenerLibrosFiltro(id_categoria);
        
        
        return listaProductos ;
    }
}

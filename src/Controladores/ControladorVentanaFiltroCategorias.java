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
        return servicios.ServiceGestionPrestamos.getINSTANCE().getRs();
    }
    
    public ArrayList traerCategorias() throws SQLException{
        return ServiceCategoriaLibros.getINSTANCE().getAll();
    }  
    public ArrayList filtrarLibros(int id_categoria)throws SQLException {
        return ServiceLibros.getINSTANCE().obtenerLibrosFiltro(id_categoria);
    }
}

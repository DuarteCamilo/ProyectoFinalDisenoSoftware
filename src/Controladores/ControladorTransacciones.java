/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Transaccion;
import Modelos.Usuario;
import Reporte.GenerarReporteTransacciones;
import com.itextpdf.text.DocumentException;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servicios.ServiceTransacciones;
import servicios.ServiceUsuario;

/**
 *
 * @author cduar
 */
public class ControladorTransacciones {
    

    
  
    
    public void enviarDatos(ArrayList<ArrayList<String>> tabla) {
        try {
            GenerarReporteTransacciones.generarReporte(tabla);
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }

    
    public ArrayList traerTransacciones (){
        return ServiceTransacciones.getINSTANCE().consultaTransaccion();
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
}

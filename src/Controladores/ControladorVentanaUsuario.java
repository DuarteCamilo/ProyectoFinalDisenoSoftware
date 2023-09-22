/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Usuario;
import java.sql.SQLException;
import servicios.ServiceUsuario;

/**
 *
 * @author cduar
 */
public class ControladorVentanaUsuario {

    public ControladorVentanaUsuario() {
    }
    
    public boolean editarUsuario(Usuario usuario) throws SQLException{
        Object[] values = {usuario.getNombre(), usuario.getApellidos(), usuario.getCedula(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContrasena()};
        boolean respuesta = ServiceUsuario.getINSTANCE().editarUsuario(values);
        return respuesta;
    }
    public void eliminar( int id) throws SQLException{
        ServiceUsuario.getINSTANCE().eliminarUsuario(id);
    }
    
    
}

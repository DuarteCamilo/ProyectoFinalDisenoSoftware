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
public class ControladorVentanaCrearUsuario {

    public ControladorVentanaCrearUsuario() {
    }
    
    public void crearUsuario(Usuario usuario) throws SQLException{
        Object[] values = {usuario.getNombre(), usuario.getApellidos(), usuario.getId(), usuario.getCorreo(), usuario.getTelefono(), usuario.getContrasena()};
        ServiceUsuario.getINSTANCE().agregarUsuario(values);
    }
    
}

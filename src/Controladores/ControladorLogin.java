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
public class ControladorLogin {

    public ControladorLogin() {
    }
    
    public  Usuario ingresar( String correo , String contrasena) throws SQLException{
        Usuario usuario = ServiceUsuario.getINSTANCE().ingresarUsuario(correo , contrasena );
        return usuario; 
    }
    }

    

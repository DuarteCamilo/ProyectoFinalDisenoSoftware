/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Usuario;
import servicios.ServiceUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cduar
 */
public class ControladorLogin {

    public ControladorLogin() {
    }
    
    public  Usuario ingresar( String correo , String contrasena) {
        Object[] values = {correo, contrasena};
        return  ServiceUsuario.getINSTANCE().Ingresar(values);
    }
}

    

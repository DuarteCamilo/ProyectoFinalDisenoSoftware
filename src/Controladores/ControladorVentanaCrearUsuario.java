/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Transaccion;
import Modelos.Usuario;
import java.sql.SQLException;
import servicios.ServiceTransacciones;
import servicios.ServiceUsuario;

/**
 *
 * @author cduar
 */
public class ControladorVentanaCrearUsuario {

    public ControladorVentanaCrearUsuario() {
    }
  
    public boolean crearUsuario(Usuario usuario) {
        return ServiceUsuario.getINSTANCE().agregar(usuario);
    }    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
}

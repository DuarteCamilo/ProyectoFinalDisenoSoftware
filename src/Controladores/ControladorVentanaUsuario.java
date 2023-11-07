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
public class ControladorVentanaUsuario {

    public ControladorVentanaUsuario() {
    }
    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
    
    public boolean editarUsuario(Usuario usuario) {
        return ServiceUsuario.getINSTANCE().editar(usuario);
    }
    public boolean eliminar( int id) {
        return ServiceUsuario.getINSTANCE().eliminar(id);
    }
    
    public Usuario buscar( int cedula) {
        return ServiceUsuario.getINSTANCE().buscar(cedula);
    }
   
}

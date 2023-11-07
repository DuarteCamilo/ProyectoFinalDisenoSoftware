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
            GenerarReporteTransacciones.GenerarReporteTransacciones(tabla);
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
        return ServiceUsuario.getINSTANCE().buscar(cedula);
    }
    
    
    public Transaccion buscar(int id){
        return ServiceTransacciones.getINSTANCE().buscar(id);
        
    }
}

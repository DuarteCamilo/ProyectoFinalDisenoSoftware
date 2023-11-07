/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Categoria;
import Modelos.Libro;
import Modelos.PrestamoLibro;
import Modelos.Transaccion;
import Modelos.Usuario;
import java.util.ArrayList;
import servicios.*;
import com.itextpdf.text.DocumentException;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

/**
 *
 * @author cduar
 */
public class ControladorVentanaHistoriaPyD {

    public ControladorVentanaHistoriaPyD() {
    }
    
    public void agregarTransaccion(Transaccion transaccion) {
        ServiceTransacciones.getINSTANCE().agregar(transaccion);
    }
    
    public  Libro buscarLibro (String codigo_libro){
    return ServiceLibros.getINSTANCE().buscar(codigo_libro);
    }
    
    public ArrayList<PrestamoLibro> traerPrestamosCedula(int cedula) {
        return ServiceGestionPrestamos.getINSTANCE().buscarPrestamosActivosPorUsuario(cedula);        
    }
    
    public ArrayList<PrestamoLibro> traerPrestamos() {
        return ServiceGestionPrestamos.getINSTANCE().getAll();         
    }
    
    public Usuario buscarUsu(int cedula){
        return ServiceUsuario.getINSTANCE().buscar(cedula);   
    }

    public void enviarDatos(ArrayList<ArrayList<String>> tabla) {
        try {
            Reporte.GenerarReporte.GenerarReporte(tabla);
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public Categoria obternerCategoria ( int id_categoria ){
        return  ServiceCategoriaLibros.getINSTANCE().buscar(id_categoria);
    }
}

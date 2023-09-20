/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;


import ConexioDB.ConexionDB;
import Modelos.Libro;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class ServiceLibros {
    private static ServiceLibros INSTANCE = new ServiceLibros();
    
    private static Connection conn = new ConexionDB().connect();
    
    public ServiceLibros() {
    }

    public static ServiceLibros getINSTANCE() {
        return INSTANCE;
    }
    
    public static Libro buscarLibro(String codigo_libro){
        
    }    
    
  
    
    public static void agregarLibro ( Object[] values  ) throws SQLException{
        try{ 
            String codigo_libro = values[0].toString();
            String titulo = values[1].toString();
            String autor = values[2].toString();
            int categoria = Integer.parseInt(values[3].toString()) ;
            int anio_publicacion = Integer.parseInt(values[4].toString()) ;
            int cant_dispo = Integer.parseInt(values[5].toString()) ;
            
        
            String sqlBuscarLibro = "SELECT codigo_libro FROM libros WHERE codigo_libro = ?";
            PreparedStatement buscarLibroStmt = conn.prepareStatement(sqlBuscarLibro);
            buscarLibroStmt.setString(1, codigo_libro);
            ResultSet resultado = buscarLibroStmt.executeQuery();

            
            if (resultado.next()) {
                
                JOptionPane.showMessageDialog(null, "El libro con el codigo " + codigo_libro + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

            
                String sql = "INSERT INTO libros(codigo_libro,titulo,autor,id_categoria,anio_publicacion,cant_dispo)" +  "VALUES(?,?,?,?,?,?);";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                preparedStatement.setString(1, codigo_libro);
                preparedStatement.setString(2, titulo);
                
                preparedStatement.setString(3, autor);
                preparedStatement.setInt(4, categoria);
                preparedStatement.setInt(5, anio_publicacion);
                preparedStatement.setInt(6, cant_dispo);
               

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Libro agregado");
            }
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    public static void editarLibro ( Object[] values ){
        try{      
            String codigo_libro = values[0].toString();
            String titulo = values[1].toString();
            String autor = values[2].toString();
            int categoria = Integer.parseInt(values[3].toString()) ;
            int anio_publicacion = Integer.parseInt(values[4].toString()) ;
            int cant_dispo = Integer.parseInt(values[5].toString()) ;
            
            String sqlBuscarCodigoLibro = "SELECT codigo_libro FROM libros WHERE codigo_libro = ?";            
            PreparedStatement buscarLibroStmt1 = conn.prepareStatement(sqlBuscarCodigoLibro);            
            buscarLibroStmt1.setString(1, codigo_libro);
            ResultSet resultado = buscarLibroStmt1.executeQuery();

            if(resultado.next()){

                String sql = "UPDATE libros set titulo=?,autor=?,categoria=?,anio_publicacion=?,cant_dispo=? where codigo_libro=?;";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, titulo);
                preparedStatement.setString(2, autor);
                preparedStatement.setInt(3, categoria);
                preparedStatement.setInt(4, anio_publicacion);
                preparedStatement.setInt(5, cant_dispo);
                preparedStatement.setString(6, codigo_libro);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");

            }
            else {
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static  void eliminarlibro( int codigo_libro ){
        try{
            String sql = "DELETE from libros where codigo_libro =?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, codigo_libro );
            preparedStatement.executeUpdate();
            preparedStatement.close();           
            JOptionPane.showMessageDialog(null, "Datos eliminados");
            conn.close();
        }catch(Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
   
    
}

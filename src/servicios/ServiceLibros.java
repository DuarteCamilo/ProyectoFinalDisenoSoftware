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
import java.util.ArrayList;
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
        try {
            String sqlBuscarLibro = "SELECT * FROM libros WHERE codigo_libro = ?";
            PreparedStatement buscarLibroStmt = conn.prepareStatement(sqlBuscarLibro);
            buscarLibroStmt.setString(1, codigo_libro);
            ResultSet rs = buscarLibroStmt.executeQuery();
            
            if(rs.next()){
                int id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int categoria = rs.getInt("categoria");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);
                return libro;

                
            }else{
                JOptionPane.showMessageDialog(null, "El libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);   
            }
            
        }catch( Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }    
    
    public static ResultSet buscar_verificar(String codigo_libro){
         try{
            String sqlBuscarCodigoLibro = "SELECT codigo_libro FROM libros WHERE codigo_libro = ?";            
            PreparedStatement buscarLibroStmt1 = conn.prepareStatement(sqlBuscarCodigoLibro);            
            buscarLibroStmt1.setString(1, codigo_libro);
            ResultSet resultado = buscarLibroStmt1.executeQuery();
            return resultado;
        
        }catch( Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    
    public boolean agregarLibro ( Object[] values  ) throws SQLException{
        try{ 
            String codigo_libro = values[0].toString();
            String titulo = values[1].toString();
            String autor = values[2].toString();
            int categoria = Integer.parseInt(values[3].toString()) ;
            int anio_publicacion = Integer.parseInt(values[4].toString()) ;
            int cant_dispo = Integer.parseInt(values[5].toString()) ;
            
            ResultSet resultado = buscar_verificar(codigo_libro);

            if (resultado.next()) {                
                JOptionPane.showMessageDialog(null, "El libro con el codigo " + codigo_libro + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {

            
                String sql = "INSERT INTO libros(codigo_libro,titulo,autor,categoria,anio_publicacion,cant_dispo)" +  "VALUES(?,?,?,?,?,?);";

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
                return true;
            }
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()  ).log(Level.SEVERE, null, ex);
        }   
        return false;
    }
    
    
    
    public boolean editarLibro ( Object[] values ){
        try {
            String codigo_libro = values[0].toString();
            String titulo = values[1].toString();
            String autor = values[2].toString();
            int categoria = Integer.parseInt(values[3].toString()) ;
            int anio_publicacion = Integer.parseInt(values[4].toString()) ;
            int cant_dispo = Integer.parseInt(values[5].toString()) ;

            ResultSet resultado = buscar_verificar(codigo_libro);

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
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
                return false;
            }
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static  void eliminarlibro( String codigo_libro ){
        try{
            ResultSet rs = buscar_verificar(codigo_libro);
            if(rs.next()){
                String sql = "DELETE from libros where codigo_libro =?;";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, codigo_libro );
                preparedStatement.executeUpdate();
                preparedStatement.close();           
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                conn.close();
            }else{
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
            }  
        }catch(Exception ex){
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
    
    
        public static ArrayList obtenerProductosFiltro(int categoria){
        ResultSet rs = null;
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            
            String sql = "SELECT id_libro,codigo_libro,titulo,autor,anio_publicacion,cant_dispo FROM libros WHERE categoria=? ;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, categoria );
            


            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_libro = rs.getInt("id_libro");
                String codigo_libro = rs.getString("codigo_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                
                
                
                
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);
                libros.add(libro);         
           }
            
           return libros;

        } catch (SQLException ex) {
            Logger.getLogger(ServiceLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    
    
    
//        public static ArrayList obtenerLibros(){
//        ArrayList<Libro> listaLibros = new ArrayList();
//        try {
//            String sql = "SELECT id_categoria,nombre_categoria FROM categorias;" ;
//            //System.out.println(sql);
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id_categoria = rs.getInt("id_categoria");
//                String nombre_categoria = rs.getString("nombre_categoria");
//                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
//                listaLibros.add(categoria);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//
//        return listaLibros;     
//    }
   
    
}

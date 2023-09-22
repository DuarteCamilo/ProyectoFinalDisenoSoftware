/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import ConexioDB.ConexionDB;
import Modelos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author cduar
 */
public class ServiceCategoriaLibros {
    
    private static ServiceCategoriaLibros  INSTANCE = new ServiceCategoriaLibros ();
    
    private static Connection conn = new ConexionDB().connect();
    
    public ServiceCategoriaLibros () {
    }

    public static ServiceCategoriaLibros  getINSTANCE() {
        return INSTANCE;
    } 
    
    public String obternerCategoria(int id_categoria){
        String categoria = null;
        try {
            String sql = "SELECT nombre_categoria FROM categorias_libros WHERE id_categoria=?;" ;

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setInt(1, id_categoria);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                
                categoria = rs.getString("nombre_categoria");
                return categoria;
            }

        } catch (Exception ex) {
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return categoria;
        
    }
    
    public static ArrayList obtenerCategorias(){
        ArrayList<Categoria> listaCategorias = new ArrayList();
        try {
            String sql = "SELECT id_categoria,nombre_categoria FROM categorias_libros;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_categoria = rs.getInt("id_categoria");
                String nombre_categoria = rs.getString("nombre_categoria");
                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
                listaCategorias.add(categoria);
            }

        } catch (Exception ex) {
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listaCategorias;     
    }
    
    
    public static void agregarCategoria ( String nombre_categoria  ){
        try {
            ResultSet rs = buscar_verificar(nombre_categoria);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "La categoria con el nombre: " + nombre_categoria + " ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);               
            }else{
                try{
                    String sql = "INSERT INTO categorias_libros( nombre_categoria) VALUES(?);";

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, nombre_categoria);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    JOptionPane.showMessageDialog(null, "Categoría agregada");
                } catch (Exception ex) {
                    Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
    
    public static  ResultSet buscar_verificar (  String nombre_categoria  ){
        try{
            String sqlBuscar = "SELECT nombre_categoria FROM categorias_libros WHERE nombre_categoria=?";
            PreparedStatement buscarStmt = conn.prepareStatement(sqlBuscar);
            buscarStmt.setString(1, nombre_categoria);
            ResultSet resultado = buscarStmt.executeQuery();
            return resultado;         
        }catch( Exception ex){
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
        
    }
     
     
     public static void editarCategoria ( String nombre_categoria , int id_categoria ){
        try{
            ResultSet rs = buscar_verificar(nombre_categoria);

                
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "La categoria con el nombre: " + nombre_categoria + " ya está registrada", "Error", JOptionPane.ERROR_MESSAGE);                  
            }else {
                String sql = "UPDATE categorias_libros SET nombre_categoria=? WHERE id_categoria=?;";          
            
                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                
                preparedStatement.setString(1, nombre_categoria);
                preparedStatement.setInt(2, id_categoria);
            

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                

            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static  void eliminarCategoriaId( int id_categoria ){
         
        try {
                String sql = "DELETE from categorias_libros where id_categoria=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id_categoria);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Categoria eliminada");
            } catch (PSQLException ex) {
                if (ex.getMessage().contains("violates foreign key constraint \"libros_categoria_fkey\"")) {
                    // Muestra un mensaje personalizado si se viola la restricción de clave foránea
                    JOptionPane.showMessageDialog(null, "No se puede eliminar la categoría porque hay libros asignados a esta categoría.");
                } else {
                    Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     
    public static  void eliminarCategoriaNombre( String nombre_categoria ){
        try {
                String sql = "DELETE from categorias_libros where nombre_categoria=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, nombre_categoria);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Categoria eliminada");
            } catch (PSQLException ex) {
                if (ex.getMessage().contains("violates foreign key constraint \"libros_categoria_fkey\"")) {
                    // Muestra un mensaje personalizado si se viola la restricción de clave foránea
                    JOptionPane.showMessageDialog(null, "No se puede eliminar la categoría porque hay libros asignados a esta categoría.");
                } else {
                    Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
    }
         
         
         
         
//        if (id_categoria != 0) {
//            try {
//                String sql = "DELETE from categorias_libros where id_categoria=?";
//                PreparedStatement preparedStatement = conn.prepareStatement(sql);
//                preparedStatement.setInt(1, id_categoria);
//                preparedStatement.executeUpdate();
//                preparedStatement.close();
//                JOptionPane.showMessageDialog(null, "Categoria eliminada");
//            } catch (PSQLException ex) {
//                if (ex.getMessage().contains("violates foreign key constraint \"libros_categoria_fkey\"")) {
//                    // Muestra un mensaje personalizado si se viola la restricción de clave foránea
//                    JOptionPane.showMessageDialog(null, "No se puede eliminar la categoría porque hay libros asignados a esta categoría.");
//                } else {
//                    Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (!nombre_categoria.isEmpty()) {
//            try {
//                String sql = "DELETE from categorias_libros where nombre_categoria=?";
//                PreparedStatement preparedStatement = conn.prepareStatement(sql);
//                preparedStatement.setString(1, nombre_categoria);
//                preparedStatement.executeUpdate();
//                preparedStatement.close();
//                JOptionPane.showMessageDialog(null, "Categoria eliminada");
//            } catch (PSQLException ex) {
//                if (ex.getMessage().contains("violates foreign key constraint \"libros_categoria_fkey\"")) {
//                    // Muestra un mensaje personalizado si se viola la restricción de clave foránea
//                    JOptionPane.showMessageDialog(null, "No se puede eliminar la categoría porque hay libros asignados a esta categoría.");
//                } else {
//                    Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    
    
}

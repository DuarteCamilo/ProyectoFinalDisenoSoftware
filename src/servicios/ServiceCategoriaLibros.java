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
            String sql = "SELECT nombre_categoria FROM categorias WHERE id_categoria=?;" ;

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setInt(1, id_categoria);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                
                categoria = rs.getString("nombre_categoria");
                return categoria;
            }

        } catch (Exception ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return categoria;
        
    }
    
    public static ArrayList obtenerCategorias(){
        ArrayList<Categoria> listaCategorias = new ArrayList();
        try {
            String sql = "SELECT id_categoria,nombre_categoria FROM categorias;" ;
            //System.out.println(sql);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_categoria = rs.getInt("id_categoria");
                String nombre_categoria = rs.getString("nombre_categoria");
                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
                listaCategorias.add(categoria);
            }

        } catch (Exception ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listaCategorias;     
    }
    
    
    public static void agregarCategoria ( String nombre_categoria  ){
        try {
            int id_categoria = obtenerNuevoIdCategoria(); // Generar un nuevo id_categoria

            String sql = "INSERT INTO categorias(id_categoria, nombre_categoria) VALUES(?, ?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id_categoria);
            preparedStatement.setString(2, nombre_categoria);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Categoría agregada");
        } catch (Exception ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static int obtenerNuevoIdCategoria() throws SQLException {
        // Obtener el máximo id_categoria actual en la base de datos
        String sqlMax = "SELECT MAX(id_categoria) FROM categorias;";
        PreparedStatement preparedStatementMax = conn.prepareStatement(sqlMax);
        ResultSet resultSetMax = preparedStatementMax.executeQuery();

        resultSetMax.next();
        int maxId = resultSetMax.getInt(1);

        resultSetMax.close();
        preparedStatementMax.close();

        // Comprobar si hay huecos en la secuencia de id_categoria
        for (int i = 1; i <= maxId; i++) {
            if (!idCategoriaExiste(i)) {
                return i; // Devolver el primer id no utilizado encontrado
            }
        }

        // Si no se encontraron huecos, devolver el siguiente número después del máximo
        return maxId + 1;
    }

    public static boolean idCategoriaExiste(int id_categoria) throws SQLException {
        String sql = "SELECT COUNT(*) FROM categorias WHERE id_categoria = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id_categoria);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        int count = resultSet.getInt(1);

        resultSet.close();
        preparedStatement.close();

        // Si count es igual a 0, significa que el id_categoria no existe en la base de datos
        return count > 0;
    }
    
    
     public static void agregarCategoriaFul ( int id_categoria , String nombre_categoria  ){
        try{
            
            
            String sqlBuscar = "SELECT id_categoria FROM categorias WHERE id_categoria=?";
            PreparedStatement buscarStmt = conn.prepareStatement(sqlBuscar);
            buscarStmt.setInt(1, id_categoria);
            ResultSet resultado = buscarStmt.executeQuery();

            
            if (resultado.next()) {
                
                JOptionPane.showMessageDialog(null, "La categoria con el ID " + id_categoria + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                
                

                try {
                    String sql = "INSERT INTO categorias(id_categoria,nombre_categoria)" +  "VALUES(?,?);";

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);

                    preparedStatement.setInt(1, id_categoria);
                    preparedStatement.setString(2, nombre_categoria);


                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    JOptionPane.showMessageDialog(null, "Categoria agregada");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
                
            //}
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
     
     public static void editarCategoria ( Object[] values ){
        try{
       
            String nombre_categoria = values[1].toString();
            int id_categoria = Integer.parseInt(values[0].toString());
            

            String sqlBuscar = "SELECT id_categoria FROM categorias WHERE id_categoria = ?";
            PreparedStatement buscarUsuarioStmt1 = conn.prepareStatement(sqlBuscar);
            buscarUsuarioStmt1.setInt(1, id_categoria);
            ResultSet resultado1 = buscarUsuarioStmt1.executeQuery();

                
            if(resultado1.next()){
                String sql = "UPDATE categorias SET nombre_categoria=? WHERE id_categoria=?;";          
            
                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                
                preparedStatement.setString(1, nombre_categoria);
                preparedStatement.setInt(2, id_categoria);
            

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
            }else {
                
                JOptionPane.showMessageDialog(null, "La categoria con el numero de ID " + id_categoria + " no está registrada", "Error", JOptionPane.ERROR_MESSAGE);               

            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static  void eliminarCategoria( int id_categoria ){
        try{
            
            
            String sql = "DELETE from categorias where id_categoria=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id_categoria );
            
            
            
            preparedStatement.executeUpdate();

            preparedStatement.close();
            
            JOptionPane.showMessageDialog(null, "Categoria eliminada");

            
            conn.close();
   
        }catch(Exception ex){
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
}

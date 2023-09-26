/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import ConexioDB.ConexionDB;
import ConexioDB.ConexionDB;
import Modelos.Usuario;
import Vistas.VentanaUsuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class ServiceUsuario {
    private static ServiceUsuario INSTANCE ;
    
    private static Connection conn;
    
    public static ServiceUsuario getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServiceUsuario();
        }
        return INSTANCE;
    }
    
    private ServiceUsuario() {
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    
    
    
    public static Usuario ingresarUsuario(String correo , String contrasena ) {
        try {
            String sql = "SELECT id_usuario,nombre,apellido,cedula,telefono,contrasena FROM usuarios WHERE correo=? " ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, correo );
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int id_usuario = rs.getInt("id_usuario");
                int cedula = rs.getInt("cedula");
                String telefono = rs.getString("telefono");
                String contraseniaInterna = rs.getString("contrasena");
                
                if( contrasena.equals(contraseniaInterna)){
                    Usuario usuario = new Usuario(id_usuario, cedula, nombre, apellidos, telefono, correo, contrasena);
                return usuario;
                }else{
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE); 
                }
                   
             }else {
                JOptionPane.showMessageDialog(null, "El usuario con el correo "+ correo +" no esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static ResultSet buscar_verificar_Cedula(int cedula){
         try{
            String sqlBuscarCodigoLibro = "SELECT * FROM usuarios WHERE cedula = ?";            
            PreparedStatement buscarLibroStmt1 = conn.prepareStatement(sqlBuscarCodigoLibro);            
            buscarLibroStmt1.setInt(1, cedula);
            ResultSet resultado = buscarLibroStmt1.executeQuery();
            return resultado;
        
        }catch( Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    
    public static ResultSet buscar_verificar_Correo(String correo){
         try{
            String sqlBuscarCodigoLibro = "SELECT * FROM usuarios WHERE correo = ?";            
            PreparedStatement buscarLibroStmt1 = conn.prepareStatement(sqlBuscarCodigoLibro);            
            buscarLibroStmt1.setString(1, correo);
            ResultSet resultado = buscarLibroStmt1.executeQuery();
            return resultado;
        
        }catch( Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    
    
    public boolean  agregarUsuario ( Object[] values  ) throws SQLException{
        try{  
            String nombre = values[0].toString();
            String apellido = values[1].toString();
            int cedula = Integer.parseInt(values[2].toString()) ;
            String telefono = values[4].toString();
            String correo = values[3].toString();
            String contrasena = values[5].toString();
            
            ResultSet resultado1 = buscar_verificar_Cedula(cedula);
            ResultSet resultado2 = buscar_verificar_Correo(correo);
           
            
            if (resultado1.next()   ) {
                JOptionPane.showMessageDialog(null, "El usuario con el numero de cedula " + cedula + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (resultado2.next()) {
                JOptionPane.showMessageDialog(null, "El usuario con el correo " + correo + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);                    
                 return false;                   
            } 
            String sql = "INSERT INTO usuarios(nombre,apellido,cedula,correo,telefono,contrasena)" +  "VALUES(?,?,?,?,?,?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
 
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setInt(3, cedula);
            preparedStatement.setString(4, correo);
            preparedStatement.setString(5, telefono);
            preparedStatement.setString(6, contrasena);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Usuario agregado");
            return true;
            
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return false;
        
    }
    
    public boolean editarUsuario ( Object[] values ){
        try{
            String nombre = values[0].toString();
            String apellido = values[1].toString();
            int cedula = Integer.parseInt(values[2].toString()) ;
            String telefono = values[4].toString();
            String correo = values[3].toString();
            String contrasena = values[5].toString();

            ResultSet resultado1 = buscar_verificar_Correo(correo);
            ResultSet rs = buscar_verificar_Cedula(cedula);
            
            if(resultado1.next()){
                if(rs.next()){
                    if( rs.getString("correo").equals(correo) ){
                        String sql = "UPDATE usuarios set nombre=?,apellido=?,telefono=?,contrasena=? where cedula=?;";

                        PreparedStatement preparedStatement = conn.prepareStatement(sql);

                        preparedStatement.setString(1, nombre);
                        preparedStatement.setString(2, apellido);
                        preparedStatement.setString(3, telefono);
                        preparedStatement.setString(4, contrasena);
                        preparedStatement.setInt(5, cedula);

                        preparedStatement.executeUpdate();

                        preparedStatement.close();
                        JOptionPane.showMessageDialog(null, "Datos actualizados");
                        return true;
                    }else {
                        JOptionPane.showMessageDialog(null, "El usuario con el Correo " + correo + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);                                  
                        return false;
                    }
                }    
            }
            else {
                String sql = "UPDATE usuarios set nombre=?,apellido=?,correo=?,telefono=?,contrasena=? where cedula=?;";
            
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setString(3, correo);
                preparedStatement.setString(4, telefono);
                preparedStatement.setString(5, contrasena);
                preparedStatement.setInt(6, cedula);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return true;
            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static  void eliminarUsuario( int cedula ){
        try{
            
            ResultSet rs = buscar_verificar_Cedula(cedula);
            
            
            if(rs.next()){
                String sql = "DELETE from usuarios where cedula=?;";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, cedula );
                preparedStatement.executeUpdate();
                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                conn.close();
                
            }else{
                JOptionPane.showMessageDialog(null, "El usuario con el numero de cedula " + cedula + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                                  
            }
            
   
        }catch(Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
   
    
}

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
    private static ServiceUsuario INSTANCE = new ServiceUsuario();
    
    private static Connection conn = new ConexionDB().connect();
    
    public ServiceUsuario() {
    }

    public static ServiceUsuario getINSTANCE() {
        return INSTANCE;
    } 
    
    
    public static Usuario ingresarUsuario(String correo , String contrasena ) {
        try {
            String sql = "SELECT nombre,apellido,id,telefono,contrasena FROM usuarios WHERE correo=? " ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, correo );
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int id = rs.getInt("id");
                String telefono = rs.getString("telefono");
                String contraseniaInterna = rs.getString("contrasena");
                
                if( contrasena.equals(contraseniaInterna)){
                    Usuario usuario = new Usuario(id, nombre, apellidos, telefono, correo, contrasena);
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
        
//        try {
//            
//            String sql = "SELECT nombre,apellido,id,telefono FROM usuarios WHERE correo=? AND contrasena=? " ;
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setString(1, correo );
//            preparedStatement.setString(2, contrasena );
//
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//
//                String nombre = rs.getString("nombre");
//                String apellidos = rs.getString("apellido");
//                int id = rs.getInt("id");
//                String telefono = rs.getString("telefono");
//                Usuario usuario = new Usuario(id, nombre, apellidos, telefono, correo, contrasena);
//                return usuario;
//                
//                        
//             }else {
//                JOptionPane.showMessageDialog(null, " La contraseña y correo son  incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
//                return null;
//            }
//
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            System.err.println(ex);
//        }
        return null;
    }
    
    public static void agregarUsuario ( Object[] values  ) throws SQLException{
        try{  
            String nombre = values[0].toString();
            String apellido = values[1].toString();
            int id = Integer.parseInt(values[2].toString()) ;
            String telefono = values[4].toString();
            String correo = values[3].toString();
            String contrasena = values[5].toString();
        
            String sqlBuscarUsuario = "SELECT id FROM usuarios WHERE id = ?";
            PreparedStatement buscarUsuarioStmt = conn.prepareStatement(sqlBuscarUsuario);
            buscarUsuarioStmt.setInt(1, id);
            ResultSet resultado = buscarUsuarioStmt.executeQuery();

            
            if (resultado.next()) {
                
                JOptionPane.showMessageDialog(null, "El usuario con el ID " + id + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

            
                String sql = "INSERT INTO usuarios(nombre,apellido,id,correo,telefono,contrasena)" +  "VALUES(?,?,?,?,?,?);";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setInt(3, id);
                preparedStatement.setString(4, correo);
                preparedStatement.setString(5, telefono);
                preparedStatement.setString(6, contrasena);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Usuario agregado");
            }
                   
        }catch( Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    public static void editarUsuario ( Object[] values ){
        try{
            //Statement stmt = conn.createStatement();
            
            String nombre = values[0].toString();
            String apellido = values[1].toString();
            int id = Integer.parseInt(values[2].toString()) ;
            String telefono = values[4].toString();
            String correo = values[3].toString();
            String contrasena = values[5].toString();
            
            //String sqlBuscarUsuario = "SELECT id FROM usuarios WHERE id = ?";
            String sqlBuscarCorreo = "SELECT correo FROM usuarios WHERE correo = ?";
            
            //PreparedStatement buscarUsuarioStmt = conn.prepareStatement(sqlBuscarUsuario);
            PreparedStatement buscarUsuarioStmt1 = conn.prepareStatement(sqlBuscarCorreo);
            
            //buscarUsuarioStmt.setInt(1, id);
            buscarUsuarioStmt1.setString(1, correo);
            
            //ResultSet resultado = buscarUsuarioStmt.executeQuery();
            ResultSet resultado1 = buscarUsuarioStmt1.executeQuery();

            
            //if (resultado.next()  ) {
                
                //JOptionPane.showMessageDialog(null, "El usuario con el ID " + id + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
            if(resultado1.next()){
                JOptionPane.showMessageDialog(null, "El usuario con el Correo " + correo + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);               
            }
            else {
                String sql = "UPDATE usuarios set nombre=?,apellido=?,correo=?,telefono=?,contrasena=? where id=?;";
            
            
                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setString(3, correo);
                preparedStatement.setString(4, telefono);
                preparedStatement.setString(5, contrasena);
                preparedStatement.setInt(6, id);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");

            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static  void eliminarUsuario( int id ){
        try{
            
            
            String sql = "DELETE from usuarios where id =?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id );
            preparedStatement.executeUpdate();

            preparedStatement.close();
            
            JOptionPane.showMessageDialog(null, "Datos eliminados");

            
            conn.close();
   
        }catch(Exception ex){
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
   
    
}

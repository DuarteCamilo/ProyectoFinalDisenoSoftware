/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;


import ConexioDB.ConexionDB;
import Modelos.Usuario;
import interfaces.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class ServiceUsuario implements DAO {
    private static ServiceUsuario INSTANCE ;
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;
    private static String sql;
    
    
    public static ServiceUsuario getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServiceUsuario();
        }
        return INSTANCE;
    }
    
    private ServiceUsuario() {
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    public static Usuario Ingresar(Object insertion){
        try {
            Object[] values = (Object[])insertion;
            String correo = values[0].toString();
            String contrasena = values[1].toString();
            sql = "SELECT * FROM usuarios WHERE correo=? " ;
            ps = conn.prepareStatement(sql);
            ps.setString(1, correo );
            rs = ps.executeQuery();

            if (rs.next()) {
                String contraseniaInterna = rs.getString("contrasena");
                if( contrasena.equals(contraseniaInterna)){
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellido");
                    int id_usuario = rs.getInt("id_usuario");
                    int cedula = rs.getInt("cedula");
                    String telefono = rs.getString("telefono");
                    Usuario usuario = new Usuario(id_usuario, cedula, nombre, apellidos, telefono, correo, contraseniaInterna );
                    return usuario; 
                }else{
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE); 
                    return null;
                }                 
             }else {
                JOptionPane.showMessageDialog(null, "El usuario con el correo "+ correo +" no esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);                  
            return null;
        }   
    }
    
    public  Usuario buscar_verificar_Correo(String correo){
         try{
            sql = "SELECT * FROM usuarios WHERE correo = ?";            
            ps = conn.prepareStatement(sql);            
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if(rs.next()){
                int cedula = rs.getInt("cedula");
                String contraseniaInterna = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int id_usuario = rs.getInt("id_usuario");
                String telefono = rs.getString("telefono");
                Usuario usuario = new Usuario(id_usuario, cedula, nombre, apellidos, telefono, correo, contraseniaInterna );
                return usuario; 
            }
        
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
        
    }
    
    public ArrayList getAll() {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    try {
        sql = "SELECT * FROM usuarios;";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            int cedula = rs.getInt("cedula");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            String contrasena = rs.getString("contrasena");
            Usuario usuario = new Usuario( cedula, nombre, apellido, telefono, correo, contrasena);
            usuarios.add(usuario);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return usuarios;
}


    @Override
    public boolean agregar(Object insertion) {
        try{  
            Usuario usaurio = (Usuario)insertion;
            String nombre = usaurio.getNombre();
            String apellido = usaurio.getApellidos();
            int cedula = usaurio.getCedula() ;
            String telefono = usaurio.getTelefono();
            String correo = usaurio.getCorreo();
            String contrasena = usaurio.getContrasena();
            
            Usuario rs1 = buscar(cedula);
            Usuario rs2 = buscar_verificar_Correo(correo);
 
            if (rs1 != null   ) {
                JOptionPane.showMessageDialog(null, "El usuario con el numero de cedula " + cedula + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (rs2  != null) {
                JOptionPane.showMessageDialog(null, "El usuario con el correo " + correo + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);                    
                 return false;                   
            } 
            sql = "INSERT INTO usuarios(nombre,apellido,cedula,correo,telefono,contrasena)" +  "VALUES(?,?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, cedula);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setString(6, contrasena);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Usuario agregado");
            return true;
 
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }   
        
    }

    @Override
    public boolean eliminar(Object insertion) {
        try{
            int cedula = (int)insertion;
            Usuario usuario = buscar(cedula);

            if(usuario != null){
                sql = "DELETE from usuarios where cedula=?;";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, cedula );
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Usuario eliminado");
                return true;

            }else{
                JOptionPane.showMessageDialog(null, "El usuario con el numero de cedula " + cedula + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                                  
                return false;
            }
            
   
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }

    @Override
    public boolean editar(Object insertion) {
        try{
            Usuario usaurio = (Usuario)insertion;
            String nombre = usaurio.getNombre();
            String apellido = usaurio.getApellidos();
            int cedula = usaurio.getCedula() ;
            String telefono = usaurio.getTelefono();
            String correo = usaurio.getCorreo();
            String contrasena = usaurio.getContrasena();

            Usuario rs1 = buscar_verificar_Correo(correo);
            Usuario rs2 = buscar(cedula);
            
            if(rs1 != null){
                if(rs2!= null){
                    if( rs2.getCorreo().equals(correo) ){
                        String sql = "UPDATE usuarios set nombre=?,apellido=?,telefono=?,contrasena=? where cedula=?;";
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, nombre);
                        ps.setString(2, apellido);
                        ps.setString(3, telefono);
                        ps.setString(4, contrasena);
                        ps.setInt(5, cedula);
                        ps.executeUpdate();
                        ps.close();
                        JOptionPane.showMessageDialog(null, "Datos actualizados");
                        return true;
                    }else {
                        JOptionPane.showMessageDialog(null, "El usuario con el Correo " + correo + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);                                  
                        return false;
                    }
                }    
            }
            else {
                sql = "UPDATE usuarios set nombre=?,apellido=?,correo=?,telefono=?,contrasena=? where cedula=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, correo);
                ps.setString(4, telefono);
                ps.setString(5, contrasena);
                ps.setInt(6, cedula);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return true;
            }
                   
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public Usuario buscar(Object insertion) {
        try{
            int cedula = (int)insertion;
            sql = "SELECT * FROM usuarios WHERE cedula = ?";            
            ps = conn.prepareStatement(sql);            
            ps.setInt(1, cedula);
            rs = ps.executeQuery(); 
            if(rs.next()){
                String contraseniaInterna = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellido");
                int id_usuario = rs.getInt("id_usuario");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Usuario usuario = new Usuario(id_usuario, cedula, nombre, apellidos, telefono, correo, contraseniaInterna );
                return usuario; 
            }
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        return null;
    } 
}

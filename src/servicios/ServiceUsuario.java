/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import ConexioDB.ConexionDB;
import ConexioDB.ConexionDB;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author cduar
 */
public class ServiceUsuario {
    
    private static Connection conn = new ConexionDB().connect();
    
    public static void buscarUsuario(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void agregarUsuario ( Usuario usuario ){
        try{
            
        }catch(){
            
        }
        
    }
    
    public static void main(String[] args) {
        buscarUsuario();
    }
    
}

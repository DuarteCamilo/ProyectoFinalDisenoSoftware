
package Vistas;

import Controladores.ControladorVentanaCrearUsuario;
import Modelos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class VentanaCrearUsuario extends javax.swing.JFrame {
    private ControladorVentanaCrearUsuario controlador ;

    /**
     * Creates new form RegistroUsuario
     */
    public VentanaCrearUsuario() {
        initComponents();
        controlador = new ControladorVentanaCrearUsuario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator9 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        btnIngresar = new javax.swing.JButton();
        btnIngresar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        jSeparator9.setBackground(new java.awt.Color(127, 85, 57));
        jSeparator9.setForeground(new java.awt.Color(127, 85, 57));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setBorder(new javax.swing.border.MatteBorder(null));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos personales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(127, 85, 57));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 120, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 120, 10));

        jLabel2.setForeground(new java.awt.Color(127, 85, 57));
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(127, 85, 57));
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidos.setBorder(null);
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 120, 10));

        jLabel3.setForeground(new java.awt.Color(127, 85, 57));
        jLabel3.setText("Identificación");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtId.setForeground(new java.awt.Color(127, 85, 57));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(null);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 120, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 120, 10));

        jLabel4.setForeground(new java.awt.Color(127, 85, 57));
        jLabel4.setText("Teléfono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(127, 85, 57));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 120, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 120, 10));

        jLabel5.setForeground(new java.awt.Color(127, 85, 57));
        jLabel5.setText("Correo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(127, 85, 57));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(null);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 120, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 120, 10));

        btnIngresar.setBackground(new java.awt.Color(127, 85, 57));
        btnIngresar.setFont(new java.awt.Font("Roboto Light", 1, 11)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Volver");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 70, 20));

        btnIngresar1.setBackground(new java.awt.Color(127, 85, 57));
        btnIngresar1.setFont(new java.awt.Font("Roboto Light", 1, 11)); // NOI18N
        btnIngresar1.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar1.setText("Registrar");
        btnIngresar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresar1MouseExited(evt);
            }
        });
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 120, 30));

        jLabel7.setForeground(new java.awt.Color(127, 85, 57));
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 1, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 85, 57));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registrar usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 340, 30));

        jLabel8.setForeground(new java.awt.Color(127, 85, 57));
        jLabel8.setText("Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        txtContrasena.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(127, 85, 57));
        txtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasena.setBorder(null);
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 120, 20));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 120, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar1MouseEntered

    private void btnIngresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar1MouseExited

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        // TODO add your handling code here:
        if( txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtId.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "Campos de texto vacios");
        }else{
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String contrasena = txtContrasena.getText();
                
                Usuario usuario = new Usuario(id, nombre, apellidos, telefono, correo, contrasena);
                controlador.crearUsuario(usuario);
               
                
                VentanaUsuario usu = new VentanaUsuario(usuario);
                usu.setVisible(true);
                this.dispose();
  
            } catch (Exception e) {
            }
            
            
        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

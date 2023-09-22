
package Vistas;

import Controladores.ControladorVentanaCrearUsuario;
import Modelos.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnCheckIn = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();

        jSeparator9.setBackground(new java.awt.Color(127, 85, 57));
        jSeparator9.setForeground(new java.awt.Color(127, 85, 57));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setBorder(new javax.swing.border.MatteBorder(null));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 85, 57), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(127, 85, 57));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 120, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 120, 10));

        jLabel2.setForeground(new java.awt.Color(127, 85, 57));
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(127, 85, 57));
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidos.setBorder(null);
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 120, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, 10));

        jLabel3.setForeground(new java.awt.Color(127, 85, 57));
        jLabel3.setText("Cedula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        txtId.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtId.setForeground(new java.awt.Color(127, 85, 57));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(null);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 120, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 120, 10));

        jLabel4.setForeground(new java.awt.Color(127, 85, 57));
        jLabel4.setText("Teléfono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(127, 85, 57));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(null);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 120, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 120, 10));

        jLabel5.setForeground(new java.awt.Color(127, 85, 57));
        jLabel5.setText("Correo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(127, 85, 57));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(null);
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 120, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 120, 10));

        jLabel7.setForeground(new java.awt.Color(127, 85, 57));
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 85, 57));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registrar usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, 30));

        jLabel8.setForeground(new java.awt.Color(127, 85, 57));
        jLabel8.setText("Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        txtContrasena.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(127, 85, 57));
        txtContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasena.setBorder(null);
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyTyped(evt);
            }
        });
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 120, 20));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 120, 10));

        jPanel2.setBackground(new java.awt.Color(127, 85, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Check in");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        btnCheckIn.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnCheckIn.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCheckIn.setText("Check in");
        btnCheckIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckInMouseClicked(evt);
            }
        });
        jPanel2.add(btnCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 120, 30));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.PNG"))); // NOI18N
        btnRegresar.setText("jLabel10");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE )) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros"); 
        }else if (txtId.getText().length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 10 caracteres permitidos");
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE )) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros"); 
        }else if (txtTelefono.getText().length() >= 10 && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 10 caracteres permitidos");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnCheckInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckInMouseClicked
       if( txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtId.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "Complete todos los campos de texto");
        }else{
            try {
                int cedula = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String contrasena = txtContrasena.getText();           
                Usuario usuario = new Usuario(cedula, cedula , nombre, apellidos, telefono, correo, contrasena);
                boolean respuesta = controlador.crearUsuario(usuario);
                if(respuesta){
                    VentanaUsuario usu = new VentanaUsuario(usuario);
                    usu.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
            }   
        } 
    }//GEN-LAST:event_btnCheckInMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaLogin();
        v2.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo letras "); 
        } else if (txtNombre.getText().length() >= 250) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 250 caracteres permitidos");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo letras "); 
        } else if (txtApellidos.getText().length() >= 250) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 250 caracteres permitidos");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        char c = evt.getKeyChar();
        if ( c == ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, " sin espacios"); 
        } else if (txtCorreo.getText().length() >= 300) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 300 caracteres permitidos");
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyTyped
        char c = evt.getKeyChar();
        if ( c == ' ') {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, " sin espacios"); 
        } else if (txtContrasena.getText().length() >= 50) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Máximo 50 caracteres permitidos");
        }
    }//GEN-LAST:event_txtContrasenaKeyTyped

    
   
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
    private javax.swing.JLabel btnCheckIn;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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

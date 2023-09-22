/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;
import ConexioDB.ConexionDB;
import Controladores.ControladorVentanaFiltroCategorias;
import Modelos.Categoria;
import Modelos.Libro;
import Modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diaza
 */
public class VentanaFiltroCategorias extends javax.swing.JFrame {
    private ControladorVentanaFiltroCategorias controlador;
    private Usuario usuario;

    /**
     * Creates new form VentanaFiltroCategorias
     */
    public VentanaFiltroCategorias(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.controlador = new ControladorVentanaFiltroCategorias();
        actualizarComboBox();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboCategorias = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(127, 85, 57));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnVolver.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(127, 85, 57));
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 80, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 85, 57));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filtra Libros por Categoria");

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setText("Seleccione una categoría:");

        cboCategorias.setBackground(new java.awt.Color(255, 255, 255));
        cboCategorias.setForeground(new java.awt.Color(127, 85, 57));
        cboCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 40, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 500, 10));

        tablaLibros.setBackground(new java.awt.Color(255, 255, 255));
        tablaLibros.setForeground(new java.awt.Color(127, 85, 57));
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Titulo", "Autor", "Categoria", "Año", "Disponibles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLibros.setSelectionBackground(new java.awt.Color(127, 85, 57));
        tablaLibros.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 470, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        this.dispose();
        VentanaUsuario usu = new VentanaUsuario(usuario);
        usu.setVisible(true);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void tablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibrosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaLibrosMouseClicked

    private void cboCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriasActionPerformed
        Object selectedItem = cboCategorias.getSelectedItem();
        if (selectedItem != null && selectedItem.toString().equals("-Seleccionar-")) {
            actualizarTabla();
        }else{
            String categoria1 = cboCategorias.getSelectedItem().toString();
            String[] catediv = categoria1.split("-",2);
            int id_categoria = Integer.parseInt(catediv[0]);
            String nombre_categoria = catediv[1];
        
            actualizarTablaFiltro(id_categoria , nombre_categoria);
        }
    }//GEN-LAST:event_cboCategoriasActionPerformed
    
    
    public void actualizarTabla(){
    DefaultTableModel modelo = new  DefaultTableModel();
    tablaLibros.setModel(modelo);   
    try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }
            }
        }catch(NullPointerException e){
        }
        try{
            
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            java.sql.Connection conn = new ConexionDB().connect();
    
            
            String sql = "SELECT L.codigo_libro, L.titulo, L.autor, C.nombre_categoria, L.anio_publicacion, L.cant_dispo FROM libros AS L INNER JOIN categorias_libros AS C ON L.categoria = C.id_categoria;";                    
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Codigo");
            modelo.addColumn("Titulo");
            modelo.addColumn("Autor");
            modelo.addColumn("Categoria");
            modelo.addColumn("Año");
            modelo.addColumn("Dispoibles");

            int anchos[] = {30, 120, 50, 50 ,30 , 70 };
            for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
                tablaLibros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);                
            }
            
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
    }
    
public void actualizarComboBox() {
        cboCategorias.removeAllItems();
        ArrayList<String> lista_str = new ArrayList<>();

        try {
            ArrayList<Categoria> listaCategorias = controlador.traerCategorias();
            for (int i = 0; i < listaCategorias.size(); i++) {
                Categoria categoria = listaCategorias.get(i);
                String id_categoria = String.valueOf(categoria.getId_categoria());
                String nombre_categoria = categoria.getNombre_categoria();
                lista_str.add(id_categoria + "-" + nombre_categoria);
            }

            Collections.sort(lista_str, (a, b) -> {
                int idA = Integer.parseInt(a.split("-")[0]);
                int idB = Integer.parseInt(b.split("-")[0]);
                return Integer.compare(idA, idB);
            });

            cboCategorias.addItem("-Seleccionar-");
            for (int i = 0; i < lista_str.size(); i++) {
                String item = lista_str.get(i);
                cboCategorias.addItem(item);
            }
            

        } catch (Exception e) {
        }
    }

private void actualizarTablaFiltro(int id_categoria , String nombre_categoria) {
        DefaultTableModel modelo = new  DefaultTableModel();
        tablaLibros.setModel(modelo);
        
        modelo.addColumn("Codigo");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Categoria");
        modelo.addColumn("Año");
        modelo.addColumn("Dispoibles");
        
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }
            }
        }catch(NullPointerException e){
        }
        try{
            ArrayList<Libro> listaProductos = controlador.filtrarLibros(id_categoria);

            for (int i = 0; i < listaProductos.size() ; i++) {
                Libro aux = listaProductos.get(i);
               
                    Object[] ob = {aux.getCodigo_libro(), aux.getTitulo(), aux.getAutor(), nombre_categoria ,  aux.getAnio_publicacion() ,  aux.getCant_dispo()  };
                    modelo.addRow(ob);
                
                }
        }catch( SQLException ex){        
        }
    }
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
            java.util.logging.Logger.getLogger(VentanaFiltroCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFiltroCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFiltroCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFiltroCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> cboCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    // End of variables declaration//GEN-END:variables
}

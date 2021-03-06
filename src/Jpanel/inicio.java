
package Jpanel;

import Base_de_Datos.conexion;
import JDialog.Movimientos_usuarios;
import JDialog.mi_perfil;
import javax.swing.JOptionPane;
import JDialog.registrar_usuario;
import JDialog.ver_usuarios;


/**
 *
 * @author thomis
 */
public class inicio extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    
    Ingresar ingresarvehiculo = new Ingresar();
    Retirar retirarvehiculo  = new Retirar();
    Listar ListarVehiculos = new Listar();
    registrar_usuario Registar = new registrar_usuario(this, rootPaneCheckingEnabled);
    ver_usuarios verU = new ver_usuarios(this,rootPaneCheckingEnabled);
    mi_perfil perfil = new mi_perfil(this, rootPaneCheckingEnabled);
    String current = System.getProperty("user.dir");
    Usuario mUsuario = Usuario.getUsuario();
    Movimientos_usuarios mu = new Movimientos_usuarios(this, rootPaneCheckingEnabled);
    
    int confirmacion;
    
    public inicio() {
        
        initComponents();

        new CambiaPanel(jPanel_Desglose, new Ingresar());
     
        setLocationRelativeTo(null);
        setSize(990, 460);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JB_IngresarVehiculo = new java.awt.Button();
        JB_RetirarV = new java.awt.Button();
        JButton_ListarVehiculos = new java.awt.Button();
        JB_Cierre = new java.awt.Button();
        jPanel_Desglose = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_usuarios = new javax.swing.JMenu();
        jMenuItem_ver_usuario = new javax.swing.JMenuItem();
        jMenuItem_movimientos = new javax.swing.JMenuItem();
        jMenuItem_nuevo_usuario = new javax.swing.JMenuItem();
        jMenu_perfil = new javax.swing.JMenu();
        jMenuIten_perfil = new javax.swing.JMenuItem();
        jMenuItem_cerrarsesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(3, 73, 223));
        setResizable(false);
        setSize(new java.awt.Dimension(826, 423));

        principal.setBackground(new java.awt.Color(3, 73, 223));

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        PanelMenu.setBackground(new java.awt.Color(3, 73, 223));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo2.jpeg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        JB_IngresarVehiculo.setBackground(new java.awt.Color(3, 73, 223));
        JB_IngresarVehiculo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        JB_IngresarVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        JB_IngresarVehiculo.setLabel("Ingresar Vehiculo");
        JB_IngresarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_IngresarVehiculoActionPerformed(evt);
            }
        });

        JB_RetirarV.setBackground(new java.awt.Color(3, 73, 223));
        JB_RetirarV.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        JB_RetirarV.setForeground(new java.awt.Color(255, 255, 255));
        JB_RetirarV.setLabel("Retirar Vehiculo");
        JB_RetirarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RetirarVActionPerformed(evt);
            }
        });

        JButton_ListarVehiculos.setBackground(new java.awt.Color(3, 73, 223));
        JButton_ListarVehiculos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        JButton_ListarVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        JButton_ListarVehiculos.setLabel("Listar Vehiculos");
        JButton_ListarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_ListarVehiculosActionPerformed(evt);
            }
        });

        JB_Cierre.setBackground(new java.awt.Color(3, 73, 223));
        JB_Cierre.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        JB_Cierre.setForeground(new java.awt.Color(255, 255, 255));
        JB_Cierre.setLabel("Salir");
        JB_Cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CierreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_IngresarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButton_ListarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Cierre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JB_RetirarV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JB_IngresarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_RetirarV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JButton_ListarVehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(JB_Cierre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel_Desglose.setLayout(new javax.swing.BoxLayout(jPanel_Desglose, javax.swing.BoxLayout.LINE_AXIS));

        jMenuBar1.setBackground(new java.awt.Color(51, 102, 255));

        jMenu_usuarios.setText("Usuarios");

        jMenuItem_ver_usuario.setText("Ver usuarios");
        jMenuItem_ver_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ver_usuarioActionPerformed(evt);
            }
        });
        jMenu_usuarios.add(jMenuItem_ver_usuario);

        jMenuItem_movimientos.setText("Movimientos de usuarios");
        jMenuItem_movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_movimientosActionPerformed(evt);
            }
        });
        jMenu_usuarios.add(jMenuItem_movimientos);

        jMenuItem_nuevo_usuario.setText("Nuevo Usuario");
        jMenuItem_nuevo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_usuarioActionPerformed(evt);
            }
        });
        jMenu_usuarios.add(jMenuItem_nuevo_usuario);

        jMenuBar1.add(jMenu_usuarios);

        jMenu_perfil.setText("Mi Perfil");

        jMenuIten_perfil.setText("Ver Perfil");
        jMenuIten_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIten_perfilActionPerformed(evt);
            }
        });
        jMenu_perfil.add(jMenuIten_perfil);

        jMenuItem_cerrarsesion.setText("Cerrar Sesion");
        jMenuItem_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_cerrarsesionActionPerformed(evt);
            }
        });
        jMenu_perfil.add(jMenuItem_cerrarsesion);

        jMenuBar1.add(jMenu_perfil);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Desglose, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Desglose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelMenu.getAccessibleContext().setAccessibleParent(principal);
        jPanel_Desglose.getAccessibleContext().setAccessibleParent(principal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_IngresarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_IngresarVehiculoActionPerformed
        // TODO add your handling code here:
        
        new CambiaPanel(jPanel_Desglose, new Ingresar());
        ingresarvehiculo.espacios();
        setLocationRelativeTo(null);
       
    }//GEN-LAST:event_JB_IngresarVehiculoActionPerformed

    private void JB_RetirarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RetirarVActionPerformed
        // TODO add your handling code here:
        
        new CambiaPanel(jPanel_Desglose, new Retirar());
        setLocationRelativeTo(null);
        
    }//GEN-LAST:event_JB_RetirarVActionPerformed

    private void JButton_ListarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_ListarVehiculosActionPerformed
        // TODO add your handling code here:
        
        new CambiaPanel(jPanel_Desglose, new Listar());
        setLocationRelativeTo(null);
        
    }//GEN-LAST:event_JButton_ListarVehiculosActionPerformed

    private void JB_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CierreActionPerformed
        // TODO add your handling code here:
        
      confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir del programa?", 
                                                   "Salir", JOptionPane.YES_NO_OPTION);
      
      if (confirmacion == 0){
          
          conexion.cierraCesion();
          System.exit(0);
          
      }//fin if
 
    }//GEN-LAST:event_JB_CierreActionPerformed

    private void jMenuItem_nuevo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_usuarioActionPerformed
        // TODO add your handling code here:
        
        Registar.setVisible(true);
    }//GEN-LAST:event_jMenuItem_nuevo_usuarioActionPerformed

    private void jMenuItem_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_cerrarsesionActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        Main.login();

    }//GEN-LAST:event_jMenuItem_cerrarsesionActionPerformed

    private void jMenuItem_ver_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ver_usuarioActionPerformed
        // TODO add your handling code here:
        
        verU.setVisible(true);
        verU.crearTabla();
        verU.rellenarTabla();
        verU.actualizaDatos();
    }//GEN-LAST:event_jMenuItem_ver_usuarioActionPerformed

    private void jMenuIten_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIten_perfilActionPerformed
        // TODO add your handling code here:
        String usuario = mUsuario.getUsu();
        String sql = "SELECT e.nombre_empleado, e.apellido_empleado, e.cedula_empleado,e.correo_empleado,e.telefono_empleado,u.usuario, u.contrasena_usuario,u.Posicion FROM empleados AS e INNER JOIN usuarios AS u on e.id_empleado = u.id_empleado WHERE u.usuario = '" + usuario + "'";
        perfil.DatosUsuario(sql);
        perfil.setVisible(true);
    }//GEN-LAST:event_jMenuIten_perfilActionPerformed

    private void jMenuItem_movimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_movimientosActionPerformed
        // TODO add your handling code here:
        
        mu.setVisible(true);
    }//GEN-LAST:event_jMenuItem_movimientosActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_Cierre;
    private java.awt.Button JB_IngresarVehiculo;
    private java.awt.Button JB_RetirarV;
    private java.awt.Button JButton_ListarVehiculos;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_cerrarsesion;
    private javax.swing.JMenuItem jMenuItem_movimientos;
    private javax.swing.JMenuItem jMenuItem_nuevo_usuario;
    private javax.swing.JMenuItem jMenuItem_ver_usuario;
    private javax.swing.JMenuItem jMenuIten_perfil;
    public static javax.swing.JMenu jMenu_perfil;
    public static javax.swing.JMenu jMenu_usuarios;
    private javax.swing.JPanel jPanel_Desglose;
    private javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables
}

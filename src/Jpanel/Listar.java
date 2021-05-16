
package Jpanel;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Base_de_Datos.conexion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Listar extends javax.swing.JPanel {

    /**
     * Creates new form Listar
     */
    
    //INSTANCIAS Y VARIABLES
    conexion objcon = new conexion();
    String sql;
    String tipoVehiculo = "", estado = "", fecha = "";
    DefaultTableModel modelo;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String placa;
    
    public Listar() {
        initComponents();
        
        objcon.crearConexion();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTF_Placa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        JButton_Buscar = new javax.swing.JButton();
        jButton_Cierre = new javax.swing.JButton();
        cbAuto = new javax.swing.JCheckBox();
        cbMoto = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        dcFechaBusqueda = new com.toedter.calendar.JDateChooser();
        jButton_reiniciar = new javax.swing.JButton();

        jLabel1.setText("Buscar Vehiculos");

        jLabel2.setText("Placa");

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Propietario", "Tipo de Vehiculo", "Hora Entrada", "Hora Salida", "Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVehiculos);

        jLabel5.setText("Tipo Vehiculo");

        JButton_Buscar.setText("Buscar");
        JButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_BuscarActionPerformed(evt);
            }
        });

        jButton_Cierre.setText("Cierre");
        jButton_Cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CierreActionPerformed(evt);
            }
        });

        cbAuto.setText("Automovil");

        cbMoto.setText("Motocicleta");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shop-around-for-your-perfect-used-car.png"))); // NOI18N

        jButton_reiniciar.setText("Reiniciar Tabla");
        jButton_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(JButton_Buscar)
                        .addGap(100, 100, 100)
                        .addComponent(jButton_Cierre)
                        .addGap(64, 64, 64)
                        .addComponent(jButton_reiniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cbAuto)
                                .addGap(21, 21, 21)
                                .addComponent(cbMoto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5)))
                        .addGap(115, 115, 115)
                        .addComponent(dcFechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(JTF_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)))
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTF_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dcFechaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButton_Buscar)
                    .addComponent(jButton_Cierre)
                    .addComponent(jButton_reiniciar))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbAuto)
                    .addComponent(cbMoto))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    //METODO PARA CREAR LA TABLA
    public void crearTabla(){
        
        TableColumnModel columnModel = tblVehiculos.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(100);
        
        modelo = (DefaultTableModel) tblVehiculos.getModel();
        modelo.setRowCount(0);
        
    } //Fin Crear Tabla
    
    //METODO PARA RELLENAR LA TABLA
    public void rellenarTabla(){
        try{
            
            modelo = (DefaultTableModel) tblVehiculos.getModel();
            modelo.setRowCount(0);
            
            sql = "SELECT * FROM vehiculos WHERE horasalida_vehiculo IS NULL";
            objcon.ejecutarSQLSelect(sql);

            conexion.resultado.first();

            do {
                String horasalida = conexion.resultado.getString(6);
                String pago = conexion.resultado.getString(7);
                
                if (horasalida == null) {
                    
                    horasalida = "No ha salido";
                    pago = "0";
                    
                } else {
                    
                    horasalida = conexion.resultado.getString(6).substring(10).substring(0,6);
                    pago = conexion.resultado.getString(7);
                    
                }
                
                String[] fila = {conexion.resultado.getString(2),
                                 conexion.resultado.getString(3),
                                 conexion.resultado.getString(4), 
                                 conexion.resultado.getString(5).substring(10).substring(0, 6), horasalida, "$" + pago};
                modelo.addRow(fila);
                
            } while (conexion.resultado.next());
            
        } catch (SQLException ex) {
             Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//Fin rellenar Tabla
    
    //METODO PARA BUSCAR VEHICULO
    public void buscarVehiculo(){
        
        try {
            
            sql = "SELECT * FROM vehiculos WHERE tipo_vehiculo LIKE'%" + tipoVehiculo + "%' AND placa_vehiculo LIKE '" + placa + "%' AND horaentrada_vehiculo LIKE '%" + fecha + "%'";
            objcon.ejecutarSQLSelect(sql);

            conexion.resultado.first();

            do {
                String horasalida = conexion.resultado.getString("horasalida_vehiculo");
                String pago;
                pago = conexion.resultado.getString("valorpagado");
                
                if (horasalida == null) {
                    
                    horasalida = "No ha salido";
                    pago = "0";
                    
                } else {
                    
                    horasalida = conexion.resultado.getString("horasalida_vehiculo").substring(10).substring(0,6);
                    pago = conexion.resultado.getString("valorpagado");
                    
                }
                
                String[] fila = {conexion.resultado.getString(2),conexion.resultado.getString(3),
                    conexion.resultado.getString(4),conexion.resultado.getString(5).substring(10).substring(0, 6),
                    horasalida, "$" + pago};
                
                modelo.addRow(fila);
                
            } while (conexion.resultado.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//Fin Buscar Vehiculo
    
    private void JButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButton_BuscarActionPerformed
      
         // TODO add your handling code here:
            
            if(cbAuto.isSelected()){
                
                if(cbMoto.isSelected()){
                    
                    tipoVehiculo = "";
                    
                }else{
                    
                    tipoVehiculo = "Automovil";
                }    
            }else if (cbMoto.isSelected()){
                
                tipoVehiculo = "Moto";
                
            }
            
            if (dcFechaBusqueda.getDate() != null) {
                
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dcFechaBusqueda.getDate();
            fecha = dateFormat.format(date);
                System.out.println(fecha);
            }
            
            placa = JTF_Placa.getText();
            
            crearTabla();
            
            buscarVehiculo();

    }//GEN-LAST:event_JButton_BuscarActionPerformed

    private void jButton_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CierreActionPerformed
        
        try {
            // TODO add your handling code here:

            fecha = dateFormat.format(date);
            sql = "SELECT SUM(valorpagado)AS total FROM vehiculos WHERE estado_vehiculo = 'No Disponible' AND horasalida_vehiculo LIKE '%" + fecha + "%'";
            
            objcon.ejecutarSQLSelect(sql);

            conexion.resultado.first();
            
            DecimalFormat df = new DecimalFormat("#.00");

            Double IngresosTotales = Double.parseDouble(conexion.resultado.getString("total"));

            JOptionPane.showMessageDialog(null, "El ingreso total del dia seleccionado es de : $ " 
                                                 + df.format(IngresosTotales) + " Pesos");
          
        }catch (SQLException | NoClassDefFoundError | NullPointerException ex){
           
           JOptionPane.showMessageDialog(null,"No se realizaron salidas el dia de hoy.");
                
           Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
            
        }


    }//GEN-LAST:event_jButton_CierreActionPerformed

    private void jButton_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reiniciarActionPerformed
        // TODO add your handling code here:
        
        rellenarTabla();
        
        JTF_Placa.setText("");
        
    }//GEN-LAST:event_jButton_reiniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButton_Buscar;
    private javax.swing.JTextField JTF_Placa;
    private javax.swing.JCheckBox cbAuto;
    private javax.swing.JCheckBox cbMoto;
    private com.toedter.calendar.JDateChooser dcFechaBusqueda;
    private javax.swing.JButton jButton_Cierre;
    private javax.swing.JButton jButton_reiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}

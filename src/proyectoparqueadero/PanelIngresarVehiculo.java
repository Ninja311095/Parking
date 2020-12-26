
package proyectoparqueadero;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Paragraph;
import Base_de_Datos.conexion;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PanelIngresarVehiculo extends javax.swing.JPanel {

    
        //VARIABLES 
    String fechaHora = "";
    String clasevehiculo = "";
    String sql;
    String current = System.getProperty("user.dir");
    String usu = "thomis";
    
       //INSTANCIAS
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date =new Date();
    conexion objbd = new conexion();
    Document documento;
    FileOutputStream archivo;
    PdfWriter writer;
    PdfDocument pdfDoc;
    ArrayList<String> lista = new ArrayList<>();
    
    public PanelIngresarVehiculo() {
        initComponents();

        objbd.crearConexion();
        
        llenaJcombo();
        espacios();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLtitulo = new javax.swing.JLabel();
        tfPropietario = new javax.swing.JTextField();
        jLplaca = new javax.swing.JLabel();
        jLpropietario = new javax.swing.JLabel();
        jLTvehiculo = new javax.swing.JLabel();
        JB_registrar = new java.awt.Button();
        jCB_tipoVehiculo = new javax.swing.JComboBox<>();
        JB_Limpiar = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jTF_ingresados = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_disponibles = new javax.swing.JTextField();
        tfPlaca = new javax.swing.JFormattedTextField();

        JLtitulo.setBackground(new java.awt.Color(255, 255, 255));
        JLtitulo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        JLtitulo.setForeground(new java.awt.Color(255, 0, 0));
        JLtitulo.setText("Modulo de Ingreso de vehiculos al parqueo");

        tfPropietario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N

        jLplaca.setText("Placa");

        jLpropietario.setText("Nombre propietario");

        jLTvehiculo.setText("Tipo de vehiculo");

        JB_registrar.setBackground(new java.awt.Color(255, 51, 0));
        JB_registrar.setForeground(new java.awt.Color(255, 255, 255));
        JB_registrar.setLabel("Registrar");
        JB_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_registrarActionPerformed(evt);
            }
        });

        jCB_tipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JB_Limpiar.setBackground(new java.awt.Color(255, 51, 0));
        JB_Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        JB_Limpiar.setLabel("Limpiar Campos");
        JB_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_LimpiarActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Ingresado");

        jTF_ingresados.setEditable(false);

        jLabel2.setText("Total Disponibles");

        jTF_disponibles.setEditable(false);
        jTF_disponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_disponiblesActionPerformed(evt);
            }
        });

        try {
            tfPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfPlaca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jTF_disponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jTF_ingresados, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLTvehiculo)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLpropietario)
                    .addComponent(jLplaca)
                    .addComponent(JLtitulo)
                    .addComponent(jCB_tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(JB_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(JLtitulo)
                .addGap(18, 18, 18)
                .addComponent(jLplaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLpropietario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTF_ingresados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTF_disponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLTvehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void llenaJcombo(){
        
        jCB_tipoVehiculo.removeAllItems();
        lista = conexion.llenacombo();
        
        lista.forEach(e -> {
            jCB_tipoVehiculo.addItem(e);
        });
    }
    
    public void crearPDF(String placa,String propietario,String tVehiculo, String fecha) throws FileNotFoundException, IOException{
        
            archivo = new FileOutputStream(current + "/reportes/" + propietario + ".pdf");
            writer = new PdfWriter(archivo);
            pdfDoc = new PdfDocument(writer);
            documento = new Document(pdfDoc, PageSize.A5);
            
            File imageFile = new File(current +"/src/img/logo.jpg");
            java.awt.Image image = ImageIO.read(imageFile);
            ImageData imageData = ImageDataFactory.create(image, null);
            Image pdfImg = new Image(imageData);
            
            pdfDoc.addNewPage();

            Paragraph para = new Paragraph ("Recibo Parqueo");
            para.setBorder(Border.NO_BORDER);
            para.setBold();

            Paragraph para1 = new Paragraph ("Placa vehiculo: "+ placa);
            Paragraph para2 = new Paragraph ("Nombre del propietario: "+ propietario);
            Paragraph para3 = new Paragraph ("Hora de ingreso: "+fecha);
            
            para.setTextAlignment(TextAlignment.CENTER);
            para1.setTextAlignment(TextAlignment.CENTER);
            para2.setTextAlignment(TextAlignment.CENTER);
            para3.setTextAlignment(TextAlignment.CENTER);
            pdfImg.setTextAlignment(TextAlignment.CENTER);

            documento.add(pdfImg);
            documento.add(para);
            documento.add(para1);
            documento.add(para2);
            documento.add(para3); 
            documento.close();
            
             System.out.println("PDF Created");
             
             
             try {

		if ((new File(current + "/reportes/" + propietario + ".pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler " + current + "/reportes/"+ propietario + ".pdf");
			p.waitFor();
				
		} else {

			System.out.println("File is not exists");

		}
                
                try {
                        File path = new File (current + "/reportes/"+ propietario + ".pdf");
                        
                        Desktop.getDesktop().open(path);
                        
                   }catch (IOException ex) {
                       
                       JOptionPane.showMessageDialog(null,"Error al abrir el Documento","Error",JOptionPane.ERROR_MESSAGE);
                    }

		System.out.println("Done");

  	  } catch (IOException | InterruptedException ex) {
	  }
    } 
    
    private void JB_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_registrarActionPerformed

        fechaHora = dateFormat.format(date);
        
        clasevehiculo = (String) jCB_tipoVehiculo.getSelectedItem();
        
         sql = "INSERT INTO vehiculos (placa_vehiculo, propietario_vehiculo,tipo_vehiculo,horaentrada_vehiculo,estado_vehiculo,usuario) VALUES ('"
                + tfPlaca.getText() + "','" + tfPropietario.getText() + "','" + clasevehiculo + "','"
                + fechaHora + "','Disponible','" + usu + "')";
        
        
        try {
            
            objbd.ejecutarSQL(sql);
            boolean first = conexion.resultado.first();
            
            if(first){
                
                crearPDF(tfPlaca.getText(), tfPropietario.getText(), clasevehiculo, fechaHora);
            
                    
                tfPlaca.setText("");
                tfPropietario.setText("");
                clasevehiculo = "";

                JOptionPane.showMessageDialog(null,"Vehiculo registrado exitosamente");
                
                sql = "UPDATE espacios SET total_ocupado = total_ocupado + 1, total_disponibles = total_espacios - total_ocupado";
                objbd.ejecutarSQL(sql);
                
                espacios();
            }
           
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null, "Error al crear PDF", "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (IOException | SQLException ex) {
            
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     
    }//GEN-LAST:event_JB_registrarActionPerformed

    private void JB_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LimpiarActionPerformed
        // TODO add your handling code here:
        
        tfPlaca.setText("");
        tfPropietario.setText("");
        clasevehiculo = "";
    }//GEN-LAST:event_JB_LimpiarActionPerformed

    private void jTF_disponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_disponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_disponiblesActionPerformed

    private void espacios(){
        
        try {
            objbd.ejecutarSQLSelect("SELECT * FROM  espacios WHERE id_espacios = 1");
            
            conexion.resultado.first();
            
            String ingresados = conexion.resultado.getString("total_ocupado");
            String disponibles = conexion.resultado.getString("total_disponibles");
            
            jTF_disponibles.setText(disponibles);
            jTF_ingresados.setText(ingresados);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_Limpiar;
    private java.awt.Button JB_registrar;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JComboBox<String> jCB_tipoVehiculo;
    private javax.swing.JLabel jLTvehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLplaca;
    private javax.swing.JLabel jLpropietario;
    private javax.swing.JTextField jTF_disponibles;
    private javax.swing.JTextField jTF_ingresados;
    private javax.swing.JFormattedTextField tfPlaca;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}

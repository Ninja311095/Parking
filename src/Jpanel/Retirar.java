/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpanel;

import Base_de_Datos.conexion;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import com.mxrck.autocompleter.*;
import java.util.ArrayList;

/**
 *
 * @author Principal
 */
public class Retirar extends javax.swing.JPanel {

    /**
     * Creates new form Retirar
     */
    
    //INSTANCIAS
    conexion objcon = new conexion();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Document documento;
    FileOutputStream archivo;
    PdfWriter writer;
    PdfDocument pdfDoc;
    Usuario miUsuario = Usuario.getUsuario();
    TextAutoCompleter tAc;
    ArrayList <String>lista = new ArrayList<>();
    
    //VARIABLES
    String fechaHora, horaentrada,sql;
    String propietario;
    String tipoVehiculo;
    String usuario;
    Date Datehoraentrada;
    int horasACobrar;
    int valorAPagar;
    int confirmacion;
    int tarifa,tarifaMinima;
    int respuesta=1;
    String current = System.getProperty("user.dir");
    
    public Retirar() {
        initComponents();
        
        objcon.crearConexion();
        autoCompleted();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPlacaRetiro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JB_Retirar = new java.awt.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(453, 400));

        tfPlacaRetiro.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        tfPlacaRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlacaRetiroActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Modulo de salida de vehiculos del parqueo");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Introuzca la placa");

        JB_Retirar.setBackground(new java.awt.Color(0, 51, 255));
        JB_Retirar.setForeground(new java.awt.Color(255, 255, 255));
        JB_Retirar.setLabel("Retirar");
        JB_Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RetirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**METODO PARA CREAR FACTURA PDF
     @param placa La placa del vehiculo
     @param propietario El nombre del propietario
     @param tVehiculo El tipo de vihiculo ya sea automovil o motocicleta, etc
     @param fecha La fecha en que se realizo la entrada del vehiculo
     @param fechaSalida La fecha en que se retira el vehiculo
     @param pago Pago a realizar por el tiempo estacionado*/
    public void crearPDF(String placa,String propietario,String tVehiculo, String fecha,String fechaSalida, int pago) throws FileNotFoundException, IOException{
        
            archivo = new FileOutputStream(current + "/facturas/" + propietario + ".pdf");
            writer = new PdfWriter(archivo);
            pdfDoc = new PdfDocument(writer);
            documento = new Document(pdfDoc, PageSize.A5);
            
            //AGREGAMOS LA IMAGEN AL DOCUMENTO 
            File imageFile = new File(current + "/src/img/logo.jpg");
            java.awt.Image image = ImageIO.read(imageFile);
            ImageData imageData = ImageDataFactory.create(image, null);
            Image pdfImg = new Image(imageData);
            
            pdfDoc.addNewPage();

            Paragraph para = new Paragraph ("Recibo de Pago Estacionamiento");
            para.setBorder(Border.NO_BORDER);
            para.setBold();

            Paragraph para1 = new Paragraph ("Placa vehiculo: "+ placa);
            Paragraph para2 = new Paragraph ("Nombre del propietario: "+ propietario);
            Paragraph para3 = new Paragraph ("Hora de ingreso: "+fecha);
            Paragraph para4 = new Paragraph ("Hora de Salida: "+fechaSalida);
            Paragraph para5 = new Paragraph ("Pago Realizado: "+pago);
            
            para.setTextAlignment(TextAlignment.CENTER);
            para1.setTextAlignment(TextAlignment.CENTER);
            para2.setTextAlignment(TextAlignment.CENTER);
            para3.setTextAlignment(TextAlignment.CENTER);
            para4.setTextAlignment(TextAlignment.CENTER);
            para5.setTextAlignment(TextAlignment.CENTER);
            pdfImg.setTextAlignment(TextAlignment.CENTER);

            documento.add(pdfImg);
            documento.add(para);
            documento.add(para1);
            documento.add(para2);
            documento.add(para3); 
            documento.add(para4); 
            documento.add(para5); 
            documento.close();
             
             
             try {

		if ((new File(current +"/facturas/" + propietario + ".pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler " + current + "/facturas/"+ propietario + ".pdf");
			p.waitFor();
				
		} else {

			System.out.println("File is not exists");

		}
                
                try {
                        File path = new File ( current + "/facturas/"+ propietario + ".pdf");
                        
                        Desktop.getDesktop().open(path);
                        
                   }catch (IOException ex) {
                      
                    }

  	  } catch (IOException | InterruptedException ex) {
              
	  }
    }
    
    private void autoCompleted(){
        
        String consulta = "SELECT * from vehiculos";
        String dato = "placa_vehiculo";
        
        lista = conexion.llenacombo(consulta, dato);
        tAc = new TextAutoCompleter(tfPlacaRetiro);
        
        lista.forEach(e -> {
            tAc.addItem(e);
        });
    }
    
    public void obtenTarifa(String tipo_Vehiculo){
        
        try {
            
            sql = "SELECT tarifa_vehiculo,tarifa_minima FROM categoriavehiculo WHERE tipo_vehiculo = '" + tipo_Vehiculo + "'";
            objcon.ejecutarSQLSelect(sql);
            conexion.resultado.first();
            
            tarifa = conexion.resultado.getInt(1);
            tarifaMinima = conexion.resultado.getInt(2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void JB_RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RetirarActionPerformed
            
            fechaHora = dateFormat.format(date);
            usuario = miUsuario.getUsu();
        try {
            // TODO add your handling code here:
            
            sql = "SELECT horaentrada_vehiculo, tipo_vehiculo,propietario_vehiculo from vehiculos WHERE placa_vehiculo ='" + tfPlacaRetiro.getText() + "' AND estado_vehiculo = 'Disponible'";
            objcon.ejecutarSQLSelect(sql);
            
            conexion.resultado.first();
            
            //OBTENCION DE VALORES PARA LA CONFIRMACION
            propietario = conexion.resultado.getString(3);
            horaentrada = conexion.resultado.getString(1);
            tipoVehiculo = conexion.resultado.getString(2);
            obtenTarifa(tipoVehiculo);
            
            confirmacion = JOptionPane.showConfirmDialog(null, "Validación de datos\n\n Propietario: " + propietario + 
                                                               "\n Tipo Vehiculo: " + tipoVehiculo + "\n Fecha Entrada: " + horaentrada, "Confirmación", JOptionPane.YES_NO_OPTION);
        
            if(confirmacion == 0){
                
                
                Datehoraentrada = dateFormat.parse(horaentrada);
                horasACobrar = (int) ((date.getTime()-Datehoraentrada.getTime())/60000)/60;
                valorAPagar = horasACobrar * tarifa;
                
                if (valorAPagar < tarifaMinima){
                    
                    valorAPagar = tarifaMinima;
                }

                sql = "UPDATE vehiculos SET horasalida_vehiculo='" + fechaHora + "',estado_vehiculo= 'No Disponible', valorpagado= " 
                      + valorAPagar + ",usuario_salida ='" + usuario +"' WHERE placa_vehiculo='" + tfPlacaRetiro.getText() + "' AND estado_vehiculo='Disponible'";

                objcon.ejecutarSQL(sql);

                respuesta = JOptionPane.showConfirmDialog(null,"Valor a pagar:  $"+valorAPagar+"'\nDesea Imprimir Recibo","Salida de vehiculo",JOptionPane.YES_NO_OPTION);
         
                sql = "UPDATE espacios SET total_ocupado = total_ocupado - 1, total_disponibles = total_espacios - total_ocupado";
                objcon.ejecutarSQL(sql);
            }
            
            if(respuesta == 0){
                
                crearPDF(tfPlacaRetiro.getText(), propietario, tipoVehiculo, horaentrada, fechaHora, valorAPagar);
            }
            
            tfPlacaRetiro.setText("");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el parqueao, por favor revise la placa ingresada");
            
            Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ParseException | IOException ex) {
            
            Logger.getLogger(Retirar.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_JB_RetirarActionPerformed

    private void tfPlacaRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlacaRetiroActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tfPlacaRetiroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_Retirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfPlacaRetiro;
    // End of variables declaration//GEN-END:variables
}
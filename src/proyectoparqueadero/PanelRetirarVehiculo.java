/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueadero;

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

/**
 *
 * @author Principal
 */
public class PanelRetirarVehiculo extends javax.swing.JPanel {

    /**
     * Creates new form PanelRetirarVehiculo
     */
    
    //INSTANCIAS
    conexion objcon = new conexion();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Document documento;
    FileOutputStream archivo;
    PdfWriter writer;
    PdfDocument pdfDoc;
    
    //VARIABLES
    String fechaHora, horaentrada,sql;
    Date Datehoraentrada;
    int horasACobrar;
    int valorAPagar;
    int confirmacion;
    String propietario;
    String tipoVehiculo;
    int respuesta;
    String current = System.getProperty("user.dir");
    
    public PanelRetirarVehiculo() {
        initComponents();
        
        objcon.crearConexion();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPlacaRetiro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JB_Retirar = new java.awt.Button();

        setPreferredSize(new java.awt.Dimension(453, 400));

        tfPlacaRetiro.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        tfPlacaRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlacaRetiroActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Modulo de salida de vehiculos del parqueadero");

        jLabel2.setText("Placa");

        JB_Retirar.setBackground(new java.awt.Color(255, 51, 0));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //METODO PARA CREAR FACTURA PDF
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
            
             System.out.println("PDF Created");
             
             
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
                       
                        ex.printStackTrace();
}

		System.out.println("Done");

  	  } catch (IOException | InterruptedException ex) {
	  }
    }
    
    private void JB_RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RetirarActionPerformed
            
            fechaHora = dateFormat.format(date);
            
        try {
            // TODO add your handling code here:
            
            sql = "SELECT horaentrada, tipovehiculo,propietario from vehiculos WHERE placa ='" + tfPlacaRetiro.getText() + "' AND estado = 'Disponible'";
            objcon.ejecutarSQLSelect(sql);
            
            objcon.resultado.first();
            
            //OBTENCION DE VALORES PARA LA CONFIRMACION
            propietario = objcon.resultado.getString(3);
            horaentrada = objcon.resultado.getString(1);
            tipoVehiculo = objcon.resultado.getString(2);
            
            confirmacion = JOptionPane.showConfirmDialog(null, "Validación de datos\n\n Propietario: " + propietario + 
                                                               "\n Tipo Vehiculo: " + tipoVehiculo + "\n Fecha Entrada: " + horaentrada, "Confirmación", JOptionPane.YES_NO_OPTION);
        
            if(confirmacion == 0){
                
                
                Datehoraentrada = dateFormat.parse(horaentrada);
                horasACobrar = (int) ((date.getTime()-Datehoraentrada.getTime())/60000)/60;

                System.out.println(horasACobrar);
                
                if(objcon.resultado.getString(2).equals("Automovil")){

                    valorAPagar=horasACobrar*10;

                }else if(objcon.resultado.getString(2).equals("Motocicleta")){

                     valorAPagar=horasACobrar*5;

                }


                sql = "UPDATE vehiculos SET horasalida='" + fechaHora + "',estado= 'No Disponible', valorpagado= " 
                      + valorAPagar + " WHERE placa='" + tfPlacaRetiro.getText() + "' AND estado='Disponible'";

                objcon.ejecutarSQL(sql);

                respuesta = JOptionPane.showConfirmDialog(null,"Valor a pagar:  $"+valorAPagar+"'\nDesea Imprimir Recibo","Salida de vehiculo",JOptionPane.YES_NO_OPTION);
         
            }
            
            if(respuesta == 0){
                
                crearPDF(tfPlacaRetiro.getText(), propietario, tipoVehiculo, horaentrada, fechaHora, valorAPagar);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el parqueadero, por favor revise la placa ingresada");
            
            Logger.getLogger(PanelRetirarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ParseException ex) {
            
            Logger.getLogger(PanelRetirarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            
            Logger.getLogger(PanelRetirarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
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
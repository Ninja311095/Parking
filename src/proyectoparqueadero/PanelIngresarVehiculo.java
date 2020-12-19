
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    
       //INSTANCIAS
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date =new Date();
    conexion objbd = new conexion();
    Document documento;
    FileOutputStream archivo;
    PdfWriter writer;
    PdfDocument pdfDoc;
    
    public PanelIngresarVehiculo() {
        initComponents();

        objbd.crearConexion();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JLtitulo = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        tfPropietario = new javax.swing.JTextField();
        jLplaca = new javax.swing.JLabel();
        jLpropietario = new javax.swing.JLabel();
        jLTvehiculo = new javax.swing.JLabel();
        rbMoto = new javax.swing.JRadioButton();
        rbAuto = new javax.swing.JRadioButton();
        JB_registrar = new java.awt.Button();

        JLtitulo.setBackground(new java.awt.Color(255, 255, 255));
        JLtitulo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        JLtitulo.setForeground(new java.awt.Color(255, 0, 0));
        JLtitulo.setText("Modulo de Ingreso de vehiculos al parqueo");

        tfPlaca.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N

        tfPropietario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N

        jLplaca.setText("Placa");

        jLpropietario.setText("Nombre propietario");

        jLTvehiculo.setText("Tipo de vehiculo");

        buttonGroup1.add(rbMoto);
        rbMoto.setText("Motocicleta");

        buttonGroup1.add(rbAuto);
        rbAuto.setText("Automovil");

        JB_registrar.setBackground(new java.awt.Color(255, 51, 0));
        JB_registrar.setForeground(new java.awt.Color(255, 255, 255));
        JB_registrar.setLabel("Registrar");
        JB_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JB_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTvehiculo)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLpropietario)
                    .addComponent(jLplaca)
                    .addComponent(JLtitulo))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(rbMoto)
                .addGap(10, 10, 10)
                .addComponent(rbAuto)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(JLtitulo)
                .addGap(43, 43, 43)
                .addComponent(jLplaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLpropietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLTvehiculo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAuto)
                    .addComponent(rbMoto))
                .addGap(26, 26, 26)
                .addComponent(JB_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void crearPDF(String placa,String propietario,String tVehiculo, String fecha) throws FileNotFoundException, IOException{
        
            archivo = new FileOutputStream("C:/Users/thomy/Desktop/reportes/" + propietario + ".pdf");
            writer = new PdfWriter(archivo);
            pdfDoc = new PdfDocument(writer);
            documento = new Document(pdfDoc, PageSize.A5);
            
            
            File imageFile = new File("C:/Users/thomy/Documents/Materias/Ing de Software I/Software del Proyecto-Parqueador/Proyecto parqueadero java/ProyectoParqueadero/src/img/logo.jpg");
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

		if ((new File("C:/Users/thomy/Desktop/reportes/" + propietario + "pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler C:/Users/thomy/Desktop/reportes/"+ propietario + "pdf");
			p.waitFor();
				
		} else {

			System.out.println("File is not exists");

		}

		System.out.println("Done");

  	  } catch (IOException | InterruptedException ex) {
	  }
    } 
    
    private void JB_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_registrarActionPerformed

        fechaHora = dateFormat.format(date);
        
        if (rbAuto.isSelected()) {
            clasevehiculo = "Automovil";
        }
        if (rbMoto.isSelected()) {
            clasevehiculo = "Motocicleta";
        }
        
        String sql = "INSERT INTO vehiculos (placa, propietario,tipovehiculo,horaentrada,estado) VALUES ('"
                + tfPlaca.getText() + "','" + tfPropietario.getText() + "','" + clasevehiculo + "','"
                + fechaHora + "','Disponible')";
        
        objbd.ejecutarSQL(sql);
        
        try {
            
            crearPDF(tfPlaca.getText(), tfPropietario.getText(), clasevehiculo, fechaHora);
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tfPlaca.setText("");
        tfPropietario.setText("");
        clasevehiculo = "";
        
        JOptionPane.showMessageDialog(null,"Vehiculo registrado exitosamente");
     
    }//GEN-LAST:event_JB_registrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_registrar;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLTvehiculo;
    private javax.swing.JLabel jLplaca;
    private javax.swing.JLabel jLpropietario;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}

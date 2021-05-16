/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_de_Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thomis
 */
public class conexion {

    public static Connection conexionUP = null;
    private String url;
    private String usuario;
    private String clave;
    public static Statement sentencia;
    public static ResultSet resultado;

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion() {

        url = "jdbc:mysql://localhost/bdparqueo?useSSL=false&serverTimezone=UTC";
        usuario = "root";
        clave = "";
        try {

            conexionUP = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al conectar con el servidor", "Error critico", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar la instrucción SELECT
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     *
     */
    public ResultSet ejecutarSQLSelect(String sql) {

        try {

            PreparedStatement pSentencia = conexionUP.prepareStatement(sql);
            resultado = pSentencia.executeQuery();

        } catch (SQLException ex) {
            return null;
        }

        return resultado;

    }//fin resulset select

    /**
     *
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     * param sql Cadena que contiene la instrucción SQL a ejecutar
     *
     * @param sql
     * @return estado regresa el estado de la ejecución, true(éxito) o
     * false(error)
     *
     */
    public ResultSet ejecutarSQL(String sql) {
        try {
            PreparedStatement pSentencia = conexionUP.prepareStatement(sql);

            pSentencia.executeUpdate();

        } catch (SQLException ex) {

            //JOptionPane.showMessageDialog(null,"Error al registrar vehiculo" + ex);
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);

        }

        return resultado;

    }//fin resultset update

    public static ArrayList<String> llenacombo(String consulta,String dato) {

        ArrayList<String> lista;
        lista = new ArrayList<>();
        
        try {

            PreparedStatement pSentencia = conexionUP.prepareStatement(consulta);
            resultado = pSentencia.executeQuery();

            while (resultado.next()) {

                lista.add(resultado.getString(dato));
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Connection getConexion() {
        return conexionUP;

    }

    public static void cierraCesion(){
        
        if (conexionUP !=null){
         
            try {
                conexionUP.close();
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}//fin clase  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpanel;

/**
 *
 * @author thomy
 */
public class Usuario {

    private String usu;
    private static Usuario miUsuario;


    private Usuario() {

    }
    
    public synchronized static Usuario getUsuario() {

        if (miUsuario == null) {

            miUsuario = new Usuario();
            
        }

        return miUsuario;
    }

    public String getUsu() {

        return usu;
    }

    public void setUsu(String usu) {

        this.usu = usu;
    }

}

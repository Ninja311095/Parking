/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueadero;

import JDialog.Login;
/**
 *
 * @author thomy
 */
public class Main {
    
    public static void main(String [] args){

        login();
 
    }
    
    public static void login(){
        
    Login login = new Login(null, true);
    login.setVisible(true);
    
    }
    
}

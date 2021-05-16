/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpanel;

import junit.framework.TestCase;

/**
 *
 * @author AnThOnY
 */
public class UsuarioTest extends TestCase {
    
    public UsuarioTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getUsuario method, of class Usuario.
     */
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Usuario expResult = null;
        Usuario result = Usuario.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result !=expResult){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of getUsu method, of class Usuario.
     */
    public void testGetUsu() {
        System.out.println("getUsu");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getUsu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         if (result !=expResult){
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of setUsu method, of class Usuario.
     */
    public void testSetUsu() {
        System.out.println("setUsu");
        String usu = "";
        Usuario instance = null;
        instance.setUsu(usu);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}

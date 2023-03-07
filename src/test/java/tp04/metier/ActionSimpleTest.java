/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tp04.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ch999
 */
public class ActionSimpleTest {
    
    public ActionSimpleTest() {
    }

    @Test
    public void testCreationActionSimple() {
        final String actionName = "First Action"; 
        final ActionSimple as = new ActionSimple(actionName);
        final String getLabel = as.getLibelle();
        
        Assertions.assertEquals(actionName, getLabel,"La label de l'action doit etre celui fournit au constrcteur");
    }
    
        @Test
    public void testGetCoursParJour() {
        final Jour j = new Jour(2023,100); 
        final ActionSimple as = new ActionSimple("A1");
        as.enrgCours(j, 5.80f);
        
        final float rs = as.getCours(j);
        
        Assertions.assertEquals(5.80f, rs,"La label de l'action doit etre celui fournit au constrcteur");
    }
    
    
    @Test
    public void testGetCoursPlusHautParJour() {
        final Jour j1 = new Jour(2023,100); 
        final Jour j2 = new Jour(2022,110); 
        final Jour j3 = new Jour(2023,234); 
        
        final ActionSimple as = new ActionSimple("A1");
       
        as.enrgCours(j1, 6.34f);
        as.enrgCours(j2, 7.00f);
        as.enrgCours(j3, 5.90f);
        
        final float rs = as.getCoursPlusHaut();
        
        Assertions.assertEquals(7.00f, rs,"La label de l'action doit etre celui fournit au constrcteur");
    }
    
     @Test
    public void testGetCoursPlusBasParJour() {
        final Jour j1 = new Jour(2023,100); 
        final Jour j2 = new Jour(2022,110); 
        final Jour j3 = new Jour(2023,234); 
        
        final ActionSimple as = new ActionSimple("A1");
       
        as.enrgCours(j1, 6.34f);
        as.enrgCours(j2, 7.00f);
        as.enrgCours(j3, 5.90f);
        
        final float rs = as.getCoursPlusBas();
        
        Assertions.assertEquals(5.90f, rs,"La label de l'action doit etre celui fournit au constrcteur");
    }
}

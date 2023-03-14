/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tp04.metier.ActionSimple.Cours;

/**
 *
 * @author ch999
 */
public class ActionSimpleTest {
    
    public ActionSimpleTest() {
    }

    @Test
    void testCreationActionSimple() {
        final String actionName = "First Action"; 
        final ActionSimple as = new ActionSimple(actionName);
        final String getLabel = as.getLibelle();
        
        Assertions.assertEquals(actionName, getLabel,"La label de l'action doit etre celui fournit au constrcteur");
    }
    
        @Test
    void testGetCoursParJour() {
        final Jour j = new Jour(2023,100); 
        final ActionSimple as = new ActionSimple("A1");
        as.enrgCours(j, 5.80f);
        
        final float rs = as.getCours(j);
        
        Assertions.assertEquals(5.80f, rs,"La label de l'action doit etre celui fournit au constrcteur");
    }
    
    
    @Test
    void testGetCoursPlusHautParJour() {
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
    void testGetCoursPlusBasParJour() {
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
    
    @Test
    void testEvolutionAction() {
        final ActionSimple as = new ActionSimple("A1");   
        final Jour jourDebut = new Jour(2023,101); 
        final Jour jourFin = new Jour(2023,103); 
        
        final Jour j1 = new Jour(2022,100); 
        final Jour j2 = new Jour(2022,108); 
        final Jour j3 = new Jour(2023,100);
        final Jour j4 = new Jour(2023,101); 
        final Jour j5 = new Jour(2023,102); 
        final Jour j6 = new Jour(2023,103);
        final Jour j7 = new Jour(2023,104);
        final Jour j8 = new Jour(2024,104);
     
        as.enrgCours(j1, 6.45f);
        as.enrgCours(j2, 7.00f);
        as.enrgCours(j3, 6.34f);
        as.enrgCours(j4, 7.14f);
        as.enrgCours(j5, 6.99f);
        as.enrgCours(j6, 7.12f);
        as.enrgCours(j7, 6.64f);
        as.enrgCours(j8, 7.70f);
        
        final Map<Jour, ActionSimple.Cours> m  = as.getEvolution(jourDebut, jourFin);
        final Map<Jour, ActionSimple.Cours> mTest=new HashMap<>();
        mTest.put(j4, new Cours(j4,7.14f));
        mTest.put(j5, new Cours(j5,6.99f));
        mTest.put(j6, new Cours(j6,7.12f));
        Assertions.assertNotNull(m,"Le map n'est pas NULL"); 
        Assertions.assertEquals(6.99f, m.get(j5).getValeur(),"Equal");
       Assertions.assertEquals(6.99f, m.get(j5).getValeur(),"Equal");
    }
    @Test
    void testEvoPourcentage() {
        final ActionSimple as = new ActionSimple("A1");  
        
        final Jour j1 = new Jour(2022,100); 
        final Jour j2 = new Jour(2022,108); 
        
        as.enrgCours(j1, 5f);
        as.enrgCours(j2, 6f);

        final double result  = as.getPourcentageEvo(j1, j2);
        Assertions.assertEquals(20f,result,"Equal");

        
    }
    
}

/*
 * Copyright 2023 luokun.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author luokun
 */
class ActionComposeeTest {
    public ActionComposeeTest() {
        
    }
//    @Before
//    public void setUp() {
//    }
//    @After
//    public void tearDown() {
//    }
//    @Test
//    public void shouldPass() {
//    }
//    @ParameterizedTest
//    @MethodSource("someMethods")
//    public void shouldPassOrFailWithParameters() {
//    }
//    @Test
//    @Ignore
//    public void ignoredTest() {
//    }
    
    @org.junit.jupiter.api.Test
    public void testPourcentageComposee() {
        final String NameA = "franceTV";
        final ActionSimple as = new ActionSimple(NameA);
        final String NameAC = "France";
        final ActionComposee ac = new ActionComposee(NameAC);
        final float p = 0.3F; 
        ac.enrgComposition(as, p);
        final float getPourcentage = ac.getPourcentage(as);
        
        Assertions.assertEquals(p,getPourcentage,"Le pourcentage est equal.");
        
    }
    
    
    @org.junit.jupiter.api.Test
    public void testValeur() {
        final String NameA = "franceTV";
        final String NameA1 = "franceMTV";
        
        final ActionSimple as = new ActionSimple(NameA);
        final ActionSimple as1 = new ActionSimple(NameA1);
        final String NameAC = "France";
        final ActionComposee ac = new ActionComposee(NameAC);
        final float p = 0.3F; 
        final float p1 = 0.4F; 
        final Jour j1 = new Jour(2023,1);
        
        as.enrgCours(j1, 23.5F);
        as1.enrgCours(j1, 24.5F);
        
        ac.enrgComposition(as, p);
        ac.enrgComposition(as1, p1);
        
        final float Cout = 23.5F;

//        final float Cout = 23.5f*p + 24.5f*p1;
        final float getCout = as.valeur(j1);
        
        Assertions.assertEquals(Cout,getCout,"Le valeur est equal.");
        
    }
    
    
    
    @org.junit.jupiter.api.Test
    public void testComposition() {
        final String NameA = "franceTV";
        final String NameA1 = "franceMTV";
        final ActionSimple as = new ActionSimple(NameA);
        final ActionSimple as1 = new ActionSimple(NameA1);
        final String NameAC = "France";
        final ActionComposee ac = new ActionComposee(NameAC);
        final float p = 0.3F; 
        final float p1 = 0.4F; 
        ac.enrgComposition(as, p);
        ac.enrgComposition(as1, p1);
//        final String = ac.connaitrecComposition();
//        
//        Assertions.assertEquals(p,getPourcentage,"Le pourcentage est =");
//        
        Map<ActionSimple, Float> map = new HashMap();
        map.put(as, p);
        map.put(as1, p1);
        
        final Map m = ac.getMap();

        Assertions.assertEquals(map,m,"La map est equal.");

    }




    
}

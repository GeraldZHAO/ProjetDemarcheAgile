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
public class ActionComposeeTest {
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
        final float p = 0.3f; 
        ac.enrgComposition(as, p);
        final float getPourcentage = ac.getPourcentage(as);
        
        Assertions.assertEquals(p,getPourcentage,"Le pourcentage est =");
        
    }
    
    
    @org.junit.jupiter.api.Test
    public void testValeur() {
        final String NameA = "franceTV";
        final String NameA1 = "franceMTV";
        
        final ActionSimple as = new ActionSimple(NameA);
        final ActionSimple as1 = new ActionSimple(NameA1);
        final String NameAC = "France";
        final ActionComposee ac = new ActionComposee(NameAC);
        final float p = 0.3f; 
        final float p1 = 0.4f; 
        final Jour j1 = new Jour(2023,1);
        
        as.enrgCours(j1, 23.5f);
        as1.enrgCours(j1, 24.5f);
        
        ac.enrgComposition(as, p);
        ac.enrgComposition(as1, p1);
        
        final float Cout = 23.5f;

//        final float Cout = 23.5f*p + 24.5f*p1;
        final float getCout = as.valeur(j1);
        
        Assertions.assertEquals(Cout,getCout,"Le valeur est =");
        
    }
    
    
    
//    @org.junit.jupiter.api.Test
//    public void testComposition() {
//        final String NameA = "franceTV";
//        final String NameA1 = "franceMTV";
//        final ActionSimple as = new ActionSimple(NameA);
//        final ActionSimple as1 = new ActionSimple(NameA1);
//        final String NameAC = "France";
//        final ActionComposee ac = new ActionComposee(NameAC);
//        final float p = 0.3f; 
//        final float p1 = 0.4f; 
////        ac.enrgComposition(as, p);
////        ac.enrgComposition(as1, p1);
////        final String = ac.connaitrecComposition();
////        
////        Assertions.assertEquals(p,getPourcentage,"Le pourcentage est =");
////        
//        Map<ActionSimple, Float> map = new HashMap();
//        map.put(as, p);
//        map.put(as1, p1);
//        
//        final Map m = ac.getMap();
//
//        //All passed / true
//
//        //1. Test equal, ignore order
////        Assertions.assertEquals(ac,m,"La composition est =");
//        assertThat(map, is(m));
//
////        //2. Test size
//        assertThat(map.size(), is(2));
////
////        //3. Test map entry, best!
////        assertThat(map, IsMapContaining.hasEntry("n", "node"));
////
////        assertThat(map, not(IsMapContaining.hasEntry("r", "ruby")));
////
////        //4. Test map key
////        assertThat(map, IsMapContaining.hasKey("j"));
////
////        //5. Test map value
////        assertThat(map, IsMapContaining.hasValue("node"));
//
//    
//    }




    
}

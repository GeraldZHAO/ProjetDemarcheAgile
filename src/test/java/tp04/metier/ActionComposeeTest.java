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
    public void testPourcentageComposee() {
        final String NameA = "franceTV";
        final ActionSimple as = new ActionSimple(NameA);
        final String NameAC = "France";
        final ActionComposee ac = new ActionComposee(NameAC);
        final float p = 0.3f; 
        ac.enrgComposition(as, p);
        final float getPourcentage = ac.getPourcentage(as);
        
        Assertions.assertEquals(p,getPourcentage,"Le pourcentage est =");
        
        
//    // Action         
//    .push(42);
//    
//    
//   
//    int actual = stack.pop();
//
//    // Assert
//    assertEquals(42, actual);
//
//    
//    }
//    
//    public void testPushReturnsPopSame(){
//    // Arrange
//    Stack stack = new Stack();
//
//    // Action         
//    stack.push(0);
//    int actual = stack.pop();
//
//    // Assert
//    assertEquals(0, actual);
    }




    
}

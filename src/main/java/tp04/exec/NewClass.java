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
package tp04.exec;

import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Jour;

/**
 *
 * @author luokun
 */
public class NewClass {
      public static void main(String[] args) {
           String NameA = "franceTV";
         String NameA1 = "franceMTV";
        
        ActionSimple as = new ActionSimple(NameA);
        ActionSimple as1 = new ActionSimple(NameA1);
         String NameAC = "France";
         ActionComposee ac = new ActionComposee(NameAC);
         float p = 0.3f; 
         float p1 = 0.4f; 
        Jour j1 = new Jour(2023,1);
        
        as.enrgCours(j1, 23.5f);
        as1.enrgCours(j1, 24.5f);
        
        ac.enrgComposition(as, p);
        ac.enrgComposition(as1, p1);
        
       float Cout = 23.5f;

//        final float Cout = 23.5f*p + 24.5f*p1;
        System.out.println(ac.valeur(j1));
        
      }
}

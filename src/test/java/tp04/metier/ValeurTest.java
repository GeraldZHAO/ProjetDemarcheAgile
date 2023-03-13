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

import org.junit.jupiter.api.Assertions;

/**
 *
 * @author luokun
 */
public class ValeurTest {
    //l'action de le cour maximum de la journee
    
    @org.junit.jupiter.api.Test
    public void testMaxCours(){
       
   
        // init des objets metiers Jour
        final Jour j1 = new Jour(2014, 1);
        
        // creation d'actions simples et composée
        final ActionSimple bnp = new ActionSimple("BNP");
        final ActionSimple axa = new ActionSimple("AXA");
        final ActionComposee bqAss = new ActionComposee("Banque-Assurance");
        // enrg de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);
        axa.enrgCours(j1, 200);
        bnp.enrgCours(j1, 100);
        
        j1.enregistreAction(axa);
        j1.enregistreAction(bnp);
        j1.enregistreAction(bqAss);
        
        final Action result = j1.plusEleve();
        
         Assertions.assertEquals(result,axa,"le resultat d'action plus cher est la meme");
        
    }
}

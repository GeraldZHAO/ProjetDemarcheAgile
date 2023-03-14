/*
 * Copyright 2023 h.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author h
 */
class US21Test {

    @Test
    public void testActionPlusImportant() {
        Portefeuille p = new Portefeuille();
        Jour j2 = new Jour(2014, 2);

        //metter les actions dans le portefeuille
        ActionSimple bnp = new ActionSimple("BNP");
        ActionSimple axa = new ActionSimple("AXA");
        ActionComposee bqAss = new ActionComposee("Banque-Assurance");
        // enrg de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);

        bnp.enrgCours(j2, 10F);
        axa.enrgCours(j2, 10F);

        p.acheter(axa, 2);
        p.acheter(bnp, 1);
        p.acheter(bqAss, 1);

        //test la result de valeur si bien correspond le resultat correct
        assertEquals(axa, p.actionPlusImportant(j2), "valeur plus importante verifier");
    }

}

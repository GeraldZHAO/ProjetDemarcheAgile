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
import org.junit.jupiter.api.Test;

class US16Test {

    @Test
    void testNotNull() {
        //creation de portefeuille
        Portefeuille p = new Portefeuille();
        ActionSimple bnp;

        // creation d'actions simples
        bnp = new ActionSimple("BNP");
        int qte1 = 10;
        //on achete une seule action, la taille de notre lsite d'actions devient 1
        p.acheter(bnp, qte1);
        //on vend notre seule action , la taille de notre lsite d'actions revient a 0
        p.vendre(bnp, qte1);
        //test
        //On vend l'action qu'onn vient d'acheter donc la taille de la liste qui continet les actions dans notre portefeuille devrais etre O
        assertEquals(0, p.mapLignes.size(), "l'action  a ete vendue");
    }
}

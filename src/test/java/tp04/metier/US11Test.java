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

/**
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author h
 */
class US11Test {

    @Test
    void testNotNull() {
        //creation de portefeuille
        Portefeuille p = new Portefeuille();
        ActionSimple bnp;

        // creation d'actions simples
        bnp = new ActionSimple("BNP");
        int qte1 = 10;
        p.acheter(bnp, 10);

        //test
        //pour vérifier est-ce que les action est bien achetée
        //Si l'achat de l'action est réussi, il n'est pas null
        assertNotNull(p.afficherAction(), "action achetée");
    }
}

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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author h
 */
class US1Test {

    @Test
    void testNotNull() {
        //la constructeur d’un portefeuille.
        Portefeuille p = new Portefeuille();
        //test
        //pour vérifier est-ce que le portefeuille a été crée réussie
        assertNotNull(p, "portefeuille crée");
    }
}

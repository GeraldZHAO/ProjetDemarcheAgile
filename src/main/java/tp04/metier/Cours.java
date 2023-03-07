/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

/**
 *Class representant le cours d'une action
 * @author perussel
 */
public class Cours {
    
    private final Jour jour;

    private final float valeur;

    public float getValeur() {
        return valeur;
    }
        
    public Jour getJour() {
        return jour;
   }

    public Cours(Jour jour, float valeur) {
        this.jour = jour;
        this.valeur = valeur;
    }
}

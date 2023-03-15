/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

/**
 *
 * @author perussel
 */
public class Cours {

    //propriéte
    private final Jour jour;

    private final float valeur;

    //CONSTRUCTUER
    public Cours(Jour jour, float valeur) {

        this.jour = jour;
        this.valeur = valeur;
    }

    //Methode pour recuprer le valeur
    public float getValeur() {
        return this.valeur;
    }

    //Methode pour recuperer le jour de cours
    public Jour getJour() {
        return this.jour;
    }

}

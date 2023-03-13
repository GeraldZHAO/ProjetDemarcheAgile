/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;

    /**
     * Constructeur d'une action simple
     *
     * @param libelle
     *
     */
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
    }

    //Getters 
    public Map<Jour, Cours> getMapCours() {
        return mapCours;
    }

    //setters
    public void setMapCours(Map<Jour, Cours> mapCours) {
        this.mapCours = mapCours;
    }

    /**
     * Obtenir le cours d'une action simple par un jour donnee
     *
     * @param j
     * @return float cours
     */

    public float getCours(Jour j) {
        return getMapCours().get(j).getValeur();
    }

    /**
     * Obtenir le cours d'une action simple le plus haut par un jour donnee
     *
     * @param j
     * @return
     */
    public float getCoursPlusHaut() {

        float max = 0f;
        Map<Jour, Cours> map = getMapCours();

        float value = 0f;

        Set<Entry<Jour, Cours>> entryset = map.entrySet();

        for (Entry<Jour, Cours> entry : entryset) {

            value = entry.getValue().getValeur();

            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Obtenir le cours d'une action simple le plus bas par un jour donnee
     *
     * @param j
     * @return
     */
    public float getCoursPlusBas() {
        float min = 1000000f;
        Map<Jour, Cours> map = getMapCours();

        float value = 0f;

        Set<Entry<Jour, Cours>> entryset = map.entrySet();

        for (Entry<Jour, Cours> entry : entryset) {

            value = entry.getValue().getValeur();

            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public Map<Jour, Cours> getEvolution(Jour j1, Jour j2) {

        Map<Jour, Cours> map = getMapCours();
        Map<Jour, Cours> mapResultat = new HashMap<>();

        Set<Entry<Jour, Cours>> entryset = map.entrySet();
        int anneeDebut = j1.getAnnee();
        int anneeFin = j2.getAnnee();
        int noJourDebut = j1.getNoJour();
        int noJourFin = j2.getNoJour();
        
        int annee;
        int nojour;
        
        for (Entry<Jour, Cours> entry : entryset) {

            annee = entry.getValue().getJour().getAnnee();
            nojour = entry.getValue().getJour().getNoJour();
            if (anneeDebut >= annee && annee <= anneeFin) {
                if (noJourDebut >= nojour && nojour <= noJourFin) {
                    mapResultat.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return mapResultat;
    }

    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        if (this.mapCours.containsKey(j) == false) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j) == true) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; // definition d'une constante possible
        }
    }

    // encapsulation de la définition de la classe Cours
    public static class Cours {

        private Jour jour;

        private float valeur;

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
}

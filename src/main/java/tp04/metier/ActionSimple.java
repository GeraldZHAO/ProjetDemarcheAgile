/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    /**
     * attribut lien
     */
    private Map<Jour, Cours> mapCours;
    public static final int pourcentage=100;
    public static final float Num_min=1000000000000f;
    public static final float Num_max=0f;
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
     *
     * @return float
     */
    public float getCoursPlusHaut() {
        var max = Num_max;
        float value;
        Map<Jour, Cours> map = getMapCours();
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
     *
     * @return float
     */
    public float getCoursPlusBas() {
        var min = Num_min;
        float value;
        Map<Jour, Cours> map = getMapCours();
        Set<Entry<Jour, Cours>> entryset = map.entrySet();

        for (Entry<Jour, Cours> entry : entryset) {
            value = entry.getValue().getValeur();
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    /**
     * methode qui verifie si une date est dans un intervalle
     * @param jour
     * @param j1
     * @param j2
     * @return boolean
     */
    private boolean isJourInRange(Jour jour, Jour j1, Jour j2) {
        if (jour.getAnnee() < j1.getAnnee() || jour.getAnnee() > j2.getAnnee()) {
        return false;
        }
        if (jour.getAnnee() == j1.getAnnee() && jour.getNoJour() < j1.getNoJour()) {
        return false;
        }
        if (jour.getAnnee() == j2.getAnnee() && jour.getNoJour() > j2.getNoJour()) {
        return false;
        }
        return true;
        }
    
    /**
     * methode qui determine l'evolution d'une action simple
     * @param j1
     * @param j2
     * @return 
     */
    public Map<Jour, Cours> getEvolution(Jour j1, Jour j2) {
        Map<Jour, Cours> map = getMapCours();
        Map<Jour, Cours> mapResultat = new HashMap<>();

        for (Entry<Jour, Cours> entry : map.entrySet()) {
            Jour jour = entry.getValue().getJour();
            if (isJourInRange(jour, j1, j2)) {
                mapResultat.put(entry.getKey(), entry.getValue());
            }
        }

        return mapResultat.isEmpty() ? null : mapResultat;
    }

    /**
     * methode qui permet d'obtenir le % de changement entre deux jours
     *
     * @param j1
     * @param j2
     * @return float
     */
    public double getPourcentageEvo(Jour j1, Jour j2) {
        //valeurs
        double cours1 = (double) getMapCours().get(j1).getValeur();
        double cours2 = (double) getMapCours().get(j2).getValeur();
        return ((cours2 - cours1) / cours1)*pourcentage;
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

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
        var max = 0f;
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
        var min = 1000000f;
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
     * methode qui permet d'avoir l'evolution cours d'une action au cours d'une
     * periode
     *
     * @param j1
     * @param j2
     * @return Map<Jour, Cours>
     */
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
            if (anneeDebut == annee && annee == anneeFin){
                if (noJourDebut <= nojour && nojour <= noJourFin) {
                        mapResultat.put(entry.getKey(), entry.getValue());
                    }
            else {
                    if (annee == anneeDebut) {
                        if (noJourDebut <= nojour) {
                            mapResultat.put(entry.getKey(), entry.getValue());
                        }
                    } else if (annee == anneeFin) {
                        if (nojour <= noJourFin) {
                            mapResultat.put(entry.getKey(), entry.getValue());
                        }
                    } else {
                        mapResultat.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
         return mapResultat;
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
        double cours1 = (double)getMapCours().get(j1).getValeur();
        double cours2 = (double)getMapCours().get(j2).getValeur();
        return ((cours2 - cours1) / cours1) * 100;
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

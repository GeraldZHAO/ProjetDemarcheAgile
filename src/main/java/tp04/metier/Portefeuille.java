/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.lang.System.Logger.Level;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author perussel
 */
public class Portefeuille {

    Map<AbstractAction, LignePortefeuille> mapLignes;

    private static final Logger LOG = Logger.getLogger(Portefeuille.class.getName());

    private class LignePortefeuille {

        private AbstractAction action;

        private int qte;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public AbstractAction getAction() {
            return this.action;
        }

        public LignePortefeuille(AbstractAction action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }

    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    public void acheter(AbstractAction a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }

    }

    public void vendre(AbstractAction a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }

    public void affichierLesAction() {

        Iterator<AbstractAction> iterator = this.mapLignes.keySet().iterator();
        while (iterator.hasNext()) {
            AbstractAction key = iterator.next();
            LignePortefeuille value = this.mapLignes.get(key);
            String s = "nom de action " + key.getLibelle() + ", qte = " + value.getQte();
            LOG.log(java.util.logging.Level.SEVERE, s);
        }
    }

    public Map<AbstractAction, LignePortefeuille> afficherAction() {
        return this.mapLignes;
    }

    public AbstractAction actionPlusImportant(Jour j) {
        AbstractAction actionPlusImportant = null;
        double var = 0.0;

        for (Map.Entry<AbstractAction, LignePortefeuille> entry : mapLignes.entrySet()) {
            if (((double) entry.getKey().valeur(j) * (double) entry.getValue().qte) > var) {
                var = (double) entry.getKey().valeur(j) * (double) entry.getValue().qte;

                actionPlusImportant = entry.getKey();
            }
        }
        return actionPlusImportant;

    }

}

package tp04.metier;

import java.util.Objects;

/**
 *
 * @author perussel
 */
public abstract class AbstractAction implements Comparable<AbstractAction> {

    //proprietes
    private String libelle;

    protected AbstractAction(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    //methodes
    //retourne de libelle de l'action
    public String getLibelle() {
        return libelle;
    }
    //pour changer le libelle de l'action

    //valeur de l'action pour un jour donnée
    public abstract float valeur(Jour j);

    //methode hashcode de l'action
    @Override
    public int hashCode() {
        int var = 3;
        var = 53 * var + Objects.hashCode(this.libelle);
        return var;
    }
    //methode equals pour une action

    @Override
    public boolean equals(Object obj) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return super.equals(obj);
    }

    //methode toString pour une action
    public String toString() {
        return this.getLibelle();
    }

}

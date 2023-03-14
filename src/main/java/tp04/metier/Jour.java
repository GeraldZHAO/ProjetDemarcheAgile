/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;
import java.util.ArrayList;

/**
 *
 * @author perussel
 */
public class Jour {

    private int annee;
    private int noJour;
    private ArrayList<Action> liste = new ArrayList<>();

    /**
     * Get the value of annee
     *
     * @return the value of annee
     */
    public int getAnnee() {
        return annee;
    }


    /**
     * Get the value of noJour
     *
     * @return the value of noJour
     */
    public int getNoJour() {
        return noJour;
    }

    public Jour(int annee, int noJour) {
        this.annee = annee;
        this.noJour = noJour;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.annee;
        hash = 61 * hash + this.noJour;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jour other = (Jour) obj;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.noJour != other.noJour) {
            return false;
        }
        return true;
    }
  
    public void enregistreAction(Action a){
      liste.add(a);
    }
    
    public Action plusEleve()
    {
      float max = 0;
      Action result= new ActionSimple(" ");
      for(int i= 0; i<liste.size();i++)
      {
        if( liste.get(i).valeur(this)> max)
        {
            max = liste.get(i).valeur(this);
            result = liste.get(i);
        }
      }
        return result;
        
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {
    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    @Override
    public float valeur(Jour j) {
        float valeur;
        
        valeur = 0;
        for(ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        
        return valeur;
    }
    
    public float getPourcentage(ActionSimple as){
        
        return this.mapPanier.get(as);
    }
    
    
//    public void connaitrecComposition(){
////        System.out.println("Les actions composées <"+super.getLibelle()"> se composent d'actions simples: ");
//        for(ActionSimple as:this.mapPanier.keySet()){
//                System.out.println(this.mapPanier.get(as)+" % " + as.getLibelle());
//            }
//    }
    
    public Map getMap(){
      Map<ActionSimple, Float> newMap = new HashMap();
      
      for(Map.Entry<ActionSimple,Float> entry : this.mapPanier.entrySet()){
          ActionSimple as = entry.getKey();
//      for(ActionSimple as:this.mapPanier.keySet()){
        newMap.put(as, this.mapPanier.get(as));
         
        }
        return newMap;
    }
    
    
}

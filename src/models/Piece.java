package models;

import java.util.List;

public class Piece {

    //Attributs
    private String nom;
    private boolean etat_lumiere; // False --> éteinte, True --> allumée
    private String etat_proprete;
    private List<Objet> liste_objets;
    

    //Constructeur
    public Piece(String nom, boolean etat_lumiere, String etat_proprete) {
        this.nom = nom;
        this.etat_lumiere = etat_lumiere;
        this.etat_proprete = etat_proprete;
    }

    //Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEtat_lumiere() {
        return etat_lumiere;
    }

    public String getEtat_lumiere() {
        if(etat_lumiere) return("allumée");
        else return("éteinte");
    }

    public void setEtat_lumiere(boolean etat_lumiere) {
        this.etat_lumiere = etat_lumiere;
    }

    public String getEtat_proprete() {
        return etat_proprete;
    }

    public void setEtat_proprete(String etat_proprete) {
        this.etat_proprete = etat_proprete;
    }

    
    public void RemplirPiece(List<Objet> lobj){ //setListe_objets
        this.liste_objets = lobj;
    }

    public void addObjet(Objet o){
        this.liste_objets.add(o);
    }

    public void deleteObjet(int i){
        this.liste_objets.remove(i);
    }

    

    public List<Objet> getListe_objets() {
        return liste_objets;
    }


    public void afficherObj(boolean num){ // le boolean permet de savoir si on affiche les numeros ou pas
        int i=1;
        System.out.println();
        for (Objet objet : this.liste_objets) {
            if(num==true)
            {
                System.out.println(Integer.toString(i)+". "+objet.getNom()+", "+objet.getDetails()+" ("+ objet.getEtat_string()+")");
                i++;
            }
            else{
                System.out.println("- " + objet.getNom()+", "+objet.getDetails()+" ("+ objet.getEtat_string()+")");
            } 
            
        }
        
    }

    public void switchLight(){
        etat_lumiere= !etat_lumiere;

    }

}
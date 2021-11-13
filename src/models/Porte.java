package models;

import java.util.List;

public class Porte {

    //Attributs
    private List<Piece> liste_pieces;
    private boolean etat; // False --> fermé, True --> ouvert;

    //Constructeur
    public Porte(List<Piece> liste_pieces, boolean etat) {
        this.liste_pieces = liste_pieces;
        this.etat = etat;
    }

    //Getters and Setters
    public List<Piece> getListe_pieces() {
        return liste_pieces;
    }

    public void setListe_pieces(List<Piece> liste_pieces) {
        this.liste_pieces = liste_pieces;
    }

    public boolean isEtat() {
        return etat;
    }

    public String getEtat(){
        if(etat) return("ouverte");
        else return("fermée");
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
    
}

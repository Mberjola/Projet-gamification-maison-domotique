package models;

import java.util.Scanner;

public class Objet {

    //Attributs
    private String nom;
    private Piece piece;
    private String details;
    private boolean etat;
    private String action_etatOn;
    private String action_etatOff;
    private String etatOn;
    private String etatOff;


    //Constructeur
    public Objet(String nom, Piece piece, String details, boolean etat, String action_etatOn, String action_etatOff,
            String etatOn, String etatOff) {
        this.nom = nom;
        this.piece = piece;
        this.details = details;
        this.etat = etat;
        this.action_etatOn = action_etatOn;
        this.action_etatOff = action_etatOff;
        this.etatOn = etatOn;
        this.etatOff = etatOff;
    }

    public Objet(){

    }

    //Getters and Setters
    public String getNom() {
        return nom;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    

    public String getAction_etatOn() {
        return action_etatOn;
    }

    public void setAction_etatOn(String action_etatOn) {
        this.action_etatOn = action_etatOn;
    }

    public String getAction_etatOff() {
        return action_etatOff;
    }

    public void setAction_etatOff(String action_etatOff) {
        this.action_etatOff = action_etatOff;
    }

    public String getEtatOn() {
        return etatOn;
    }

    public void setEtatOn(String etatOn) {
        this.etatOn = etatOn;
    }

    public String getEtatOff() {
        return etatOff;
    }

    public void setEtatOff(String etatOff) {
        this.etatOff = etatOff;
    }

    public String getEtat_string(){
        String res = "";
        if (etat) {
            res = this.etatOn;
        } else {
            res = this.etatOff;
        }
        return res;
    }

    //Méthodes
    public String interagir(){
        String res = "";
        this.etat = !etat;
        if (etat) {
            res = this.action_etatOn;
        } else {
            res = this.action_etatOff;
        }
        return res;
    }

    public static void creerObjet(Scanner sc, Joueur player){
        Objet obj_cree = new Objet();

        System.out.println("Quel est le nom de l'objet ?");
        System.out.println("    Exemple : 'Television', 'Lampe', etc ...");
        String nom = sc.nextLine();
        Piece p = player.getPiece();

        System.out.println("Quels sont les détails de l'objet ?");
        System.out.println("    Exemple : 'C'est un grand écran plat !");
        String details = sc.nextLine();

        System.out.println("Décrivez l'action qui 'active' l'objet");
        System.out.println("    Exemple : 'La télévision s'allume, quelle magnifique télé !'");
        String actionOn = sc.nextLine();

        System.out.println("Décrivez l'action qui 'désactive' l'objet");
        System.out.println("    Exemple : 'La télévision s'éteint, vous décidez de faire autre chose !'");
        String actionOff = sc.nextLine();

        System.out.println("Quel est l'etat actif de l'objet ?");
        System.out.println("    Exemple : 'Allumée'");
        String etatOn = sc.nextLine();

        System.out.println("Quels est l'etat non-actif?");
        System.out.println("    Exemple : 'Eteinte'");
        String etatOff = sc.nextLine();


        obj_cree = new Objet(nom, p, details, false, actionOn, actionOff, etatOn, etatOff);
        player.getPiece().addObjet(obj_cree);
    }

    // Suppression d'un objet d'une pièce :
    public static void supprimerObjet(Scanner sc, Joueur player) {
        if(!player.getPiece().getListe_objets().isEmpty()){
            System.out.println("Quel objet voulez-vous supprimer ?\n");
            player.getPiece().afficherObj(true);
            String str_interagir_choix = sc.nextLine();
            int intchoix = Integer.parseInt(str_interagir_choix) - 1;
            if (intchoix >= 0 && intchoix < player.getPiece().getListe_objets().size()) {
                String nom_obj_suppr = player.getPiece().getListe_objets().get(intchoix).getNom();
                player.getPiece().deleteObjet(intchoix);
                System.out.println("\nL'objet " + nom_obj_suppr + " a bien été supprimé.");
            } else {
                System.out.println("Le choix fourni est incorrect, veuillez réessayer !");
            }
        }else{
            System.out.println("Vous ne pouvez pas effectuer cette opération, car il n'y a pas d'objets à supprimer dans cette pièce ! Veuillez en rajouter !");
        }
    }
    
}

package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Ceci importe la classe Scanner du package java.util
import java.util.Scanner;

public class Joueur {
    //Déclaration des attributs
    private String pseudo;
    private Piece piece;
    private boolean admin;

   //Constructeur
    public Joueur(String pseudo, Piece piece, boolean admin) {
        this.pseudo = pseudo;
        this.piece = piece;
        this.admin = admin;
    }

    //Getters and Setters
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public String getPseudo() {
        return this.pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }  
    public void afficheLieu(){
        System.out.println("\n" + pseudo + " est actuellement dans " + piece.getNom());
        System.out.println("La lumière est " + piece.getEtat_lumiere() + " dans " + piece.getNom() + ".");
    }
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    //Méthodes
    public void move(ArrayList<Piece> liste_pieces, ArrayList<Porte> liste_portes, Scanner sc){

        List<Piece> liste_pieces_accessibles = new ArrayList<>();
        for (Piece piece : liste_pieces) {
            if (piece != this.piece) {
                liste_pieces_accessibles.add(piece);
            }    
        }

        System.out.println("Ou voulez-vous allez ?");

        int i = 1;
        for (Piece piece : liste_pieces_accessibles) {
            System.out.println(Integer.toString(i) + ". " + piece.getNom());
            i++;
        }

        // Preparation du scanner
        int choix = sc.nextInt();

        //On verifie si le joueur peut acceder a la piece choix
        boolean decision = verifierchoix(liste_pieces_accessibles.get(choix-1), liste_portes,sc);
        if(decision) System.out.println("Vous avez reussis a vous deplacer vers " + this.piece.getNom()+ "!");
        sc.nextLine();

    }

    public boolean verifierchoix(Piece piece, List<Porte> lportes,Scanner sc){


        for (Porte porte : lportes) {
            List<Piece> liste_pieces = porte.getListe_pieces();

            // Si la porte est lie a la localisation du joueur, et de sa destionation, et qu'elle est ouverte
            if (liste_pieces.contains(this.piece) && liste_pieces.contains(piece) && porte.isEtat()) {
                this.setPiece(piece);
                return true;

                //Sinon si, la porte est lie a la localisation du joueur et de sa destionation, mais qu'elle est fermee
            }else if (liste_pieces.contains(this.piece) && liste_pieces.contains(piece) && !porte.isEtat()){
                
                    System.out.println("Vous vous deplacez en direction de " + piece.getNom()+ " mais la porte est fermee");
                    System.out.println("Que voulez-vous faire ?");
                    System.out.println("1. Ouvrir la porte");
                    System.out.println("2. Laissez tomber");

                    // Preparation du scanner
                    int choix = sc.nextInt();

                    if(choix==2){
                        return false;
                    }
                    else{
                        porte.setEtat(true);
                        System.out.println("Vous avez ouvert la porte !");
                        this.setPiece(piece);
                        return true;
                    }


                }
        }

        return false;
    }
    
    public String pickDialog(int situation){

        String dialog = "";

        Random r = new Random();

        switch (situation) {
            case 1: //Afficher la liste des objets
                String[] list = {
                    "Il fait noir ici ! Je devrais allumer la lumière...",
                    "Il fais trop sombre...Je ne vois rien...",
                    "Oh Je.....*vous tombez sur un objet et vous vous relevez* Purée!...Je devrais vraiment allumer la lumière..."
                };
                dialog = list[r.nextInt(list.length)];
                break;
            case 2: //Interagir avec un objet
                String[] list2 = {
                    "Il faut vraiment que j'allume cette foutue lumière...",
                    "JE PEUX PAS INTERAGIR SI IL N'Y A PAS DE LUMIERE",
                    "Il faut d'abord allumer la lumière et ensuite voir les objets... D'accord j'ai compris"
                };
                dialog = list2[r.nextInt(list2.length)];
                break;
            case 3: //Se déplacer vers une autre pièce
            String[] list3 = {
                "Je ne vois pas où je met les pieds... Je devrais allumer la lumière avant de bouger",
                "Je peux pas bouger si je ne vois rien...",
                "Le seul endroit où j'ai envie d'aller pour l'instant c'est vers cet interrupteur là-bas"
            };
                dialog = list3[r.nextInt(list3.length)];
                break;
            default:
                break;
        }

        return dialog;

    }
    
}

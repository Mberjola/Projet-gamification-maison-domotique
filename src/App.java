import java.util.ArrayList;
import java.util.List;

import models.Joueur;
import models.Objet;
import models.Piece;
import models.Porte;

//Ceci importe la classe Scanner du package java.util
import java.util.Scanner;

public class App {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
     }  
    public static void main(String[] args) throws Exception {

        //------------------ INITIALISATION ---------------- //

        // Créations des différentes pièces de la maison
        // De base les lumières sont éteintes
        
        Piece chambre = new Piece("Chambre", false, "Propre");
        Piece cuisine = new Piece("Cuisine", false, "Propre");
        Piece salon = new Piece("Salon", false, "Propre");
        Piece sdb = new Piece("Salle de bain", false, "Propre");

        //initialisation de la météo
        //de base ils fait jour 
        boolean isNuit= false;

        //Remplissage des différentes pièces par défaut
        Objet tele = new Objet("Télé", salon, "c'est une télé ordinaire.", false, "Vous allumez la télé. Quel magnifique écran plat !", "Vous éteignez la télé. Enfin, un peu de calme !", "allumée", "éteinte");
        Objet consoleDejeu = new Objet("Console de jeu", salon, "c'est une PS5, la console la plus rare du paf", false, "Vous allumez la console. Un doux bruit se fait entendre", "On vous crie dessus, vous éteignez la console", "allumée", "éteinte");
        Objet machineAcafe = new Objet("Machine à café", cuisine, "c'est une machine Nespresso de qualitée", false, "Vous faites couler un café. Ça sent très bon", "Vous éteignez la machine à café.", "allumée", "éteinte");
        Objet microOndes = new Objet("Micro-ondes", cuisine, "c'est un simple micro-ondes", false, "Vous mettez en marche le micro-ondes. Votre plat se réchauffe", "Vous éteignez le micro-ondes. Votre plat est chaud !", "allumé", "éteint");
        Objet lampe = new Objet("Lampe", chambre, "c'est une lampe de chevet", false, "Vous allumez la lampe. Vous y voyez plus clair", "Vous éteignez la lampe.", "allumée", "éteindre");
        Objet ordinateur = new Objet("Ordinateur", chambre, "c'est un PC fixe Intel core i20, GTX5080Ti, 60Gb de RAM", false, "Vous mettez en marche votre ordinateur. Aucun bruit se fait entendre", "Vous éteignez le PC", "en fonction", "éteint");

        List<Objet> lobjetsSalon = new ArrayList<Objet>();
        List<Objet> lobjetsCuisine = new ArrayList<Objet>();
        List<Objet> lobjetsChambre = new ArrayList<Objet>();
        List<Objet> lobjetsSDB = new ArrayList<Objet>();

        lobjetsSalon.add(tele);
        lobjetsSalon.add(consoleDejeu);

        lobjetsCuisine.add(machineAcafe);
        lobjetsCuisine.add(microOndes);

        lobjetsChambre.add(lampe);
        lobjetsChambre.add(ordinateur);

        // Création d'une liste contenant l'ensemble des pièces
        ArrayList<Piece> liste_pieces = new ArrayList<Piece>();
        liste_pieces.add(chambre);
        liste_pieces.add(cuisine);
        liste_pieces.add(salon);
        liste_pieces.add(sdb);

        ArrayList<Piece> lpieceSC= new ArrayList<Piece>(); //Porte du salon vers la cuisine 
        lpieceSC.add(salon);
        lpieceSC.add(cuisine);

        ArrayList<Piece> lpieceSCH= new ArrayList<Piece>(); //Porte du salon vers la chambre 
        lpieceSCH.add(salon);
        lpieceSCH.add(chambre);


        ArrayList<Piece> lpieceSDB= new ArrayList<Piece>(); // Porte du salon vers la salle de bain 
        lpieceSDB.add(salon);
        lpieceSDB.add(sdb);


        ArrayList<Piece> lpieceSDBC= new ArrayList<Piece>(); // Porte de la salle de bain vers la chambre
        lpieceSDBC.add(chambre);
        lpieceSDBC.add(sdb);

        Porte salon_cuisine = new Porte(lpieceSC, false);
        Porte salon_chambre = new Porte(lpieceSCH, false);
        Porte salon_sdb = new Porte(lpieceSDB, false);
        Porte chambre_sdb = new Porte(lpieceSDBC, false);

        //Création d'une liste contenant l'ensemble des portes:
        ArrayList<Porte> liste_portes = new ArrayList<>();
        liste_portes.add(salon_cuisine);
        liste_portes.add(salon_chambre);
        liste_portes.add(salon_sdb);
        liste_portes.add(chambre_sdb);


        // Création des fenêtres :
        Objet fenetreSalon = new Objet("Fenetre salon", salon, "Coulissante", false, "La fenêtre du salon est ouverte", "La fenêtre du salon est fermée", "Ouverte", "Fermée");
        Objet fenetreCuisine = new Objet("Fenetre cuisine", salon, "Battante", false, "La fenêtre de la cuisine est ouverte", "La fenêtre de la cuisine est fermée", "Ouverte", "Fermée");
        Objet fenetreSdb = new Objet("Fenetre salle de bain", salon, "A soufflet", false, "La fenêtre de la salle de bain est ouverte", "La fenêtre de la salle de bain est fermée", "Ouverte", "Coulissante");
        Objet fenetreChambre = new Objet("Fenetre chambre", salon, "Coulissante", false, "La fenêtre  de la chambre est ouverte", "La fenêtre de la chambre est fermée", "Ouverte", "Fermée");

        //Création d'une liste contenant l'ensemble des fenêtres
        ArrayList<Objet> liste_fenetre = new ArrayList<>();
        liste_fenetre.add(fenetreSalon);
        liste_fenetre.add(fenetreCuisine);
        liste_fenetre.add(fenetreSdb);
        liste_fenetre.add(fenetreChambre);

        lobjetsChambre.add(fenetreChambre);
        lobjetsSalon.add(fenetreSalon);
        lobjetsCuisine.add(fenetreCuisine);
        lobjetsSDB.add(fenetreSdb);

        salon.RemplirPiece(lobjetsSalon);
        cuisine.RemplirPiece(lobjetsCuisine);
        chambre.RemplirPiece(lobjetsChambre);
        sdb.RemplirPiece(lobjetsSDB);
        //Preparation du scanner
        Scanner sc = new Scanner(System.in);

        //Lancement du programme
        System.out.println("\nBonjour, bienvenue dans votre programme de gamification de maison domestique.\nVoulez-vous jouer a un jeu ?\n");

        System.out.println("1. Jouer en tant que joueur");
        System.out.println("2. Jouer en tant qu'un administrateur");
        String str = sc.nextLine();

        //Création d'un joueur
        Joueur player;
        String strPseudo = "Inconnu";
        boolean admin = false;
        if(str.equals("1")){
            System.out.println("\nVous jouez en tant que joueur");
            admin = false;
        }
        else if(str.equals("2")){
            System.out.println("\nVous jouez en tant qu'administrateur");
            
            admin = true;
        }
        else{System.out.println("Veuillez choisir une des deux options");
            }

        // Récupération pseudo du joueur et création de celui-ci
        System.out.println("Entrez votre pseudo : ");
        strPseudo = sc.nextLine();
        player = new Joueur(strPseudo, salon, admin);
        clearScreen();
        if(player.isAdmin()) System.out.println("\n" + player.getPseudo() + " est un nouvel administrateur !");
        else System.out.println("\n" + player.getPseudo() + " est un nouveau joueur !");

        System.out.println("------------------------------------------");
        //player.afficheLieu();1

        //On affiche le menu1
        //afficheMenu();
        
        int choix = 0;
        int temps= 0;
        boolean auto1 = false;
        boolean automatisme = true;
        
        while (true) {
            System.out.println("------------------------");
            player.afficheLieu();
            if(automatisme){
                System.out.println("Les automatismes sont activés.");
            }else{
                System.out.println("Les automatismes sont désactivés.");
            }
            temps = cycleJourNuit(isNuit, temps);
            if(automatisme){
                if (isNuit) {
                    if (auto1) {
                        for (Objet fenetre : liste_fenetre) {
                            fenetre.setEtat(false);
                        }
                        auto1 = false;
                    }
                }
                // S'il fait jour :
                else if (!isNuit) {
                    if (!auto1) {
                        for (Objet fenetre : liste_fenetre)
                            fenetre.setEtat(true);
                        auto1 = true;
                    }
                }
            }
            afficheMenu(player);
            String strchoix = sc.nextLine();
            choix = Integer.parseInt(strchoix);
            // JOUEUR || ADMIN
            switch (choix) {
                case 1: // Afficher la liste des objets
                    if(player.getPiece().isEtat_lumiere()){
                        System.out.println("Les objets qui se trouvent dans " + player.getPiece().getNom() + " sont :");
                        player.getPiece().afficherObj(false);
                        sc.nextLine();
                    }else{
                        System.out.println(player.pickDialog(1));
                    }
                    sc.nextLine();
                    clearScreen();
                    break;
                case 2: // Interagir avec un objet
                    if(player.getPiece().isEtat_lumiere()){
                        System.out.println("\n Avec quel objet souhaitez vous interagir ?");
                        player.getPiece().afficherObj(true);
                        String str_interagir_choix = "0";
                        str_interagir_choix = sc.nextLine();
                        int intchoix = Integer.parseInt(str_interagir_choix);
                        System.out.println(player.getPiece().getListe_objets().get(intchoix - 1).interagir()); //on recupere le lieu ou le joueur se situe, on recupere la liste des objets de cette piece, on recupere l'objet choisi par l'utilisateur, et on interagit avec
                        sc.nextLine();
                        clearScreen();
                    }else{
                        System.out.println(player.pickDialog(2));
                        sc.nextLine();
                        clearScreen();
                    }
                   
                    
                    break;
                case 3: // Se deplacer vers une autre pièce
                    clearScreen();
                    if(player.getPiece().isEtat_lumiere()){
                        player.move(liste_pieces,liste_portes,sc);
                    }else{
                        System.out.println(player.pickDialog(3));
                    }
                    break;
                case 4: // Allumer/Eteindre les automatismes || Allumer/Eteindre la lumière
                    if(player.isAdmin()){ 
                        player.getPiece().switchLight();
                    }else{
                        if(automatisme){
                            System.out.println("On désactive les automatismes. Les fenêtres ne s'ouvrent/ferment plus de manière automatique.");
                            automatisme = !automatisme;
                        }else{
                            System.out.println("On active l'automatisme. Les fenêtres s'ouvrent/ferment de manière automatique");
                            automatisme = !automatisme;
                        }
                    }
                    sc.nextLine();
                    clearScreen();
                    break;  
                case 5: //Allumer/Eteindre la lumière || Ajouter un objet
                    if(player.isAdmin()){ Objet.creerObjet(sc, player);}
                    else{
                        player.getPiece().switchLight();
                    }
                    
                    clearScreen();
                    break;
                case 6: //Quitter || Retirer un objet dans la pièce courante
                    if(player.isAdmin()) Objet.supprimerObjet(sc, player);
                    else{System.exit(0);}
                    sc.nextLine();
                    clearScreen();
                    break;
                case 7: // ... || Passer le temps (Jour/Nuit)
                    if(player.isAdmin()){ 
                        isNuit = !isNuit;
                        if(isNuit){
                            temps = 5;
                        }
                        else{
                            if(!isNuit){
                                temps=0;
                            }
                        }
                    }
                    sc.nextLine();
                    clearScreen();
                    break;
                case 8: // ... || Quitter
                    System.exit(0);
                    break;
                case 9: // ... || Allumer/Eteindre les automatismes
                    if(player.isAdmin()){
                        if (automatisme) {
                            System.out.println(
                                    "On désactive les automatismes. Les fenêtres ne s'ouvrent/ferment plus de manière automatique.");
                            automatisme = !automatisme;
                        } else {
                            System.out.println(
                                    "On active l'automatisme. Les fenêtres s'ouvrent/ferment de manière automatique");
                            automatisme = !automatisme;
                        }
                    }
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Choix incorrect, veuillez réessayer !");
                    break;
            }
            
        }

    }

    public static void afficheMenu(Joueur p){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Afficher la liste des objets de la pièce");
        System.out.println("2. Interagir avec un objet");
        System.out.println("3. Se déplacer vers une autre pièce");
        if(p.isAdmin()) {
            System.out.println("4. Allumer/Eteindre la lumière");
            System.out.println("5. Ajouter un objet dans la pièce courante");
            System.out.println("6. Retirer un objet dans la pièce courante");
            System.out.println("7. Passer le temps (Jour/Nuit)");
            System.out.println("8. Quitter");
            System.out.println("9. Allumer/Eteindre les automatismes\n");
        }else{
            System.out.println("4. Allumer/Eteindre les automatismes");
            System.out.println("5. Allumer/Eteindre la lumière");
            System.out.println("6. Quitter\n");
        }
        
    }

    public static int cycleJourNuit(boolean isNuit, int temps){
        //temps : [0,9]
        //temps : 0 - 4 ---> Jour
        //temps : 5 - 9 ---> Nuit
        int temps_res;
        temps_res = temps+1;
        temps_res = temps_res%10;

        if(temps_res>=0 && temps_res<5){
            isNuit = false;
            System.out.println("Il fait jour.\n");
        }else{
            isNuit = true;
            System.out.println("Il fait nuit.\n");
        }

        return temps_res;
    }


}
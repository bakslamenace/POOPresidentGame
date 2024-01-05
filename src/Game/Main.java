package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Joueur> joueurs = new ArrayList<>();

        // Demande le nom de chaque joueur et crée les joueurs
        System.out.println("Entrez le nombre de joueurs:");
        int nombreDeJoueurs = scanner.nextInt();
        scanner.nextLine(); // Consomme la ligne restante après le nombre

        for (int i = 0; i < nombreDeJoueurs; i++) {
            System.out.println("Entrez le nom du joueur " + (i + 1) + ":");
            String nom = scanner.nextLine();
            joueurs.add(new Joueur(nom));
        }

        // Initialisation du deck, mélange et distribution des cartes
        Deck deck = new Deck();
        deck.shuffle();
        Partie partie = new Partie(joueurs, deck);
        partie.distribuerCartes();

        // Mélange de l'ordre des joueurs
        Collections.shuffle(joueurs);

        // Exécution de la partie
        partie.executerPartie();

        }
}
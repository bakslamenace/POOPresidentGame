package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class represents a game session.
public class Partie {
    private List<Joueur> joueurs; // List of players in the game.
    private List<Carte> cartesSurLePaquet; // Cards currently on top of the pile.
    private Deck deck; // The deck of cards for the game.

    // Constructor to create a new game with given players and a deck.
    public Partie(List<Joueur> joueurs, Deck deck) {
        this.joueurs = joueurs;
        this.cartesSurLePaquet = new ArrayList<>();
        this.deck = deck;
    }

    // Distributes cards among players.
    public void distribuerCartes() {
        Collections.shuffle(deck.getCartes()); // Shuffle the deck.
        int nombreDeJoueurs = joueurs.size();
        int indexCarte = 0;
        while (indexCarte < deck.getNombreDeCartes()) {
            for (Joueur joueur : joueurs) {
                if (indexCarte < deck.getNombreDeCartes()) {
                    joueur.recevoirCarte(deck.getCartes().get(indexCarte));
                    indexCarte++;
                }
            }
        }
    }

    // Executes the game, allowing each player to take turns.
    public void executerPartie() {
        boolean partieTerminee = false;
        while (!partieTerminee) {
            for (Joueur joueur : joueurs) {
                joueur.jouer(cartesSurLePaquet);
                if (verifierFinPartie()) {
                    partieTerminee = true;
                    break;
                }
            }
        }
    }

    // Checks if the game is finished and determines the winner/loser.
    public boolean verifierFinPartie() {
        for (Joueur joueur : joueurs) {
            if (joueur.getCartes().isEmpty()) {
                annoncerGagnant(joueur);
                return true;
            }
        }
        return false;
    }

    // Announces the winner of the game.
    private void annoncerGagnant(Joueur gagnant) {
        System.out.println("Le gagnant est " + gagnant.getNom());
    }

    // Additional methods can be added as necessary.
}

package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class represents a player in the game.
public class Joueur {
    private String nom; // Name of the player.
    private List<Carte> cartes; // The player's hand of cards.
    private Scanner scanner; // Scanner to read user input.

    // Constructor to create a new player.
    public Joueur() {
        this.nom = "Joueur"; // Default name, can be modified to allow custom names.
        this.cartes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Adds a card to the player's hand.
    public void recevoirCarte(Carte carte) {
        cartes.add(carte);
    }

    // Allows the player to play a card.
    public void jouer(List<Carte> cartesSurLePaquet) {
        afficherCartes(); // Display the player's cards.

        System.out.println("Choisissez une carte à jouer (numéro de 1 à " + cartes.size() + "):");
        int choix = scanner.nextInt();

        // Validate the player's choice.
        while (choix < 1 || choix > cartes.size()) {
            System.out.println("Choix invalide. Veuillez choisir un numéro de carte valide:");
            choix = scanner.nextInt();
        }

        Carte carteChoisie = cartes.get(choix - 1); // Get the chosen card.
        cartesSurLePaquet.add(carteChoisie); // Add the chosen card to the pile.
        retirerCarte(carteChoisie); // Remove the card from the player's hand.

        // Rules can be added here to check if the card can be played.
    }

    // Removes a card from the player's hand.
    public void retirerCarte(Carte carte) {
        cartes.remove(carte);
    }

    // Displays the player's hand of cards.
    private void afficherCartes() {
        System.out.println("Vos cartes:");
        for (int i = 0; i < cartes.size(); i++) {
            System.out.println((i + 1) + ". " + cartes.get(i));
        }
    }

    // Returns the list of cards the player has.
    public List<Carte> getCartes() {
        return cartes;
    }

    // Returns the player's name.
    public String getNom() {
        return nom;
    }

    // Additional methods can be added as necessary.
}

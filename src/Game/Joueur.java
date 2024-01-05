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
        this.nom = "Joueur";
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

    // Méthode pour permettre au joueur de décider de jouer ou de passer son tour
    public boolean deciderJouerOuPasser(List<Carte> cartesSurLePaquet) {
        // Logique pour demander au joueur s'il veut jouer ou passer son tour.
        // Retourne true s'il décide de jouer, false s'il passe son tour.

        // Exemple d'interaction (à adapter pour une interface utilisateur réelle) :
        System.out.println(nom + ", voulez-vous jouer une carte ? (y/n)");
        String reponse = scanner.nextLine();
        if (reponse.equalsIgnoreCase("y")) {
            jouer(cartesSurLePaquet); // Méthode jouer à modifier pour permettre cette interaction
            return true;
        } else if (reponse.equalsIgnoreCase("n")) {
            return false;
        }else {
            System.out.println("Réponse invalide. Veuillez répondre par y ou n.");
            return deciderJouerOuPasser(cartesSurLePaquet);
        }
    }

    public void passerTour() {
        // Logique pour passer le tour
        System.out.println(nom + " passe son tour.");
    }
}

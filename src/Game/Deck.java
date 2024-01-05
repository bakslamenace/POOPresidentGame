package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class represents a deck of playing cards.
public class Deck {
    private List<Carte> cartes; // A list to store the cards in the deck.

    // Constructor to create and initialize a new deck of cards.
    public Deck() {
        this.cartes = new ArrayList<>();
        initialiserDeck(); // Initialize the deck with cards.
    }

    // Initializes the deck with a standard set of playing cards.
    private void initialiserDeck() {
        for (String couleur : new String[]{"Cœur", "Carreau", "Trèfle", "Pique"}) {
            for (String valeur : new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"}) {
                cartes.add(new Carte(valeur, couleur));
            }
        }
    }

    // Shuffles the cards in the deck.
    public void shuffle() {
        Collections.shuffle(this.cartes);
    }

    // Returns the list of cards in the deck.
    public List<Carte> getCartes() {
        return this.cartes;
    }

    // Returns the number of cards in the deck.
    public int getNombreDeCartes() {
        return this.cartes.size();
    }

    // Additional methods can be added as necessary.
}

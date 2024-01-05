package Game;

// This class represents a playing card with a value and a suit.
public class Carte {
    private final String valeur;  // The value of the card (e.g., "As", "Roi", etc.).
    private final String couleur; // The suit of the card (e.g., "Cœur", "Pique", etc.).

    // Constructor to initialize a card with its value and suit.
    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    // Returns the value of the card.
    public String getValeur() {
        return valeur;
    }

    // Returns the suit of the card.
    public String getCouleur() {
        return couleur;
    }

    // Returns a string representation of the card (e.g., "As de Cœur").
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }
}

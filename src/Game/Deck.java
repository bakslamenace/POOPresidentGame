package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// La classe représente le deck de cartes utilisé dans le jeu.
public class Deck {
    private List<Carte> cartes; // Une liste pour stocker les cartes dans le jeu.

    // Constructeur pour créer et initialiser un nouveau jeu de cartes.
    public Deck() {
        this.cartes = new ArrayList<>();
        initialiserDeck(); // Initialise le deck avec les cartes.
    }

    // Constructeur pour créer et initialiser un nouveau jeu de cartes
    private void initialiserDeck() {
        for (String couleur : new String[]{"Cœur", "Carreau", "Trèfle", "Pique"}) {
            for (String valeur : new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"}) {
                cartes.add(new Carte(valeur, couleur));
            }
        }
    }

    //Mélange les cartes dans le deck.
    public void shuffle() {
        Collections.shuffle(this.cartes);
    }

    // Renvoie la liste de carte
    public List<Carte> getCartes() {
        return this.cartes;
    }

    // Renvoie le nombre de cartes dans le jeu.
    public int getNombreDeCartes() {
        return this.cartes.size();
    }
}

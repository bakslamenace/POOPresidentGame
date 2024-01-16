package Game;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Joueur> joueurs;
    private List<Carte> cartesSurLePaquet;
    private Deck deck;
    private Joueur dernierJoueur; // Le dernier joueur à avoir joué

    public Partie(List<Joueur> joueurs, Deck deck) {
        this.joueurs = joueurs;
        this.cartesSurLePaquet = new ArrayList<>();
        this.deck = deck;
        this.dernierJoueur = null; // Initialiser le dernier joueur à null
    }

    public void distribuerCartes() {
        deck.shuffle();
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

    private boolean isCardPlayable(Carte carteJouee, List<Carte> cartesSurLePaquet) {
        System.out.println("Comparing cards");
        if (cartesSurLePaquet.isEmpty()) {
            return true; // Si le paquet est vide, toutes les cartes sont jouables.
        }
        Carte derniereCarte = cartesSurLePaquet.get(cartesSurLePaquet.size() - 1);
        System.out.println("Carte sur le paquet " + derniereCarte);
        System.out.println("Carte jouée " + carteJouee);
        System.out.println("Comparaison : " + carteJouee.compareTo(derniereCarte));
        return carteJouee.compareTo(derniereCarte) > 0;
    }

    public void executerPartie() {
        int indexJoueurActuel = 0;
        boolean aJoueDeux = false;

        while (!verifierFinPartie()) {
            Joueur joueurActuel = joueurs.get(indexJoueurActuel % joueurs.size());
            System.out.println("C'est au tour de " + joueurActuel.getNom() + " de jouer.");

            // Affichage des cartes sur le paquet
            System.out.println("Cartes sur le paquet: " + cartesSurLePaquet);

            if (!aJoueDeux || joueurActuel == dernierJoueur) {
                boolean aJoue = joueurActuel.deciderJouerOuPasser(cartesSurLePaquet);

                if (aJoue) {
                    // Vérifie si la carte est jouable en utilisant isCardPlayable
                    if (estCarteDeux(cartesSurLePaquet)) {
                        aJoueDeux = true;
                        dernierJoueur = joueurActuel;
                    } else {
                        aJoueDeux = false;
                        indexJoueurActuel++;
                    }
                } else {
                    joueurActuel.passerTour();
                    aJoueDeux = false;
                    cartesSurLePaquet.clear();
                    indexJoueurActuel++;
                }
            }
        }
    }

    private boolean estCarteDeux(List<Carte> cartesJouees) {
        if (!cartesJouees.isEmpty()) {
            Carte derniereCarte = cartesJouees.get(cartesJouees.size() - 1);
            return derniereCarte.getValeur().equals("2");
        }
        return false;
    }
    private boolean finDuTour(List<Carte> cartesJouees) {
        if (!cartesJouees.isEmpty()) {
            Carte derniereCarte = cartesJouees.get(cartesJouees.size() - 1);
            Carte carteReference = new Carte("2", "Pique"); // Carte de référence pour "2"

            // Utilisez compareTo pour comparer la dernière carte jouée à la carte de référence
            if (derniereCarte.compareTo(carteReference) == 0) {
                return true;
            }
        }
        return false;
    }


    public boolean verifierFinPartie() {
        for (Joueur joueur : joueurs) {
            if (joueur.getCartes().isEmpty()) {
                annoncerGagnant(joueur);
                return true;
            }
        }
        return false;
    }

    private void annoncerGagnant(Joueur gagnant) {
        System.out.println("Le gagnant est " + gagnant.getNom());
    }
}

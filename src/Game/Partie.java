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

    public void executerPartie() {
        int indexJoueurActuel = 0;
        boolean tourTermine = false;

        while (!verifierFinPartie()) {

            Joueur joueurActuel = joueurs.get(indexJoueurActuel % joueurs.size());

            if (dernierJoueur == null || joueurActuel == dernierJoueur) {
                //Afficher les cartes sur le paquet
                System.out.println("Cartes sur le paquet: " + cartesSurLePaquet);
                boolean aJoue = joueurActuel.deciderJouerOuPasser(cartesSurLePaquet);

                if (aJoue) {
                    if (finDuTour(cartesSurLePaquet)) {
                        cartesSurLePaquet.clear();
                        dernierJoueur = joueurActuel;
                        continue;
                    }
                } else {
                    joueurActuel.passerTour();
                }
            }

            indexJoueurActuel++;
        }
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

package Game;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Joueur> joueurs;
    private List<Carte> cartesSurLePaquet;
    private Deck deck;
    private Joueur dernierJoueur; // Le dernier joueur à avoir joué
    private boolean tourTermine; // Indicateur pour savoir si le tour est terminé

    public Partie(List<Joueur> joueurs, Deck deck) {
        this.joueurs = joueurs;
        this.cartesSurLePaquet = new ArrayList<>();
        this.deck = deck;
        this.dernierJoueur = null; // Initialiser le dernier joueur à null
        this.tourTermine = false; // Initialiser l'état du tour
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
        while (!verifierFinPartie()) {
            for (Joueur joueur : joueurs) {
                if (dernierJoueur == null || joueur == dernierJoueur) {
                    if (joueur.peutJouer()) {
                        joueur.jouer(cartesSurLePaquet);
                        if (finDuTour(cartesSurLePaquet)) {
                            tourTermine = true;
                            dernierJoueur = joueur;
                            break;
                        }
                    }
                }
                if (tourTermine) {
                    break;
                }
            }
            if (!tourTermine) {
                // Tous les joueurs ont passé leur tour
                tourTermine = true;
            }
            // Préparer pour le prochain tour
            tourTermine = false;
            cartesSurLePaquet.clear();
        }
    }

    private boolean finDuTour(List<Carte> cartesJouees) {
        for (Carte carte : cartesJouees) {
            if (carte.getValeur().equals("2")) {
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

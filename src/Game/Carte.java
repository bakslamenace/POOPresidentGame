package Game;

// Cette classe représente une carte à jouer avec une valeur et une couleur.
public class Carte implements Comparable<Carte> {
    private final String valeur;  // La valeur de la carte (ex. : "As", "Roi", etc.).
    private final String couleur; // La couleur de la carte (ex. : "Cœur", "Pique", etc.).

    // Constructeur pour initialiser une carte avec sa valeur et sa couleur.
    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    // Renvoie la valeur de la carte.
    public String getValeur() {
        return valeur;
    }

    // Renvoie la couleur de la carte.
    public String getCouleur() {
        return couleur;
    }

    // Renvoie une représentation sous forme de chaîne de la carte (ex. : "As de Cœur").
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

    // Compare cette carte à une autre carte.
    @Override
    public int compareTo(Carte autreCarte) {
        return this.getValeurHierarchie() - autreCarte.getValeurHierarchie();
    }

    // Renvoie un entier représentant la hiérarchie de la valeur de la carte.
    public int getValeurHierarchie() {
        switch (this.valeur) {
            case "3": return 1;
            case "4": return 2;
            case "5": return 3;
            case "6": return 4;
            case "7": return 5;
            case "8": return 6;
            case "9": return 7;
            case "10": return 8;
            case "Valet": return 9;
            case "Dame": return 10;
            case "Roi": return 11;
            case "As": return 12;
            case "2": return 13;
            default: return 0; // Gérer les cas inattendus
        }
    }
}

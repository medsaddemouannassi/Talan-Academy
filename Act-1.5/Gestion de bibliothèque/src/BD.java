public class BD extends Livre {
    boolean color;
    String direction;
    int taille;
    public BD(String titre, String auteur, float prix, int pages, boolean color) {
        super(titre, auteur, prix, pages);
        this.color = color;
        this.direction = "de gauche à droite";
    }
}

public class Manga extends Livre {
    boolean color;
    String direction;
    int taille;
    public Manga(String titre, String auteur, float prix, int pages) {
        super(titre, auteur, prix, pages);
        this.color = false;
        this.direction = "de droite à gauche";
    }
}

public class Livre {
    String tittre;
    String auteur;
    float prix;
    int pages;
    public Livre(String tittre, String auteur , float prix, int pages) {
        this.tittre = tittre;
        this.auteur = auteur;
        this.prix = prix;
        this.pages = pages;
    }
    public void Afficher() {
        System.out.println("Titre: " + this.tittre);
        System.out.println("Auteur: " + this.auteur);
        System.out.println("Prix: " + this.prix + " TND");
        System.out.println("Nombre de pages: " + this.pages);
        System.out.println("------------------------");
    }
}

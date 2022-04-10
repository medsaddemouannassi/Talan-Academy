public class Roman extends Livre {
    int nbChapitre;
    String description;
    public Roman(String titre, String auteur, float prix, int pages) {
        super(titre, auteur, prix, pages);
    }

    public void setNbChapitre(int nbChapitre) {
        this.nbChapitre = nbChapitre;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

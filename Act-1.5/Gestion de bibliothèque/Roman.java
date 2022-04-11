public class Roman extends Livre {
    private int nbChapitre;
    private String description;
    public Roman(String titre, String auteur, float prix, int pages) {
        super(titre, auteur, prix, pages);
    }

    public void setNbChapitre(int nbChapitre) {
        this.nbChapitre = nbChapitre;
    }
    public int getNbChapitre() {
        return this.nbChapitre;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
}

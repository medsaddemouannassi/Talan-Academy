public class MusiqueImpl implements Musique {
    private String titre, autheur, interprete, genre;

    public MusiqueImpl() {

    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setAutheur(String autheur) {
        this.autheur = autheur;
    }

    public String getAutheur() {
        return this.autheur;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getInterprete() {
        return this.interprete;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public String displayMusic() {
        return this.getTitre() + " - " + this.getAutheur() + " - " + this.getInterprete() + " - " + this.getGenre();
    }

    @Override
    public boolean compare(MusiqueImpl music1, MusiqueImpl music2) {
        return music1.getTitre().equals(music2.getTitre()) && music1.getAutheur().equals(music2.getAutheur()) && music1.getInterprete().equals(music2.getInterprete()) && music1.getGenre().equals(music2.getGenre());
    }
}

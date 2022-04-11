public class MusiqueImpl implements Musique {
    private String titre, autheur, interprete, genre;
    public MusiqueImpl(){

    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getTitre() {
        return  this.titre;
    }

    public void setAutheur(String autheur) {
        this.autheur = autheur;
    }
    public String getAutheur() {
        return  this.autheur;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }
    public String getInterprete() {
        return  this.interprete;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return  this.genre;
    }

    @Override
    public String displayMusic() {
        return this.titre;
    }

    @Override
    public boolean compare(MusiqueImpl music1, MusiqueImpl music2) {
        if (music1.titre == music2.titre && music1.autheur == music2.autheur && music1.interprete == music2.interprete && music1.genre == music2.genre) return true;
        return false;
    }
}

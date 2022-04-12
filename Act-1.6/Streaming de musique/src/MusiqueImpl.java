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
    public void displayMusic(Musique musique) {
        System.out.println(this.titre);
    }

    @Override
    public boolean compare(MusiqueImpl music) {
        if (this.getTitre().equalsIgnoreCase(music.titre) && this.getAutheur().equalsIgnoreCase(music.autheur) && this.getInterprete().equalsIgnoreCase(music.interprete) && this.getGenre().equalsIgnoreCase(music.genre)) return true;
        return false;
    }
}

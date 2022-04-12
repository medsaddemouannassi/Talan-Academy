public class PlayListeImpl implements PlayListe {
    final int MAX_MUSIQUES=0;
    private String nom;
    private String genre;
    private int nombreTitres;
    private String[] musicTable = new String[MAX_MUSIQUES];

    public PlayListeImpl() {

    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return this.genre;
    }

    public void setNombreTitres(int nombreTitres) {
        this.nombreTitres = nombreTitres;
    }
    public int getNombreTitres() {
        return this.nombreTitres;
    }

    public void setMusicTable(String[] musicTable) {
        this.musicTable = musicTable;
    }
    public String[] getMusicTable() {
        return this.musicTable;
    }

    @Override
    public void displayMusicPlayList() {

    }

    @Override
    public void addMusic() {

    }

    @Override
    public void deleteDuplicates() {

    }

    @Override
    public void displayMusicTwoPlayList() {

    }

    @Override
    public void triMusicAutheur() {

    }

    @Override
    public void triMusicInterprete() {

    }
}

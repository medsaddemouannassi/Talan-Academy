public abstract class GroupePrédateurs implements GroupePrédateursAction {
    private int taille;
    private String zone;

    public GroupePrédateurs(int taille, String zone) {
        this.setTaille(taille);
        this.setZone(zone);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public void afficherCarac() {
        System.out.println("C'est un groupe composé de " + this.getTaille() + " et situé à la zone du " + this.getZone());
    }

    public abstract void afficherCaracPredateurs(Lion[] coupleDominant);

    @Override
    public void ajouterPredateur() {
        this.taille += 1;
    }

    @Override
    public void enleverPredateur() {
        this.taille -= 1;
    }
}

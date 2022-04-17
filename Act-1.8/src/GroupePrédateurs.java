import java.util.ArrayList;

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
        if (zone.equalsIgnoreCase("sud") || zone.equalsIgnoreCase("nord") || zone.equalsIgnoreCase("east") || zone.equalsIgnoreCase("ouest")) {
            this.zone = zone;
        }
    }

    @Override
    public void afficherCarac() {
        System.out.println("C'est un groupe composé de " + this.getTaille() + " prédateur(s) et situé à la zone du " + this.getZone());
    }

    public abstract void afficherCaracPredateurs();

    @Override
    public void ajouterPredateur(ArrayList groupe, Prédateur prédateur) {
        groupe.add(prédateur);
        System.out.println("Bienvenue!");
    }

    @Override
    public void enleverPredateur(ArrayList groupe, Prédateur prédateur) {
        groupe.remove(prédateur);
        System.out.println("Au revoir!");
    }
}

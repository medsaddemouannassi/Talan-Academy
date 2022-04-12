import java.util.concurrent.atomic.AtomicInteger;

public abstract class Véhicule {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int numéro_matricule;
    private int année_modèle;
    private float prix;
    private int puissance;

    public int getNuméro_matricule() {
        return numéro_matricule;
    }

    public void setNuméro_matricule(int numéro_matricule) {
        if (numéro_matricule == count.incrementAndGet()) this.numéro_matricule = numéro_matricule;
        else System.out.println("Error to generate numéro de matricule " + numéro_matricule);
    }

    public int getAnnée_modèle() {
        return année_modèle;
    }

    public void setAnnée_modèle(int année_modèle) {
        this.année_modèle = année_modèle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Véhicule(int année_modèle, int numéro_matricule, int puissance, float prix) {
        this.setAnnée_modèle(année_modèle);
        this.setNuméro_matricule(numéro_matricule);
        this.setPuissance(puissance);
        this.setPrix(prix);
    }


    public abstract void demarrer();

    public abstract void accelerer();

    public abstract String toString();
}

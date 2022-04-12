public class Camion extends Véhicule {
    public Camion(int année_modèle, int numéro_matricule, int puissance, float prix) {
        super(année_modèle, numéro_matricule, puissance, prix);
    }

    @Override
    public void demarrer() {
        System.out.println("Le camion de " + this.getAnnée_modèle() + ", matricule " + this.getNuméro_matricule() + " démarre!");
    }

    @Override
    public void accelerer() {
        System.out.println("Le camion de " + this.getAnnée_modèle() + ", matricule " + this.getNuméro_matricule() + " accélère!");
    }

    @Override
    public String toString() {
        return "Un camion de " + this.getAnnée_modèle() + ", matricule " + this.getNuméro_matricule() + ", d'une puissance de " + this.getPuissance() + " CV et au prix de " + this.getPrix() + " euros a été enregistré.";
    }
}

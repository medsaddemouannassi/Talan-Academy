import java.util.ArrayList;

public abstract class Prédateur extends Main implements PrédateurAction {
    private String sexe;
    private String categorieAge;
    private int force;
    private ArrayList<Prédateur> groupe = new ArrayList<>();
    private boolean solitaire;

    public Prédateur(String sexe, String categorieAge, int force, ArrayList groupe) {
        this.setSexe(sexe);
        this.setCategorieAge(categorieAge);
        this.setForce(force);
        this.setGroupe(groupe);
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if (sexe.equalsIgnoreCase("male")) this.sexe = "male";
        else if (sexe.equalsIgnoreCase("female")) this.sexe = "female";
        else this.sexe = null;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge.equalsIgnoreCase("jeune") ? "jeune" : categorieAge.equalsIgnoreCase("adulte") ? "adulte" : categorieAge.equalsIgnoreCase("vieux") ? "vieux" : "petit";
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public ArrayList<Prédateur> getGroupe() {
        return groupe;
    }

    public boolean setGroupe(ArrayList groupe) {
        if (groupe == null) return false;
        else groupe.add(this);
        return true;
    }

    public boolean isSolitaire() {
        return solitaire;
    }

    public void setSolitaire(ArrayList<Prédateur> groupe) {
        if (this.setGroupe(groupe)) this.solitaire = false;
        else this.solitaire = true;
    }

    public abstract void chasser(ArrayList groupe);

    public void courir() {
        System.out.println("Courir!!!");
    }

    public void seReproduire() {
        System.out.println("C'est le moment d'avoir un nouveau prédateur!");
    }

    public String son(int type) {
        System.out.println("Oooooooooh!");
        return "Oooooooooooh!";
    }
}

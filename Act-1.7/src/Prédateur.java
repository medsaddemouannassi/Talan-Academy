public abstract class Prédateur extends Main implements PrédateurAction {
    private String sexe;
    private String categorieAge;
    private int force;


    public Prédateur(String sexe, String categorieAge, int force) {
        this.setSexe(sexe);
        this.setCategorieAge(categorieAge);
        this.setForce(force);
    }

    public Prédateur() {

    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if(sexe.equalsIgnoreCase("male"))this.sexe = "male";
        else if(sexe.equalsIgnoreCase("female")) this.sexe = "female";
        else this.sexe = null;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge.equalsIgnoreCase("jeune") ? "jeune" : categorieAge.equalsIgnoreCase("adulte") ? "adulte" : categorieAge.equalsIgnoreCase("vieux") ? "vieux" : null;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void courir() {
        System.out.println("Courir!!!");
    }

    public void seReproduire() {
        System.out.println("C'est le moment d'avoir un nouveau prédateur!");
    }

    public void son() {
        System.out.println("Oooooooooh!");
    }

    public abstract void chasser();
}

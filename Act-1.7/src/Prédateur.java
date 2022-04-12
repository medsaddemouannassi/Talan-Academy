public abstract class Prédateur implements PrédateurAction {
    private String sexe;
    private String categorieAge;
    private int force;
    private String groupe;
    private boolean omnivore;
    private boolean seul;
    private String son;

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public boolean isSeul() {
        return seul;
    }

    public void setSeul(boolean seul) {
        this.seul = seul;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public boolean isOmnivore() {
        return omnivore;
    }

    public void setOmnivore(boolean omnivore) {
        this.omnivore = omnivore;
    }



    public void courir() {

    }
    public void seReproduire() {

    }
    public void son() {
        System.out.println(this.getForce()+"Oooooooooh!");
    }

}

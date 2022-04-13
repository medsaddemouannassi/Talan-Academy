import java.util.ArrayList;

public class Ours extends Prédateur implements OursAction {
    private String agressive;
    private int puissance;
    private String hivernation;

    public Ours(String sexe, String categorieAge, int force, ArrayList groupe, boolean facteurAgress, int puissance, boolean hivernation) {
        super(sexe, categorieAge, force, null);
        this.setAgress(facteurAgress);
        this.setPuissance(puissance);
        this.setHivernation(hivernation);
    }


    public String getAgress() {
        return agressive;
    }

    public void setAgress(boolean agressive) {
        if (agressive) this.agressive = "agressive";
        else this.agressive = "non agressive";
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String isHivernation() {
        return hivernation;
    }

    public void setHivernation(boolean hivernation) {
        if (hivernation) this.hivernation = "en cours";
        else this.hivernation = "terminée";
    }

    @Override
    public void chasser() {
        if (this.hivernation.equals("en cours") || !this.isSolitaire()) System.out.println("Ce n'est pas le moment!");
        else System.out.println("C'est le moment de la chasse!");

    }

    @Override
    public void afficherCarac() {
        System.out.println("C'est un ours " + this.getAgress() + " son hivernation est " + this.isHivernation() + " actuellement. il est d'une puissance de " + this.getPuissance() + " êtres humains");
    }

    @Override
    public void grimper() {
        System.out.println("Grimper!");
    }

    @Override
    public void creuser() {
        System.out.println("Creuser!");
    }

    @Override
    public void hiverner(boolean hivernation) {
        if (hivernation) {
            this.hivernation = "en cours";
            System.out.println("Oof! Enfin, hiverner!!");
        } else {
            this.hivernation = "terminée";
            System.out.println("C'est le moment de sortir!");
        }
    }

    @Override
    public String son(int type) {
        switch (type) {
            case 1:
                System.out.println("Ehh! J'ai peur :'(");
                break;
            case 2:
                System.out.println("Ecoutez! Maintenant je suis là!");
                break;
            case 3:
                System.out.println("Je vais te détruire!!");
                break;
            case 4:
                System.out.println("C'est un plaisir d'écraser les ennemis!");
                break;
        }
        return "hurlement";
    }

    @Override
    public void seNourrir() {
        System.out.println("Miam...miam...C'est un avantage d'être un omnivore!");
    }
}

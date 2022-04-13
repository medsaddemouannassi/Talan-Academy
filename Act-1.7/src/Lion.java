import java.util.ArrayList;

public class Lion extends Prédateur implements LionAction {
    private String dominant;
    private String rangDomination;
    private String impétuosité;

    public Lion(String sexe, String categorieAge, int force, boolean dominant, String rangDomination, boolean impétuosité, ArrayList<Lion> lionGroup) {
        super(sexe, categorieAge, force, lionGroup);
        this.setDominant(dominant);
        this.setRangDomination(rangDomination);
        this.setImpétuosité(impétuosité);
    }

    public String isDominant() {
        return dominant;
    }

    public void setDominant(boolean dominant) {
        if (dominant) this.dominant = "dominant";
        else this.dominant = "non dominant";
    }

    public String getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(String rangDomination) {
        this.rangDomination = rangDomination.equalsIgnoreCase("alpha") ? "ALPHA" : rangDomination.equalsIgnoreCase("beta") ? "BETA" : rangDomination.equalsIgnoreCase("gama") ? "GAMA" : rangDomination.equalsIgnoreCase("omega") ? "OMEGA" : null;
    }

    public String isImpétuosité() {
        return impétuosité;
    }

    public void setImpétuosité(boolean impétuosité) {
        if (impétuosité) this.impétuosité = "impétueux";
        else this.impétuosité = "calme";
    }

    @Override
    public void chasser() {
        if (!this.isSolitaire()) System.out.println("C'est magnifique de chasser en groupe!");
        else System.out.println("STOP! C'est dangereux de chasser seul");
    }

    @Override
    public void afficherCarac() {
        System.out.println("C'est un lion " + this.isImpétuosité() + " et " + this.isDominant() + " avec un rang " + this.getRangDomination());
    }

    @Override
    public String son(int type) {
        switch (type) {
            case 1:
                System.out.println("Hey, les amis! Je suis là!");
                break;
            case 2:
                System.out.println("Je domine, tu t'inclines!");
                break;
            case 3:
                System.out.println("Ok, dorénavant! c'est toi qui domine");
                break;
            case 4:
                System.out.println("Je vais tuer n'importe qui");
                break;
        }
        return "rugissement";
    }

    @Override
    public void entendreSon(String son) {
        if (son.equalsIgnoreCase("rugissement")) System.out.println("Ah! C'est un ami");
        else System.out.println("Ooh! j'entends quelque chose étrange");
    }

    @Override
    public void separer(Lion lion) {
        System.out.println("J'ai besoin de rester seul!");
        lionGroup.remove(lion);
        lion.setGroupe(null);
    }

    @Override
    public void seNourrir() {
        System.out.println("La viance, c'est un délice!");
    }
}

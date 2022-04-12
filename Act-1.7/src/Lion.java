public class Lion extends Prédateur implements LionAction {
    private String dominant;
    private String rangDomination;
    private String impétuosité;

    public Lion(boolean dominant, String rangDomination, boolean impétuosité) {
        super();
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
        System.out.println("C'est magnifique de chasser en groupe!");
    }

    @Override
    public void afficherCarac() {
        System.out.println("C'est un lion " + this.isImpétuosité() + " et " + this.isDominant() + " avec un rang " + this.getRangDomination());
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
    public void son() {
        System.out.println("Rugissement!!!");
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
    }

    @Override
    public void seNourrir() {
        System.out.println("La viance, c'est un délice!");
    }
}

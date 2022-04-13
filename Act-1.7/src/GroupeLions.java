public class GroupeLions extends GroupePrédateurs implements GroupeLionsAction {
    private Lion[] coupleDominant = new Lion[2];
    private int puissance;

    public GroupeLions(int taille, String zone) {
        super(taille, zone);
    }

    public Lion[] getCoupleDominant() {
        return coupleDominant;
    }

    public void setCoupleDominant(Lion[] coupleDominant) {
        this.coupleDominant = coupleDominant;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    @Override
    public void afficherCaracPredateurs(Lion[] coupleDominant) {
        if (this.getCoupleDominant() != null) System.out.println("C'est un groupe de lions composé de " + this.getTaille() + " qui domine à la zone du " + this.getZone() + " grâce à son couple dominant avec une puissance de " + this.getPuissance() + " êtres humains.");
        else System.out.println("C'est un groupe de lions composé de " + this.getTaille() + " situé à la zone du " + this.getZone() + " qui posséde une puissance de " + this.getPuissance() + " êtres humains.");
    }

    @Override
    public void creationCouple(Lion lion1, Lion lion2) {
        if ( ((lion1.getSexe().equalsIgnoreCase("male") && (lion1.isDominant().equalsIgnoreCase("dominant")) || (lion2.getSexe().equalsIgnoreCase("male") && (lion2.isDominant().equalsIgnoreCase("dominant"))) && ((lion1.getSexe().equalsIgnoreCase("female")) || (lion2.getSexe().equalsIgnoreCase("female")))))) {
            Lion[] newCoupleDomiant = new Lion[2];
            newCoupleDomiant[0] = lion1;
            newCoupleDomiant[1] = lion2;
            setCoupleDominant(newCoupleDomiant);
            System.out.println("Couple magnifique!");
        } else {
            System.out.println("Oh! Ce n'est pas possible de créer ce couple!");
        }
    }

    @Override
    public void reproduction(boolean dominant, String rangDomination, boolean impétuosité) {
        new Lion(dominant, rangDomination, impétuosité);
    }

    @Override
    public void lionNonDominant() {

    }
}

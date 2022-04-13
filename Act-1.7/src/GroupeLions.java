import java.util.ArrayList;

public class GroupeLions extends GroupePrédateurs implements GroupeLionsAction {
    private Lion[] coupleDominant = new Lion[2];
    private int puissance;

    public GroupeLions(int taille, String zone, int puissance) {
        super(taille, zone);
        this.setPuissance(puissance);
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
    public void afficherCaracPredateurs(ArrayList<Lion> lionGroup) {
        if (this.getCoupleDominant() != null)
            System.out.println("C'est un groupe de lions composé d'un couple dominant et " + (this.getTaille() - 2) + " lion(s) solitaire(s) situé à la zone du " + this.getZone() + " avec une puissance de " + this.getPuissance() + " êtres humains. ");
        else
            System.out.println("C'est un groupe de lions composé de " + this.getTaille() + " situé à la zone du " + this.getZone() + " qui posséde une puissance de " + this.getPuissance() + " êtres humains.");
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        int p = 0;
        for (Lion lion : lionGroup) {
            if (lion.isDominant().equalsIgnoreCase("non dominant")) i++;
            if (lion.isDominant().equalsIgnoreCase("dominant")) o++;
            if (lion.getRangDomination().equalsIgnoreCase("alpha")) j++;
            if (lion.getRangDomination().equalsIgnoreCase("beta")) k++;
            if (lion.getRangDomination().equalsIgnoreCase("gama")) l++;
            if (lion.getRangDomination().equalsIgnoreCase("omega")) m++;
            if (lion.isImpétuosité().equalsIgnoreCase("impétueux")) n++;
            if (lion.isImpétuosité().equalsIgnoreCase("calme")) p++;
        }
        System.out.println("Il s'agit de: " + o + " lion(s) dominant");
        System.out.println("Il s'agit de: " + i + " lion(s) non dominant");
        System.out.println("Il s'agit de: " + j + " lion(s) alpha");
        System.out.println("Il s'agit de: " + k + " lion(s) beta");
        System.out.println("Il s'agit de: " + l + " lion(s) gama");
        System.out.println("Il s'agit de: " + m + " lion(s) omega");
        System.out.println("Il s'agit de: " + n + " lion(s) impétueux");
        System.out.println("Il s'agit de: " + p + " lion(s) calme");
    }

    @Override
    public void creationCouple(ArrayList<Lion> lionGroup, Lion lion1, Lion lion2) {
        if ((lionGroup.contains(lion1) && lionGroup.contains(lion2)) && (((lion1.getSexe().equalsIgnoreCase("male") && lion1.isDominant().equalsIgnoreCase("dominant")) || (lion2.getSexe().equalsIgnoreCase("male") && lion2.isDominant().equalsIgnoreCase("dominant"))) && (lion1.getSexe().equalsIgnoreCase("female") || lion2.getSexe().equalsIgnoreCase("female")))) {
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
    public void reproduction(String sexe, String categorieAge, int force, boolean dominant, String rangDomination, boolean impétuosité, ArrayList<Lion> lionGroup) {
        lionGroup.add(new Lion(sexe, categorieAge, force, dominant, rangDomination, impétuosité, lionGroup));
        System.out.println("Oh! On a nouveau bébé!");
    }

    @Override
    public void lionNonDominant(ArrayList<Lion> lionGroup) {
        int i = 0;
        for (Lion lion : lionGroup) {
            if (lion.isDominant().equalsIgnoreCase("non dominant")) {
                i++;
            }
        }
        System.out.println("Il y a " + i + " lion(s) non dominant");
    }
}

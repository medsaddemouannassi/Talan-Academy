import java.util.ArrayList;

public class Main {
    public static ArrayList<Lion> lionGroup = new ArrayList<>();


    public static void main(String[] args) {
        Lion lion1 = new Lion("male", "adulte", 7, true, "gama", true, lionGroup);
        Lion lion2 = new Lion("female", "adulte", 5, true, "beta", false, lionGroup);
        Lion lion3 = new Lion("female", "jeune", 6, false, "alpha", false, lionGroup);
        Lion lion4 = new Lion("female", "jeune", 5, true, "omega", true, lionGroup);
        Lion lion5 = new Lion("male", "petit", 2, false, "gama", true, lionGroup);
        Lion lion6 = new Lion("female", "petit", 3, true, "alpha", false, lionGroup);
        Lion lion7 = new Lion("female", "vieux", 3, false, "alpha", true, lionGroup);
        lion1.afficherCarac();
        lion5.afficherCarac();
        lion2.separer();
        lion4.chasser(lionGroup);
        lion6.courir();
        lion7.seNourrir();
        lion2.entendreSon("rugissement");
        lion2.seReproduire();
        lion2.son(3);

        Ours ours1 = new Ours("male","jeune", 9, null,true, 7, true);
        Ours ours2 = new Ours("female", "vielle", 3, null, false, 4, false);
        ours1.afficherCarac();
        ours2.afficherCarac();
        ours1.hiverner(false);
        ours2.hiverner(true);
        ours1.chasser(null);
        ours2.chasser(null);
        ours1.creuser();
        ours1.grimper();
        ours1.seNourrir();
        ours2.son(1);

        GroupeLions lions1 = new GroupeLions(2, "nord",17);
        lions1.creationCouple(lionGroup, lion1, lion3);
        lions1.afficherCarac();
        lions1.afficherCaracPredateurs(lionGroup);
        lions1.lionNonDominant(lionGroup);
        lions1.reproduction(lion3, lion5,"female", "petit", 1, false, "alpha", false, lionGroup);
        lions1.ajouterPredateur(lionGroup, lion2);
        lions1.enleverPredateur(lionGroup, lion2);
    }
}

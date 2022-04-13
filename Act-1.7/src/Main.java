import java.util.ArrayList;

public class Main {
    public static ArrayList<Lion> lionGroup = new ArrayList<>();


    public static void main(String[] args) {
        Lion lion1 = new Lion("male", "adulte", 7, true, "gama", true, lionGroup);
        lion1.afficherCarac();
        Lion lion2 = new Lion("female", "adulte", 5, true, "beta", false, lionGroup);
        Lion lion3 = new Lion("female", "jeune", 6, false, "alpha", false, lionGroup);
        lion2.afficherCarac();
        lionGroup.add(lion1);
        lionGroup.add(lion2);
        lionGroup.add(lion3);
        lion2.separer(lion2);
        lion2.chasser();
        lion2.courir();
        lion2.seNourrir();
        lion2.entendreSon("rugissement");
        lion2.seReproduire();
        lion2.son(3);

        Ours ours1 = new Ours("male","jeune", 9, null,true, 7, true);
        Ours ours2 = new Ours("female", "vielle", 3, null, false, 4, false);
        ours1.afficherCarac();
        ours2.afficherCarac();
        ours1.hiverner(true);
        ours1.chasser();
        ours2.chasser();
        ours2.creuser();
        ours2.grimper();
        ours2.seNourrir();
        ours2.son(1);

        GroupeLions lions1 = new GroupeLions(2, "nord",17);
        lions1.creationCouple(lionGroup, lion1, lion3);
        lions1.afficherCarac();
        lions1.afficherCaracPredateurs(lionGroup);
        lions1.lionNonDominant(lionGroup);
        lions1.reproduction("female", "petit", 1, false, "alpha", false, lionGroup);
    }
}

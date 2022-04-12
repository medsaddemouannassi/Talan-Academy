public class Ours extends Prédateur implements OursAction {
    private int facteurAgress;
    private int puissance;
    private boolean hivernation;



    @Override
    public void chasser(Prédateur prédateur) {
        if (this.isSeul()) {
            System.out.println("Bonne chasse!");
        } else {
            System.out.println("L'ours chasse seul");
        }
    }




    @Override
    public String afficherCarac() {
        return null;
    }

    @Override
    public void grimper() {

    }

    @Override
    public void creuser() {

    }

    @Override
    public void hiverner() {

    }

    @Override
    public void son() {
            System.out.println("Hurlement!!!");
    }

    @Override
    public void seNourrir() {
        System.out.println("C'est un avantage d'être un omnivore!");
    }
}

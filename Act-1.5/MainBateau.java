public class Main {
    public static void main(String[] args) {
        Voile voile = new Voile("Fibres synthétiques", 1920);
        voile.setColour("Brown");
        voile.setType("Génois");
        voile.enrouler(true);
        Mat mat = new Mat("Bois", 7, voile);
        Cabine cabine = new Cabine("Cabine suite", "Bois");

        Pont pont = new Pont("Pont des canons", "Bois", mat);
        Coque coque = new Coque("Double coque", "Bois");
        Bateau monBateau = new Bateau("Rhéa", 1920);
        monBateau.setCoque(coque);
        monBateau.setCabine(cabine);
        monBateau.setPont(pont);
        System.out.println(monBateau);
        System.out.println(coque);
        System.out.println(cabine);
        System.out.println(pont);
    }
}

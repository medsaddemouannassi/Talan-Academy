public class Main {
    public static void main(String[] args) {
        Voile voile = new Voile("Fibres synthétiques", 1920);
        voile.setColour("Brown");
        voile.setType("Génois");
        voile.enrouler(true);
        voile.setId(6);
        Mat mat = new Mat("Bois", 7, voile);
        mat.setId(5);
        Cabine cabine = new Cabine("Cabine suite", "Bois");
        cabine.setId(3);
        Pont pont = new Pont("Pont des canons", "Bois", mat);
        pont.setId(4);
        Coque coque = new Coque("Double coque", "Bois");
        coque.setId(2);
        Bateau monBateau = new Bateau("Rhéa", 1920, coque, pont, cabine);
        monBateau.setId(1);
        System.out.println(monBateau);
        System.out.println(coque);
        System.out.println(cabine);
        System.out.println(pont);
    }
}

public class Main {
    public static void main(String[] args) {
        Livre l1 = new Livre("Le petit prince", "St Exupéry", 10.40f, 50);
        Livre l2 = new Livre("Contes", "Grimm", 14.40f, 254);
        l1.Afficher();
        l2.Afficher();

        BD b1 = new BD("Lucky Luke", "Morris", 10.40f, 45, true);
        BD b2 = new BD("Tintin", "Herge", 200.40f, 45, false);
        b1.Afficher();
        b2.Afficher();

        Manga m1 = new Manga("One piece", "Eiichiro Oda", 5.40f, 62);
        Manga m2 = new Manga("Death Note", "Tsugumi Oba", 7.40f, 75);
        m1.Afficher();
        m2.Afficher();

        Roman r1 = new Roman("Dora", "Dora", 3.5f, 300);
        r1.setNbChapitre(12);
        r1.setDescription("Une description quelconque");

        LivreRecette lrc1 = new LivreRecette("Marmiton", "Philippe Etchebest", 15.98f, 110);
        Recette rc1 = new Recette("Les pâtes crues", "Comment réaliser de délicieuses pâtes crues.", 3);
        rc1.addAstuce("Ne pas les faire cuire.");
        rc1.addEtape("Sortir les pâtes de leur emballage");
        lrc1.addRecette(rc1);
    }
}

public class Main {
    public static void main(String[] args)
    {
        Voiture v = new Voiture(2017,1,5, 7.800f);
        System.out.println(v);
        v.demarrer();
        v.accelerer();

        Camion c = new Camion(2015, 2, 7, 15.200f);
        System.out.println(c);
        c.demarrer();
        c.accelerer();
    }
}

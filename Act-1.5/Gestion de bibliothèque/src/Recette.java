import java.util.*;

public class Recette {
    String nom, description;
    int nivDiff;
    Object recette;

    public Recette(String nom, String description, int nivDiff) {
        this.nom = nom;
        this.description = description;
        this.nivDiff = nivDiff;
    }



    public void addAstuce(String astuce) {
        new Astuce(astuce);
    }

    class Astuce {
        public String astuce;
        public Astuce(String astuce) {
            this.astuce = astuce;
        }
    }

    public void addEtape(String etape) {
        new Etape(etape);
    }

    class Etape {
        public String etape;
        public Etape(String etape) {
            this.etape = etape;
        }
    }
}
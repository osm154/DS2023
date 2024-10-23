package Planet;

public class Pepiniere {

    private Plante[] inventaire;
    private final int MAX_PLANTES = 1000;
    private int nombreDePlantes;

    public Pepiniere() {
        this.inventaire = new Plante[MAX_PLANTES];
        this.nombreDePlantes = 0;
    }

    public void ajoutPlante(Plante plante) {
        if (nombreDePlantes < MAX_PLANTES) {
            inventaire[nombreDePlantes] = plante;
            nombreDePlantes++;
        } else {
            System.out.println("ERREUR.");
        }
    }

    public void afficherInventaire() {
        for (int i = 0; i < nombreDePlantes; i++) {
            inventaire[i].description();
            if (inventaire[i] instanceof Fleur) {
                ((Fleur) inventaire[i]).fleurir();
            }
        }
    }

    public double totalAbsorptionTotaleCO2() {
        double totalAbsorption = 0;
        for (int i = 0; i < nombreDePlantes; i++) {
            if (inventaire[i] instanceof Arbre) {
                totalAbsorption += ((Arbre) inventaire[i]).absorptionCO2();
            }
        }
        return totalAbsorption;
    }

    public int compterArbresCaduques() {
        int count = 0;
        for (int i = 0; i < nombreDePlantes; i++) {
            if (inventaire[i] instanceof Arbre && ((Arbre) inventaire[i]).type_Feuillage.equals("Caduque")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Pépinière GREEN HANDS");
        Pepiniere pépinière = new Pepiniere();
        Fleur rose = new Fleur(null, 30, 12, 15.99, "Rouge", 2);
        Fleur tulipe = new Fleur("Tulipe", 20, 8, 12.99, "Jaune", 4);
        Arbre chêne = new Arbre("Chêne", 200, 60, 89.99, "Caduque");
        Arbre sapin = new Arbre("Sapin", 150, 30, 59.99, "Persistant");
        rose.setNom("Rose");
        System.out.println("la "+rose.getNom()+" a le couleur "+rose.getCouleur());
        pépinière.ajoutPlante(rose);
        pépinière.ajoutPlante(tulipe);
        pépinière.ajoutPlante(chêne);
        pépinière.ajoutPlante(sapin);
        pépinière.afficherInventaire();
        System.out.println("Total Aborption CO2        "+   pépinière.totalAbsorptionTotaleCO2());
        System.out.println("Nombre d'arbres Caduques dans la pépinière : " + pépinière.compterArbresCaduques());
       
    }

}

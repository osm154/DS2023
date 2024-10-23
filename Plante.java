package Planet;

public class Plante {
    protected String nom;
    protected double hauteur;
    protected int age;
    protected double prix;

    public Plante(String nom, double hauteur, int age, double prix) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.age = age;
        this.prix = prix;
    }

    public String toString() {
        return "Nom: " + nom + ", Hauteur: " + hauteur + " cm, Âge: " + age + " mois, Prix: " + prix + " euros";
    }

    public void description() {
        System.out.println(toString());
    }

	protected String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}
}

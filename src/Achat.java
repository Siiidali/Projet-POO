public class Achat {
    public Product p;
    public double prix_achat;
    public Client c;

    public Achat(Product p, double prix_achat, Client c) {
        this.p = p;
        this.prix_achat = prix_achat;
        this.c = c;
    }

    public void afficher() {
        System.out.println("la prix  de l'achat :" + prix_achat);
        System.out.println("le client qui a achete ce produit " + c.Nom + " " + c.Pre);
        System.out.println("le produit acheté est :");
        p.afficher();

    }
}

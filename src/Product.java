public class Product implements Description {
    public String name ;
    public int ref ;
    public double prix ;
    public String type ;
    public  int quantite = 0;

    public  Product() {
        this.name = "";
        this.ref = 0;
        this.prix = 0;
        this.type = "";
    }

    public void afficher()
    {
        System.out.println("Le nom de produit : " + this.name);
        System.out.println("La refference de produit : " + this.ref);
        System.out.println("La prix de ce produit : " + this.prix);
        System.out.println("la quantite de ce produit :" + this.quantite);
        System.out.println("le type de ce produit :" + this.type);
    }

}

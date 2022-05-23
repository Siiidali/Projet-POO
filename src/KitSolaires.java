public class KitSolaires extends Product {
    public double puissance ;
    public double energie ;

    public KitSolaires() {
        super();
    }

    public void afficher() {
        super.afficher();
        System.out.println("la puissance en WAT :" + puissance);
        System.out.println("l'energie en JOULE:" + energie );
    }
}



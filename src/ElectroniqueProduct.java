public class ElectroniqueProduct extends Product {

    public int consomation ;
    public ElectroniqueProduct() {
        super();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("la consomation de ce produit :" + consomation);
    }
}

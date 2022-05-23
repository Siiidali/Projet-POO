public class MobileProduct extends Product{

    public int ram ;
    public int camera ;
    public int stockage ;

    public MobileProduct() {
        super();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("la ram en GB:" + ram);
        System.out.println("la nombre de pixel de camera :" + camera);
        System.out.println("le stockage en GB :" + stockage);
    }
}

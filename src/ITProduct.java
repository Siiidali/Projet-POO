public class ITProduct extends Product {
    public String processur ;
    public int ram ;
    public int disque_dur ;
    public String ecran ;

    public ITProduct() {
        super();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("le processur est  :" + processur);
        System.out.println("la ram en GB :" + ram);
        System.out.println("Stockage de disque dur en GB :" + disque_dur);
        System.out.println("la taille de l'eran :" + ecran);
    }
}

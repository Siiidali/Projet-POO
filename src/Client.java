import java.util.ArrayList;

public class Client implements Description{
    public String Nom, Pre, Adresse , ID;
    public int nbr_achat;
    public double montants_dachats_info_mobil;
    public double montants_dachats_electro;
    public double montants_dachats_kit ;
    private String motdepass ;
    public ArrayList<Achat> achat = new ArrayList<Achat>();
    public Reservation reservation = null;




    public Client(String nom, String pre, String adresse,String ID , String pass) {
        this.Nom = nom;
        this.Pre = pre;
        this.ID = ID ;
        this.Adresse = adresse;
        this.motdepass = pass ;
        nbr_achat = 0;
        montants_dachats_info_mobil = 0;
        montants_dachats_electro = 0;
        montants_dachats_kit = 0 ;


    }

    @Override
    public void afficher() {
        System.out.println("Votre nom et Votre prenom : " + Nom + " " + Pre );
        System.out.println("Votre adresse : " + Adresse );
        System.out.println("Nombres de Produit acheté : " + nbr_achat );
        System.out.println("Votre montants d'achats des produit informatiques et mobiles : " + montants_dachats_info_mobil );
        System.out.println("Votre montants d'achats des produit Electroniques et Electromenagés : " + montants_dachats_electro );
        System.out.println("Votre montants d'achats des produit Kits solaires : " + montants_dachats_kit );
        if(reservation != null) {
            reservation.afficher();
        }else System.out.println("Vous avez pas de Reservation");
    }

    public String getMotdepass() {
        return motdepass;
    }

    public void setMotdepass(String motdepass) {
        this.motdepass = motdepass;
    }
}

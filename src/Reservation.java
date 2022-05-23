import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation implements Description{

    public Product p;
    public Date d_resevation;
    public Date d_fin_reservation;

    public Reservation(Product p, Date d1, Date d2) {
        this.p = p;
        this.d_resevation = d1;
        this.d_fin_reservation = d2;

    }

    @Override
    public void afficher() {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("le produit reservé :" + p.name);
        System.out.println("son prix :" + p.prix);
        System.out.println("la date de reservation :" + format.format(d_resevation));
        System.out.println("la date de l'annulation du reservation :" + format.format(d_fin_reservation));
    }
}

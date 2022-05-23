import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Methode {

    //AJOUT D'UN PRODUIT D'APRES LE MAGASINIER :

    public static void ajout_produit(ArrayList<Product> stock) {
        Product p1 = new Product();
        Scanner sc = new Scanner(System.in);
        System.out.println("quelle est le type de produit que vous voulez ajouté ?");
        System.out.println("1-Produit Mobile\n2-Produit Informatique\n3-Produit Electromenagé\n4-Produit Electronique\n5-Kits scolaires");
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                p1 = new MobileProduct();
                System.out.println("donner le nom de produit que vous voulez ajouté");
                p1.name = sc.next();
                System.out.println("donner la reference de produit que vous voulez ajouté");
                p1.ref = sc.nextInt();
                if (recherchemagsinier(stock, p1.ref) == null) {
                    System.out.println("donner le prix de produit que vous voulez ajouté");
                    p1.prix = sc.nextInt();
                    p1.type = "produit mobile";
                    System.out.println("donner capacité de La ram de produit qui vous voulez ajouté");
                    ((MobileProduct) p1).ram = sc.nextInt();
                    System.out.println("donner le stockage de produit  qui vous voulez ajouté");
                    ((MobileProduct) p1).stockage = sc.nextInt();
                    System.out.println("donner la capicité de la camera de produit  qui vous voulez ajouté");
                    ((MobileProduct) p1).camera = sc.nextInt();
                    System.out.println("donner la quantete de produit que vous voulez ajouté");
                    p1.quantite = sc.nextInt();
                } else System.out.println("Produit desponible ... ajout de quantité");
                break;
            case 2:
                p1 = new ITProduct();
                System.out.println("donner le nom de produit que vous voulez ajouté");
                p1.name = sc.next();
                System.out.println("donner la reference de produit que vous voulez ajouté");
                p1.ref = sc.nextInt();
                if (recherchemagsinier(stock, p1.ref) == null) {
                    System.out.println("donner le prix de produit  qui vous voulez ajouté");
                    p1.prix = sc.nextInt();
                    p1.type = "produit informatique";
                    System.out.println("donner capacité de La ram de produit qui vous voulez ajouté");
                    ((ITProduct) p1).ram = sc.nextInt();
                    System.out.println("donner la capacité de disque dur de produit  qui vous voulez ajouté");
                    ((ITProduct) p1).disque_dur = sc.nextInt();
                    System.out.println("donner la taille de l'ecran de produit  qui vous voulez ajouté");
                    ((ITProduct) p1).ecran = sc.next();
                    System.out.println("donner la capicité de processeur de produit  qui vous voulez ajouté");
                    ((ITProduct) p1).processur = sc.next();
                    System.out.println("donner la quantete de produit que vous voulez ajouté");
                    p1.quantite = sc.nextInt();
                } else System.out.println("Produit desponible ... ajout de quantité");
                break;
            case 3:
                p1 = new ElectromenageProduct();
                p1.type = "produit electronique";
                System.out.println("donner le nom de produit  qui vous voulez ajouté");
                p1.name = sc.next();
                System.out.println("donner la reference de produit  qui vous voulez ajouté");
                p1.ref = sc.nextInt();
                if (recherchemagsinier(stock, p1.ref) == null) {
                    System.out.println("donner le prix de produit  qui vous voulez ajouté");
                    p1.prix = sc.nextInt();
                    System.out.println("donner le poid de produit qui vous voulez ajouté");
                    ((ElectromenageProduct) p1).poid = sc.nextInt();
                    System.out.println("donner la consomation de produit  qui vous voulez ajouté");
                    ((ElectromenageProduct) p1).consomation = sc.nextInt();
                    System.out.println("donner la quantete de produit que vous voulez ajouté");
                    p1.quantite = sc.nextInt();
                } else System.out.println("Produit desponible ... ajout de quantité");
                break;
            case 4:
                p1 = new ElectroniqueProduct();
                p1.type = "produit electronique";
                System.out.println("donner le nom de produit  qui vous voulez ajouté");
                p1.name = sc.next();
                System.out.println("donner la reference de produit  qui vous voulez ajouté");
                p1.ref = sc.nextInt();
                if (recherchemagsinier(stock, p1.ref) == null) {
                    System.out.println("donner le prix de produit  qui vous voulez ajouté");
                    p1.prix = sc.nextInt();
                    System.out.println("donner la consomation de produit  qui vous voulez ajouté");
                    ((ElectroniqueProduct) p1).consomation = sc.nextInt();
                    System.out.println("donner la quantete de produit que vous voulez ajouté");
                    p1.quantite = sc.nextInt();
                } else System.out.println("Produit desponible déja ... ajout de quantité");
                break;
            case 5:
                p1 = new KitSolaires();
                p1.type = "kit solaires";
                System.out.println("donner le nom de produit  qui vous voulez ajouté");
                p1.name = sc.next();
                System.out.println("donner la reference de produit  qui vous voulez ajouté");
                p1.ref = sc.nextInt();
                if (recherchemagsinier(stock, p1.ref) == null) {
                    System.out.println("donner le prix de produit  qui vous voulez ajouté");
                    p1.prix = sc.nextInt();
                    System.out.println("donner l'energie de produit  qui vous voulez ajouté");
                    ((KitSolaires) p1).energie = sc.nextInt();
                    System.out.println("donner la puissance de produit  qui vous voulez ajouté");
                    ((KitSolaires) p1).puissance = sc.nextInt();
                    System.out.println("donner la quantete de produit que vous voulez ajouté");
                    p1.quantite = sc.nextInt();
                } else System.out.println("Produit desponible ... ajout de quantité");
                break;
        }
        if (recherchemagsinier(stock, p1.ref) != null) {
            stock.get(recherchemagsinier2(stock, p1.ref)).quantite++;
        } else {
            stock.add(p1);
        }
        System.out.println("ajout avec succés");
    }

    public static void rechercheClient(ArrayList<Product> stock) {
        String nom;
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le nom de produit que vous voulez recherché");
        nom = sc.nextLine();

        for (int i = 0; i < stock.size(); i++) {
            if ((nom.equalsIgnoreCase((stock.get(i).name)))) {
                System.out.println("Produit est Desponible");
                stock.get(i).afficher();
            } else System.out.println("Produit n'est pas desponible");
            break;
        }
        if (stock.size() == 0) System.out.println("Produit n'est pas desponible");
    }

    public static Product rechercheClientReservation(ArrayList<Product> stock) {
        String type;
        String nom;
        Product p = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le nom de produit que vous voulez reservé");
        nom = sc.nextLine();

        for (int i = 0; i < stock.size(); i++) {
            if ((nom.equalsIgnoreCase((stock.get(i).name))) && ((stock.get(i).quantite) > 0)) {
                System.out.println("desponible");
                stock.get(i).afficher();
                p = stock.get(i);
                return p;
            } else System.out.println("non desponible");
        }
        return p;
    }

    public static Product recherchemagsinier(ArrayList<Product> stock, int ref) {
        Product Pr = null;
        for (int i = 0; i < stock.size(); i++) {
            if ((ref == (stock.get(i).ref))) {
                Pr = stock.get(i);
                return Pr;
            }
        }
        return Pr;
    }

    public static void produit_desponible_magasinier(ArrayList<Product> stock) {
        System.out.println("Donner la reference de produit que vous voulez recherche:");
        Scanner sc = new Scanner(System.in);
        int refff = sc.nextInt();
        if (recherchemagsinier2(stock, refff) != -1) {
            System.out.println("Le produit est disponible dans le stock:");
            System.out.println("-------------------------");
            stock.get(recherchemagsinier2(stock, refff)).afficher();
        } else System.out.println("Le produit n'est pas disponible");

    }

    public static int recherchemagsinier2(ArrayList<Product> stock, int ref) {
        int indice = -1;
        for (int i = 0; i < stock.size(); i++) {
            if ((ref == (stock.get(i).ref))) {
                indice = i;
                return indice;
            }
        }
        return indice;
    }

    public static void supp_product(ArrayList<Product> stock, Product p) {
        stock.remove(p);
    }

    public static void achat(ArrayList<Product> stock, Client c) {
        System.out.println("donner la referecne du produit que vous voulez acheté");
        Scanner sc = new Scanner(System.in);
        int ref = sc.nextInt();
        Product Pr = recherchemagsinier(stock, ref);
        if (Pr != null) {
            Pr.quantite--;
            c.nbr_achat++;
            System.out.println("le prix de produit est " + Pr.prix);
            if (Pr.quantite == 0) {
                supp_product(stock, Pr);

            }
            if ((((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) && (c.montants_dachats_info_mobil != 0)) || (((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) && (c.montants_dachats_electro != 0)) || (((Pr instanceof KitSolaires) && (c.montants_dachats_info_mobil != 0)))) {
                System.out.println("est-ce que vous voulez profité d'une réduction ? \n0-Non\n1-Oui");
                int choix;
                choix = sc.nextInt();
                switch (choix) {
                    case 0:
                        System.out.println("le prix a paye est" + Pr.prix);
                        Achat a = new Achat(Pr, Pr.prix, c);
                        c.achat.add(a);
                        if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                            c.montants_dachats_info_mobil = c.montants_dachats_info_mobil + Pr.prix;
                        } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                            c.montants_dachats_electro = c.montants_dachats_electro + Pr.prix;

                        } else c.montants_dachats_kit = c.montants_dachats_kit + Pr.prix;
                        break;
                    case 1:
                        double PRIX;
                        if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.05);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            Achat a1 = new Achat(Pr, PRIX, c);
                            c.achat.add(a1);
                            c.montants_dachats_info_mobil = 0;
                        } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.1);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            Achat a2 = new Achat(Pr, PRIX, c);
                            c.achat.add(a2);
                            c.montants_dachats_electro = 0;

                        } else {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.15);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            c.montants_dachats_kit = 0;
                        }
                        break;


                }
            } else {
                Achat a = new Achat(Pr, Pr.prix, c);
                c.achat.add(a);
                if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                    c.montants_dachats_info_mobil = c.montants_dachats_info_mobil + Pr.prix;
                } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                    c.montants_dachats_electro = c.montants_dachats_electro + Pr.prix;

                } else c.montants_dachats_kit = c.montants_dachats_kit + Pr.prix;
            }
        } else System.out.println("Produit non desponible");

    }

    public static void rembourcement(ArrayList<Product> stock, Client c) {
        System.out.println("Donner le nom de produit que vous voulez rembourcé");
        Scanner sc = new Scanner(System.in);
        String nom_pro = sc.next();
        for (int i = 0; i < c.achat.size(); i++) {
            if (c.achat.get(i).p.name.equalsIgnoreCase(nom_pro)) {
                if (recherchemagsinier2(stock, c.achat.get(i).p.ref) != -1) {
                    stock.get(recherchemagsinier2(stock, c.achat.get(i).p.ref)).quantite++;
                } else {
                    c.achat.get(i).p.quantite = 1;
                    stock.add(c.achat.get(i).p);
                }
                break;
            } else System.out.println("jamais acheté");
        }
    }

    public static void changementPrixResponsable(ArrayList<Product> stock) {
        System.out.println("Donner la reference de produit que vous voulez modifier");
        Scanner sc = new Scanner(System.in);
        int reffff = sc.nextInt();
        double prix_nouv;
        Product pr;
        int indice = recherchemagsinier2(stock,reffff);
        if (indice != -1) {
            System.out.println("Entrer le nouveau montant de " + stock.get(indice).name);
            prix_nouv = sc.nextDouble();
            stock.get(indice).prix = prix_nouv;
            System.out.println("modification avec succes");
        } else System.out.println("Le produit n'existe pas");
    }

    public static void reservation(ArrayList<Product> stock, Client c) {
        Product p = rechercheClientReservation(stock);
        if (p != null) {
            if (c.reservation == null) {
                System.out.println("--------------------------------------------------");
                System.out.println("reservation avec succes .... vous avez 2 jours avant que votre reservation expert");
                stock.get(recherchemagsinier2(stock, p.ref)).quantite--;
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                Date date2 = date1;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date2);
                calendar.add(Calendar.DATE, 2);
                date2 = calendar.getTime();
                Reservation res = new Reservation(p, date1, date2);
                c.reservation = res;
                System.out.println("la date de reservation :" + format.format(date1));

                System.out.println("la date d'expiration :" + format.format(date2));
                if (stock.get(recherchemagsinier2(stock, p.ref)).quantite == 0) {
                    stock.remove(recherchemagsinier2(stock, p.ref));
                }
            } else System.out.println("Vous avez deja une reservation , vous pouvez pas reserver une 2eme fois");
        } else System.out.println("Produit n'existe pas");
    }

    public static void achat_reservation(ArrayList<Product> stock, Client client) {

        if (client.reservation != null) {
            Date date_actuel = new Date();
            if (date_actuel.before(client.reservation.d_fin_reservation)) {
                achatreserv(stock, client);
            } else {
                System.out.println("Votre reservation a été expiré");
                int indice = recherchemagsinier2(stock, client.reservation.p.ref);
                if (indice == -1) {
                    stock.add(client.reservation.p);
                } else stock.get(indice).quantite++;
            }

        } else System.out.println("Vous avez pas une reservation");
        client.reservation = null;
    }

    public static void achatreserv(ArrayList<Product> stock, Client c) {
        Scanner sc = new Scanner(System.in);
        Product Pr = recherchemagsinier(stock, c.reservation.p.ref);
        if (Pr != null) {
            c.nbr_achat++;
            System.out.println("le prix de produit est " + Pr.prix);
            if (Pr.quantite == 0) {
                supp_product(stock, Pr);
            }
            if ((((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) && (c.montants_dachats_info_mobil != 0)) || (((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) && (c.montants_dachats_electro != 0)) || (((Pr instanceof KitSolaires) && (c.montants_dachats_info_mobil != 0)))) {
                System.out.println("est-ce que vous voulez profité d'une réduction ? \n0-Non\n1-Oui");
                int choix;
                choix = sc.nextInt();
                switch (choix) {
                    case 0:
                        System.out.println("le prix a paye est" + Pr.prix);
                        Achat a = new Achat(Pr, Pr.prix, c);
                        c.achat.add(a);
                        if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                            c.montants_dachats_info_mobil = c.montants_dachats_info_mobil + Pr.prix;
                        } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                            c.montants_dachats_electro = c.montants_dachats_electro + Pr.prix;

                        } else c.montants_dachats_kit = c.montants_dachats_kit + Pr.prix;
                        break;
                    case 1:
                        double PRIX;
                        if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.05);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            Achat a1 = new Achat(Pr, PRIX, c);
                            c.achat.add(a1);
                            c.montants_dachats_info_mobil = 0;
                        } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.1);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            Achat a2 = new Achat(Pr, PRIX, c);
                            c.achat.add(a2);
                            c.montants_dachats_electro = 0;

                        } else {
                            PRIX = Pr.prix - ((c.montants_dachats_info_mobil + Pr.prix) * 0.15);
                            System.out.println("Le prix a payer apres reduction est " + PRIX);
                            c.montants_dachats_kit = 0;
                        }
                        break;


                }
            } else {
                Achat a = new Achat(Pr, Pr.prix, c);
                c.achat.add(a);
                if ((Pr instanceof MobileProduct) || (Pr instanceof ITProduct)) {
                    c.montants_dachats_info_mobil = c.montants_dachats_info_mobil + Pr.prix;
                } else if ((Pr instanceof ElectromenageProduct) || (Pr instanceof ElectroniqueProduct)) {
                    c.montants_dachats_electro = c.montants_dachats_electro + Pr.prix;

                } else c.montants_dachats_kit = c.montants_dachats_kit + Pr.prix;
            }
        }

    }

    public static int client_existe(ArrayList<Client> c, String id) {
        int indice = -1;

        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).ID.equals(id)) {
                indice = i;
                return indice;
            }
        }
        return indice;
    }
}

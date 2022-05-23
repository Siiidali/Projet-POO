import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Methode {
    public static void main(String[] args) {
        ArrayList<Product> stock = new ArrayList<Product>();
        ArrayList<Client> cliens = new ArrayList<Client>();

        String mdp_staff = "electronics123";
        String mdp_responsable = "sidali123";
        Client c = new Client("sidali", "sisaber", "ruisseau", "sidali@gmail.com", "sidali123");
        cliens.add(c);


        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        boolean sortir_menu = false;
        while (sortir_menu == false) {
            System.out.println("Bienvenu au Menu de ELECTRONICS\n");
            System.out.println("Veillez choisir votre espace :\n");
            System.out.println("1-Espace Client\n2-Espace Magasinier\n3-Espace Responsable\n4-S'inscrire a l'espace Client\n0-Sortir");
            Scanner sc = new Scanner(System.in);
            String choix1 = sc.next();
            switch (choix1) {
                case "0":
                    sortir_menu = true;
                    System.out.println("Vous avez quité le menu , Merci ...");
                    break;
                case "1":
                    System.out.println("Donner votre Identifiant :\n");
                    String id_client1 = sc.next();
                    int client_exi = client_existe(cliens, id_client1);
                    boolean sortir_de_mdp = false;

                    if (client_exi != -1) {
                        while (sortir_de_mdp == false) {
                            boolean sortir_client = false;
                            System.out.println("Veuillez saisir votre Mot de pass :\n");
                            String mdp_client = sc.next();
                            if (cliens.get(client_exi).getMotdepass().equals(mdp_client)) {
                                sortir_de_mdp = true;
                                System.out.println("Bienvenu a Votre compte :");
                                System.out.println("-------------------------------------------");

                                while (sortir_client == false) {
                                    System.out.println("Choissez votre Choix\n1-Rechercher un Produit\n2-Reserver un Produit\n3-Rembourcer Un Produit\n4-Afficher mes Informations et mes Reservations\n0-Sortir");
                                    String choix3 = sc.next();
                                    switch (choix3) {
                                        case "1":
                                            rechercheClient(stock);
                                            System.out.println("--------------------------------------------------");
                                            break;
                                        case "2":
                                            reservation(stock, cliens.get(client_exi));
                                            break;
                                        case "3":
                                            rembourcement(stock, cliens.get(client_exi));
                                            break;
                                        case "4":
                                            cliens.get(client_exi).afficher();
                                            break;
                                        case "0":
                                            sortir_client = true;
                                            sortir_de_mdp = true;

                                            break;
                                        default:
                                            System.out.println("Mauvais choix");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Votre mot de pass est incorrecte\nEntrer 1 si vous voulez resseyer\nEntrer n'importe quelle chiffre pour RETOURNER AU MENU");
                                String choix2 = sc.next();
                                switch (choix2) {
                                    default:
                                        sortir_de_mdp = true;
                                        sortir_client = true;
                                        break;
                                    case "1":
                                        break;

                                }

                            }

                        }
                    } else
                        System.out.println("Ce identifiant n'existe pas , Veiller s'inscrire dans le choix numero 4");
                    break;
                case "2":
                    boolean mdp_correct = false;
                    boolean sortir_staff = false;
                    while (mdp_correct == false) {
                        System.out.println("Donner Le mot de pass de Staff");
                        String mdp_staff2 = sc.next();
                        if (mdp_staff2.equals(mdp_staff)) {
                            mdp_correct = true;
                            while (sortir_staff == false) {
                                System.out.println("Bienvenu au compte du Staff :\n");
                                System.out.println("Choissez votre Choix\n1-Achat d'un Produit\n2-Ajouter un Produit\n3-La desponibilité d'Un Produit dans le stock\n0-Sortir");
                                String choix4 = sc.next();
                                switch (choix4) {
                                    case "0":
                                        sortir_staff = true;
                                        break;

                                    case "1":
                                        System.out.println("donner ID de client achteur ");
                                        String id_client2 = sc.next();
                                        if (client_existe(cliens, id_client2) != -1) {
                                            achat(stock, cliens.get(client_existe(cliens, id_client2)));
                                        } else {
                                            System.out.println("Client n'existe pas");
                                            System.out.println("donner les informations de nouveau client : nom - prenom - adress - ID - mot de pass");
                                            Client cli = new Client(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
                                            cliens.add(cli);
                                            achat(stock, cli);
                                        }
                                        break;
                                    case "2":
                                        ajout_produit(stock);
                                        break;
                                    case "3":
                                        produit_desponible_magasinier(stock);
                                        System.out.println("-------------------------");
                                        break;
                                }
                            }

                        } else {
                            System.out.println("Le mot de pass est incorrecte\nEntrer 1 si vous voulez resseyer\nEntrer n'importe quelle chiffre pour RETOURNER AU MENU");
                            String choix5 = sc.next();
                            switch (choix5) {
                                default:
                                    sortir_staff = true;
                                    mdp_correct = true;
                                    break;
                                case "1":
                                    break;
                            }
                        }

                    }
                    break;
                case "3":
                    boolean sortie_res = false;
                    boolean mdp_res_correct = false;
                    while (mdp_res_correct == false) {
                        System.out.println("Donner votre mot de pass : ");
                        String mdp_res = sc.next();

                        if (mdp_res.equals(mdp_responsable)) {
                            mdp_res_correct = true;
                            while (sortie_res == false) {
                                System.out.println("Choissez votre Choix\n1-Modifier le prix d'un produit\n0-Sortie");
                                String choix6 = sc.next();
                                switch (choix6) {
                                    case "1":
                                        changementPrixResponsable(stock);
                                        break;
                                    case "0":
                                        sortie_res = true;
                                        mdp_res_correct = true;
                                        break;
                                }
                            }

                        } else {
                            System.out.println("Le mot de pass est incorrecte\nEntrer 1 si vous voulez resseyer\nEntrer n'importe quelle chiffre pour RETOURNER AU MENU");
                            String choix5 = sc.next();
                            switch (choix5) {
                                default:
                                    sortie_res = true;
                                    mdp_res_correct = true;
                                    break;
                                case "1":
                                    break;
                            }
                        }
                    }
                    break;
                case "4":
                    System.out.println("donner vos informations : nom - prenom - adress - ID - mot de pass");
                    Client cli = new Client(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
                    if(client_existe(cliens,cli.ID) == -1){
                        cliens.add(cli);
                    }else System.out.println("Client existe deja");
                    break;
            }


        }

    }
}




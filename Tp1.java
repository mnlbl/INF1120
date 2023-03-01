import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * INF1120
 * Cette classe permet d'automatiser le système de facturation de la compagnie se nommant Location des Véhicules Écoénergétiques (LVÉ). En effet, l'automatisation facilitera la facturation aux employés. 
 *
 * Prénom/Nom: Manel Baali
 * Code Permanent: BAAM89520207
 * Date de définition de la classe: 17 février 2023
 */
public class Tp1 {
    public static void main (String [] params) {
        // Déclaration des constantes
        final char ELECTRIQUE = 'E';
        final char HYBRIDE = 'H';
        final char GRANDEUR_PETIT = 'P';
        final char GRANDEUR_INTERMEDIAIRE = 'I';
        final char GRANDEUR_GRAND = 'G';
        final char PAIEMENT_DEBIT = 'D';
        final char PAIEMENT_CREDIT = 'C';
        final int  MAXIMUM_JOUR_LOCATION = 180;
        final char TYPE_CREDIT_VISA = 'V';
        final char TYPE_CREDIT_MASTERCARD = 'M';
        final char ASSURANCE_ACCEPTER = 'O';
        final char ASSURANCE_REFUSER = 'N';
        final float TPS = 0.05f;
        final float TVQ = 0.09975f;
        final String MENU = "*** Menu de choix ***";
        final String MENU_FACTURER = "1. Facturer la location d’un véhicule";
        final String MENU_NOMBRE_VEHICULE = "2. Afficher le nombre de véhicules hybrides et électriques loués";
        final String MENU_QUITTER = "3. Quitter le programme";
        final String SAISIR_CHOIX = "Entrez votre choix : " ;
        final String ENTREE_INVALIDE = "Entrée invalide !" ;
        final String NOM_COMPAGNIE = "Location des Véhicules Écoénergétiques";
        final String MESSAGE_BIENVENUE_POINT = "-------------------------------------------------------------------------------------";
        final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de la location des véhicules écoénergétiques";
        final String DATE_PATTERN = "dd-MM-yyyy HH:mm:ss";
        final String ADRESSE_COMPAGNIE = "1200 rue Matata, Hakuna, Québec";
        final String NUMERO_TELEPHONE_COMPAGNIE = "514 848-7733";
        final String MESSAGE_FACTURE_POINT = " ----------------------------------------------------------";
        final String MESSAGE_BYE = " Merci et à la prochaine !";
        
        final float HYBRIDE_PETIT_LOCATION_PRIX = 50.75f;
        final float HYBRIDE_INTERMEDIAIRE_LOCATION_PRIX = 55.25f;
        final float HYBRIDE_GRAND_LOCATION_PRIX = 60.50f;
        final float HYBRIDE_PETIT_ASSURANCE_PRIX = 3.50f;
        final float HYBRIDE_INTERMEDIAIRE_ASSURANCE_PRIX = 4.50f;
        final float HYBRIDE_GRAND_ASSURANCE_PRIX = 5.50f;
        
        final float ELECTRIQUE_PETIT_LOCATION_PRIX = 40.50f;
        final float ELECTRIQUE_INTERMEDIAIRE_LOCATION_PRIX = 45.50f;
        final float ELECTRIQUE_GRAND_LOCATION_PRIX = 50.25f;
        final float ELECTRIQUE_PETIT_ASSURANCE_PRIX = 2.50f;
        final float ELECTRIQUE_INTERMEDIAIRE_ASSURANCE_PRIX = 2.75f;
        final float ELECTRIQUE_GRAND_ASSURANCE_PRIX = 3.25f;
    
         
        
        //Déclaration des variables:
        String prenom;
        String nom;
        String numeroDeTelephone;
        String numeroDePermis;
        String numeroCarteCredit = "";
        String typeVehicule = "";
        String tailleVehicule = "";
        String modeDePaiement = "";
        String typeCarteCredit = "";
        boolean execution = true;
        float prixLocation = 0.0f;
        float prixAssurance = 0.0f;
        int choixMenu;
        char choixVoiture = ' ';
        char grandeurVehicule = ' ';
        int joursLocation = 0;
        char saisiModeDePaiement;
        char saisieTypeCredit;
        char choixAssurance;
        boolean credit = false;
        int factureCompteur = 0;
        int nombreElectriqueLoue = 0;
        int nombreHybrideLoue = 0;

        
        
        //Affichage bienvenu
        System.out.println("    " + MESSAGE_BIENVENUE_POINT); 
        System.out.println("    " + MESSAGE_BIENVENUE);
        System.out.println("    " + MESSAGE_BIENVENUE_POINT); 
        
        //Affichage menu
        while (execution) {
            System.out.println("\n\n" + "     " + "*** Menu de choix ***");
            System.out.println("     " + MENU_FACTURER);
            System.out.println("     " + MENU_NOMBRE_VEHICULE);
            System.out.println("     " + MENU_QUITTER);
            System.out.print("\n\n" + "     "+ SAISIR_CHOIX);
            choixMenu = Clavier.lireInt();
            System.out.println("");

            
            //Options du menu
            if (choixMenu == 1) {
                System.out.print("\n" + "     " + "Entrez le prénom du locataire :   ");
                prenom = Clavier.lireString();
                System.out.print("\n" + "     " + "Entrez le nom du locataire :  "); 
                nom = Clavier.lireString();
                System.out.print("\n" + "     " + "Entrez le numéro de téléphone du locataire : ");
                numeroDeTelephone = Clavier.lireString();
                System.out.print("\n" + "     " + "Entrez le numéro de permis de conduire du locataire : ");
                numeroDePermis = Clavier.lireString();
                boolean valide = false;
                while (!valide) {
                    System.out.print("\n" + "     " + "Entrez le type du véhicule à louer" + "\n" + "     " + "(H ou h pour Hybride, et E ou e pour Électrique) : ");
                    choixVoiture = Character.toUpperCase(Clavier.lireCharLn());
                    switch (choixVoiture){
                         case HYBRIDE:
                             typeVehicule = "Hybride";
                             nombreHybrideLoue++;
                             valide = true;
                             break;
                         case ELECTRIQUE:
                             nombreElectriqueLoue++;
                             typeVehicule = "Électrique";
                             valide = true;
                             break;
                         default:
                             System.out.println("\n" + "     " + ENTREE_INVALIDE + "\n");    
                    }
                }
                valide = false;
                while (!valide) {
                    System.out.print("\n" + "     " + "Entrez la grandeur du véhicule à louer" + "\n" + "     " + "(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) : ");
                    grandeurVehicule = Character.toUpperCase(Clavier.lireCharLn());
                    switch (grandeurVehicule) {
                        case GRANDEUR_PETIT:
                            if (choixVoiture == HYBRIDE){
                                 prixLocation = HYBRIDE_PETIT_LOCATION_PRIX;
                            }else {
                                prixLocation = ELECTRIQUE_PETIT_LOCATION_PRIX;
                            }
                            tailleVehicule = "Petit";
                            valide = true;
                            break;
                        case GRANDEUR_INTERMEDIAIRE:
                            if (choixVoiture == HYBRIDE){
                                 prixLocation = HYBRIDE_INTERMEDIAIRE_LOCATION_PRIX;
                            }else {
                                prixLocation = ELECTRIQUE_INTERMEDIAIRE_LOCATION_PRIX;
                            }
                            tailleVehicule = "Intermédiaire";
                            valide = true;
                            break;
                        case GRANDEUR_GRAND:
                            if (choixVoiture == HYBRIDE){
                                 prixLocation = HYBRIDE_GRAND_LOCATION_PRIX;
                            }else {
                                prixLocation = ELECTRIQUE_GRAND_LOCATION_PRIX;
                            }
                            tailleVehicule = "Grand";
                            valide = true;
                            break;
                        default:
                            System.out.println("\n" + "     " + ENTREE_INVALIDE + "\n");        
                    }
                    
                    
                }
                valide = false;
                while (!valide) {
                    System.out.print("\n" + "     " + "Entrez le nombre de jours de location" + "\n" + "     " + "(supérieur à 0 et inférieur ou égal à 180) : ");
                    joursLocation = Clavier.lireInt();
                    if (joursLocation > 0 && joursLocation <= 180) {
                        valide = true;
                    } else {
                        System.out.println("\n" + "     " + ENTREE_INVALIDE + "\n");        
                    }
                }
                valide = false;
                while (!valide) {
                    System.out.print("\n" + "     " + "Entrez le mode de paiement" + "\n" + "     " + "(D ou d pour Débit, C ou c pour Crédit): ");
                    saisiModeDePaiement = Character.toUpperCase(Clavier.lireCharLn());
                    switch (saisiModeDePaiement) {
                            case PAIEMENT_CREDIT:
                                modeDePaiement = "Crédit";
                                credit = true;
                                valide = true;
                                break;
                            case PAIEMENT_DEBIT:
                                modeDePaiement = "Débit";
                                credit = false;
                                valide = true;
                                break;
                            default:
                                System.out.println ("\n" + "     " + ENTREE_INVALIDE + "\n");
                    }
                }
                valide = false;
                if (credit){
                while (!valide) {
                    System.out.print("\n" + "     " + "Entre le type de la carte de crédit" + "\n" + "     " + "(V ou v pour Visa, et M ou m pour MasterCard): ");
                    saisieTypeCredit = Character.toUpperCase(Clavier.lireCharLn());
                    switch (saisieTypeCredit) {
                            case TYPE_CREDIT_VISA:
                                typeCarteCredit = "Visa";
                                valide = true;
                                break;
                            case TYPE_CREDIT_MASTERCARD:
                                typeCarteCredit = "Mastercard";
                                valide = true;
                                break;
                            default:
                                System.out.println ("\n" + "     " + ENTREE_INVALIDE + "\n");
                    }
                }
                System.out.print("\n" + "     " + "Entre le numéro de la carte de crédit :");
                numeroCarteCredit= Clavier.lireString();
            }
                valide = false;
            while (!valide) {
                    System.out.print("\n" + "     " + "Désirez-vous prendre l'assurance" + "\n" + "     " + "(O ou o pour Oui, N ou n pour Non) ? : ");
                    choixAssurance = Character.toUpperCase(Clavier.lireCharLn());
                    switch (choixAssurance){
                           case ASSURANCE_REFUSER:
                               valide = true;
                               break;
                           case ASSURANCE_ACCEPTER:
                                if (choixVoiture == HYBRIDE) {
                                   switch (grandeurVehicule){
                                        case GRANDEUR_PETIT:
                                            prixAssurance = HYBRIDE_PETIT_ASSURANCE_PRIX;
                                            break;
                                        case GRANDEUR_INTERMEDIAIRE:
                                            prixAssurance = HYBRIDE_INTERMEDIAIRE_ASSURANCE_PRIX;
                                            break;
                                        case GRANDEUR_GRAND:
                                            prixAssurance = HYBRIDE_GRAND_ASSURANCE_PRIX;
                                            break;
                                    }
                                
                                } else {
                                        switch (grandeurVehicule){
                                                case GRANDEUR_PETIT:
                                                    prixAssurance = ELECTRIQUE_PETIT_ASSURANCE_PRIX;
                                                    break;
                                                case GRANDEUR_INTERMEDIAIRE:
                                                    prixAssurance = ELECTRIQUE_INTERMEDIAIRE_ASSURANCE_PRIX;
                                                    break;
                                                case GRANDEUR_GRAND:
                                                    prixAssurance = ELECTRIQUE_GRAND_ASSURANCE_PRIX;
                                                    break;
                                            }
                                }
                                valide = true;
                                break;
                          default:
                                System.out.println ("\n" + "     " + ENTREE_INVALIDE + "\n");
                    }
            }
            valide = true;
            factureCompteur++;
            
            System.out.println("\n" + "    -----------------------------------------------------------------------------------------------");
            System.out.println("       " + NOM_COMPAGNIE);
            System.out.println("       Téléphone : " + "   "+ NUMERO_TELEPHONE_COMPAGNIE);
            System.out.println("       Adresse : " + "     " + ADRESSE_COMPAGNIE);
            LocalDateTime dateHeureSysteme = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            System.out.println("       Date et Heure: " + dateHeureSysteme.format(formatter));
            System.out.println("       Facture No: " + "   " + factureCompteur);
            System.out.println("    -----------------------------------------------------------------------------------------------" + "\n");
            
            System.out.println("       Prénom et nom : " + prenom + " " + nom);
            System.out.println("       Téléphone : " +  numeroDeTelephone);
            System.out.println("       Permis de conduire : " + numeroDePermis + "\n");
            
            System.out.println("       Type du véhicule : " + typeVehicule);
            System.out.println("       Grandeur du véhicule : " +  tailleVehicule);
            System.out.println("       Mode de paiement : " +  modeDePaiement);

            if (credit) {
              System.out.println("       Type de la carte de crédit : " + typeCarteCredit);
              System.out.println("       Numéro de la carte de crédit : " + numeroCarteCredit );

            }
            
            System.out.println("\n" + "       Nombre de jours de location          " + joursLocation);
            System.out.printf("       Prix de la location par jour         %.2f%s", prixLocation, "$\n");
            System.out.printf("       Prix de l'assurance par jour         %.2f%s", prixAssurance, "$\n");

            float prixLocationTotal = prixLocation * joursLocation;
            float prixAssuranceTotal = prixAssurance * joursLocation;
            float sousTotal = (prixLocationTotal + prixAssuranceTotal);
            float prixTps = sousTotal * TPS;
            float prixTvq = sousTotal * TVQ;
            float total = sousTotal + prixTps + prixTvq;
            
            System.out.println("\n");
            System.out.printf("       Montant de la location               %.2f%s", prixLocationTotal, "$\n");
            System.out.printf("       Montant de l'assurance               %.2f%s", prixAssuranceTotal, "$\n\n");

            System.out.printf("       Sous-total                           %.2f%s", sousTotal, "$\n");
            System.out.printf("       Montant TPS                          %.2f%s", prixTps, "$\n");
            System.out.printf("       Montant TVQ                          %.2f%s", prixTvq, "$\n");
            System.out.printf("       Montant total                        %.2f%s", total, "$\n");
            System.out.println("           ------------------------------------------------------");
            System.out.println("                       Merci pour votre confiance!" +"\n\n");
            prixAssurance = 0.0f;
            prixLocation = 0.0f;
        }
        else if (choixMenu == 2){
            LocalDateTime dateHeureSysteme = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            System.out.println("    " + MESSAGE_FACTURE_POINT);
            System.out.println("       " + NOM_COMPAGNIE);
            System.out.println("       " + "Date et Heure: " + dateHeureSysteme.format(formatter));
            System.out.println("    " + MESSAGE_FACTURE_POINT + "\n");
            System.out.println("       " + "Nombre de véhicules hybrides loués       " + nombreHybrideLoue);
            System.out.println("       " + "Nombre de véhicules électriques loués    " + nombreElectriqueLoue + "\n");
            System.out.println("    " + MESSAGE_FACTURE_POINT + "\n");
        } 
        else if (choixMenu == 3){
            execution = false;
            System.out.print("\n" + "    " + MESSAGE_BYE );
        }
            else { System.out.println("     Entrée invalide !"); 
        }
     } 
   } 
 }





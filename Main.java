import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionRV gestionRV = new GestionRV();
        Scanner scanner = new Scanner(System.in);

        int choix;

        do {
            System.out.println("\nMenu de gestion des rendez-vous médicaux:");
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Lister les patients");
            System.out.println("3. Enregistrer un rendez-vous");
            System.out.println("4. Lister les rendez-vous par état");
            System.out.println("5. Lister les rendez-vous par spécialité");
            System.out.println("6. Traiter un rendez-vous");
            System.out.println("7. Quitter");

            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choix) {
                case 1:
                    System.out.print("Nom du patient: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom du patient: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Téléphone du patient: ");
                    String telephone = scanner.nextLine();
                    gestionRV.ajouterPatient(nom, prenom, telephone);
                    System.out.println("Patient ajouté avec succès.");
                    break;
                case 2:
                    System.out.println("Liste des patients:");
                    gestionRV.listerPatients();
                    break;
                case 3:
                    System.out.print("Nom du patient: ");
                    String patientNom = scanner.nextLine();
                    System.out.print("État du rendez-vous (En cours, Validé, Annulé): ");
                    String etat = scanner.nextLine();
                    System.out.print("Spécialité du rendez-vous: ");
                    String specialite = scanner.nextLine();

                    Patient patient = gestionRV.getPatientByName(patientNom);
                    if (patient != null) {
                        gestionRV.enregistrerRV(patient, etat, specialite);
                        System.out.println("Rendez-vous enregistré avec succès.");
                    } else {
                        System.out.println("Patient introuvable. Veuillez vérifier le nom du patient.");
                    }
                    break;
                case 4:
                    System.out.print("État des rendez-vous à afficher (En cours, Validé, Annulé): ");
                    String etatRecherche = scanner.nextLine();
                    System.out.println("Liste des rendez-vous pour l'état " + etatRecherche + ":");
                    gestionRV.listerRVParEtat(etatRecherche);
                    break;
                case 5:
                    System.out.print("Spécialité des rendez-vous à afficher: ");
                    String specialiteRecherche = scanner.nextLine();
                    System.out.println("Liste des rendez-vous pour la spécialité " + specialiteRecherche + ":");
                    gestionRV.listerRVParSpecialite(specialiteRecherche);
                    break;
                case 6:
                    System.out.print("ID du rendez-vous à traiter: ");
                    String rvId = scanner.nextLine();
                    System.out.print("Nouvel état du rendez-vous (En cours, Validé, Annulé): ");
                    String nouvelEtat = scanner.nextLine();

                    RV rv = gestionRV.getRVById(rvId);
                    if (rv != null) {
                        gestionRV.traiterRV(rv, nouvelEtat);
                    } else {
                        System.out.println("Rendez-vous introuvable. Veuillez vérifier l'ID du rendez-vous.");
                    }
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 7);

        scanner.close();
    }
}
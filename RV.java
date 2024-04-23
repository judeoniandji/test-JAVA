public class RV {
    private static int rvCount = 0;
    private String id;
    private Patient patient;
    private String etat;
    private String specialite;

    public RV(Patient patient, String etat, String specialite) {
        this.id = generateRVId();
        this.patient = patient;
        this.etat = etat;
        this.specialite = specialite;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getEtat() {
        return etat;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setEtat(String nouvelEtat) {
        if (nouvelEtat.equalsIgnoreCase("En cours") || nouvelEtat.equalsIgnoreCase("Validé") || nouvelEtat.equalsIgnoreCase("Annulé")) {
            this.etat = nouvelEtat;
        } else {
            System.out.println("État non valide. Les états autorisés sont : En cours, Validé, Annulé.");
        }
    }

    private String generateRVId() {
        return String.format("RV%04d", ++rvCount);
    }
}
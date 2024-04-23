public class Patient {
    private static int count = 0;
    private String id;
    private String nom;
    private String prenom;
    private String telephone;

    public Patient(String nom, String prenom, String telephone) {
        this.id = generatePatientId();
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    private String generatePatientId() {
        return String.format("PAT%04d", ++count);
    }
}

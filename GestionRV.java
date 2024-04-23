import java.util.ArrayList;
import java.util.List;

public class GestionRV {
    private List<Patient> patients;
    private List<RV> rvs;

    public GestionRV() {
        this.patients = new ArrayList<>();
        this.rvs = new ArrayList<>();
    }

    public void ajouterPatient(String nom, String prenom, String telephone) {
        Patient patient = new Patient(nom, prenom, telephone);
        this.patients.add(patient);
    }

    public void listerPatients() {
        for (Patient patient : this.patients) {
            System.out.println(patient.getNom());
        }
    }

    public void enregistrerRV(Patient patient, String etat, String specialite) {
        RV rv = new RV(patient, etat, specialite);
        this.rvs.add(rv);
    }

    public void listerRVParEtat(String etat) {
        for (RV rv : this.rvs) {
            if (rv.getEtat().equals(etat)) {
                System.out.println(rv.getPatient().getNom());
            }
        }
    }

    public void listerRVParSpecialite(String specialite) {
        for (RV rv : this.rvs) {
            if (rv.getSpecialite().equals(specialite)) {
                System.out.println(rv.getPatient().getNom());
            }
        }
    }

    public void traiterRV(RV rv, String nouvelEtat) {
        rv.setEtat(nouvelEtat);
        System.out.println("État du rendez-vous mis à jour avec succès.");
    }

    public RV getRVById(String rvId) {
        for (RV rv : rvs) {
            if (rv.getId().equals(rvId)) {
                return rv;
            }
        }
        return null;
    }

    public Patient getPatientByName(String patientNom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPatientByName'");
    }}
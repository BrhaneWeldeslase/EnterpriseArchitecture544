import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Payment payment = new Payment("11/02/2018", 309.00);
        //em.persist(payment);
        Patient patient = new Patient("Semhar", "900 N st", "52556", "Fairfield");
        em.persist(patient);
        Doctor doctor = new Doctor("Dentist", "Berhane", "Weldesilassie");
        em.persist(doctor);
        Appointement appt = new Appointement("12/12/2019", payment, patient, doctor);
        em.persist(appt);


        em.getTransaction().commit();
        emf.close();
    }
}

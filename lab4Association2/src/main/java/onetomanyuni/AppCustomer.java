package onetomanyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppCustomer {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws ParseException {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat sf = new SimpleDateFormat("MM/DD/YYYY");

        em.getTransaction().begin();

        Customer c = new Customer("Sami", "Gebre");
        Reservation r = new Reservation("Amore Mio", sf.parse("12/12/2012"));
        c.getReservation().add(r);
        em.persist(c);


        em.getTransaction().commit();
        em.close();

    }
}

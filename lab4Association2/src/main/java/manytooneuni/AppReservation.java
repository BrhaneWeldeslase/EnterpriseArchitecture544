package manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppReservation {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws ParseException {
        emf= Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat sf = new SimpleDateFormat("MM/DD/YYYY");

        em.getTransaction().begin();

        Book b = new Book("WAA","A1234");
        em.persist(b);
        Rservation r = new Rservation("Fairfield PL",sf.parse("12/12/2019"),b);

        em.persist(r);


        em.getTransaction().commit();
        em.close();
    }
}

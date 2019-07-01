package excercise1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppCustomer {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws ParseException {
        emf= Persistence.createEntityManagerFactory("cs544");
        SimpleDateFormat sf = new SimpleDateFormat("MM/DD/YYYY");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Customer cs = new Customer("Semhar", "Weldegiorgis");
//        em.persist(cs);
        Order o = new Order(sf.parse("12/12/2019"));
        Product cd = new CD("Song", "ROM","Robi");
        Product dvd = new DVD("Movie","Compressed", "A Walk to Remember");
        Product book = new Book("Fiction", "Based on true story", "Agatachristi");

        //Product p = new Product("Shoes", "Hills");
        em.persist(cd);
        em.persist(dvd);
        em.persist(book);
//        OrderLine ol = new OrderLine(2, );
//        em.persist(o);


        em.getTransaction().commit();

        emf.close();
    }
}

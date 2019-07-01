package manytomanybi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppStudent {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student st = new Student(1234, "Semhar", "Wldegiorgis");
        Student st2 = new Student(2341,"Genet", "Isaak");
        Course crs = new Course("WAA", 5);
        Course crs2 = new Course("EA", 5);

        crs.addStudent(st);
        em.persist(crs);
        crs2.addStudent(st);
        em.persist(crs2);
        crs.addStudent(st2);
        em.persist(crs);
        crs2.addStudent(st2);
       em.persist(crs2);



        em.getTransaction().commit();
        em.close();

    }
}

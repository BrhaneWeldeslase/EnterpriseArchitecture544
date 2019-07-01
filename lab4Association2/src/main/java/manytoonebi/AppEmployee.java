package manytoonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEmployee {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp1 = new Employee("Semhar", "Weldegiorgis");
        Office of = new Office("900 N St");
        of.addEmployee(emp1);

        em.persist(emp1);

        em.getTransaction().commit();
        em.close();

    }
}


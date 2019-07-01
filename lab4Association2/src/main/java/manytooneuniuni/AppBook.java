package manytooneuniuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppBook
{
    private static EntityManagerFactory emf;

    public static void main(String[] args){
        emf= Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Publisher p = new Publisher("Tina","Xing");
        Book bk = new Book("WAA","A-1234",p);
        bk.setPublisher(p);
        em.persist(p);
        em.persist(bk);

        em.getTransaction().commit();
        em.close();
    }
}

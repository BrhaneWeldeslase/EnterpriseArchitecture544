package edu.mum.cs544.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppSchool {

    private static EntityManagerFactory emf;

    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        School scl = new School("MUM");
        Student sdt1 = new Student(5678);
        Student sdt2 = new Student(1234);
        scl.addStudent(sdt1);
        scl.addStudent(sdt2);
        em.persist(scl);

        em.getTransaction().commit();
        emf.close();
    }

}

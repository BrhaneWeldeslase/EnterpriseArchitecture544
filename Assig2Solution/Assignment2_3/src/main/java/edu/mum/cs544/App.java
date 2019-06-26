package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {

            emf = Persistence.createEntityManagerFactory("edu.mum.cs544.Students");

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            // retieve all cars
            TypedQuery<Students> query = em.createQuery("from Students", Students.class);

        List<Students> studentsList = query.getResultList();
        for (Students student : studentsList) {
            System.out.println("name= " + student.getName() + ", email= "
                    + student.getEmail() + ", password= " + student.getPassword());
        }
            em.close();


        em = emf.createEntityManager();
         em.getTransaction().begin();
        Students student = new Students(3000,"Hiwot", "hiwot@gmail.com","hiwot");
        em.persist(student);
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query1 = em.createQuery("from Students", Students.class);

        List<Students> studentsList1 = query1.getResultList();
        for (Students student1 : studentsList1) {
            System.out.println("name= " + student1.getName() + ", email= "
                    + student.getEmail() + ", password= " + student.getPassword());
        }

        em.close();
        }
    }


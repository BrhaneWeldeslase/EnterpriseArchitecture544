package edu.mum.cs544.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

            Laptop laptop1 = new Laptop("980","dell");
            Laptop laptop2 = new Laptop("980","dell");

            Employee employee1 = new Employee("brhane");

            employee1.addLaptop(laptop1);
            employee1.addLaptop(laptop2);

            em.persist(employee1);

        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        em.getTransaction().begin();

            TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);

            List<Employee> employeeList = query.getResultList();
                    for (Employee e : employeeList) {
                        System.out.println("Name= " + e.getName());
                    }

        em.getTransaction().commit();
        em.close();

    }

}

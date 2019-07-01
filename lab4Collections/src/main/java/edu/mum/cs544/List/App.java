package edu.mum.cs544.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.ArrayList;

public class App {

    private static EntityManagerFactory emf;
    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

            Passenger p1 = new Passenger("brhane", "weldeslase");
            Passenger p2 = new Passenger("Robel", "Gebreweld");
            em.persist(p1);
            em.persist(p2);

            List<Passenger> pList = new ArrayList();
            pList.add(p1);
            pList.add(p2);

            Flight myFlight = new Flight("1020", "sanjose","De moine",pList);

            em.persist(myFlight);


        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        em.getTransaction().begin();

//            TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
//
//            List<Employee> employeeList = query.getResultList();
//                    for (Employee e : employeeList) {
//                        System.out.println("Name= " + e.getName());
//                    }
            TypedQuery<Flight> query = em.createQuery("from Flight", Flight.class);
            List<Flight> flightList = query.getResultList();

            for(Flight f:flightList){
                System.out.println("flight No " + f.getNumber()+ " " + "Departed from " + f.getFrom()+ " "
                + "Arrived to " + f.getTo ());
            }

        em.getTransaction().commit();
        em.close();

    }

}

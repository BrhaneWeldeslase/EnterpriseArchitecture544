package edu.mum.cs544;

import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A: Flights leaving USA capacity > 500");

        List<Flight> flights = em.createQuery("select fl from Flight as fl " +
                "join fl.airplane as ap " +
                "join fl.origin as ori  " +
                        "where ap.capacity>500 " + "and ori.country = 'USA'",
                Flight.class).getResultList();


        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
//        for (Flight flight : flights) {
//            System.out.println(flight.getOrigin().getCountry());
//        }
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(),
                    flight.getOrigin().getCity(),
                    flight.getDepartureDate(),
                    flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(),
                    flight.getArrivalTime());
                    //flight.getOrigin().getCountry();
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C: Flights using 747 planes that don't belong to Star Alliance");
        flights = em.createQuery("select fl from Flight as fl" +
                " join fl.airline as aln " +
                " join fl.airplane as apl " +
                "where apl.model = '747' " +
                "and aln.name <>'Star Alliance'", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D: All flights leaving before 12pm on 08/07/2009");
        TypedQuery<Flight> query = em.createQuery("select fl from Flight as fl" , Flight.class);
//                "where fl.departureDate = ':date' " +
//                "and fl.departureTime < ':time'", Flight.class);
       // query.setParameter("date", "8/6/09");
       // query.setParameter("time", "12:00 PM");
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();
    }
}

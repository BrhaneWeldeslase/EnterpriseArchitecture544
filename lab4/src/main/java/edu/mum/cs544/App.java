package edu.mum.cs544;

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

            Owner owner1 = new Owner("brhane", "akria 1007");
            Car c1 = new Car("bmw", "1999", 23799,owner1);
            em.persist(c1);

            Owner owner2 = new Owner("robel", "gejeret 9907");
            Car c2 = new Car("mercedez", "2016", 40000,owner2);
            em.persist(c2);

        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        em.getTransaction().begin();

//            // retieve all cars
//            TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);

//            List<Owner> ownersList = query.getResultList();
//            for (Owner owner : ownersList) {
//                System.out.println("name= " + owner.getName() + ", address= "
//                        + owner.getAddress() + ", id= " + owner.getId());
//            }

                    TypedQuery<Car> query = em.createQuery("from Car", Car.class);

            List<Car> carList = query.getResultList();
            for (Car c : carList) {
                System.out.println("brand= " + c.getBrand() + ", year= "
                        + c.getYear() + ", id= " + c.getId()+ ", price= " + c.getPrice()
                        + ", id= " + c.getOwner().getName() + ", address= " + c.getOwner().getAddress());
            }
        em.getTransaction().commit();
        em.close();


//
    }

}

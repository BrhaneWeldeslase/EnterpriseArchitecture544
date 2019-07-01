package onetomanybi;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppDepartement {
    private static EntityManagerFactory emf;

    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department dep = new Department("fairfield", "registration");
        Employee emp = new Employee("semi","welde");
        dep.addEmployee(emp);
        em.persist(dep);

        em.getTransaction().commit();
        em.close();
    }
}

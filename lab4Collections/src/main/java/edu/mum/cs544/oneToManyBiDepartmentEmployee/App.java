package edu.mum.cs544.oneToManyBiDepartmentEmployee;

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

            Employee e1 = new Employee("Brhane");
            Employee e2 = new Employee("Solomon");
            Employee e3 = new Employee("Sirak");

            Department d = new Department("Finance","Asmara");

           d.addEmployee(e1);
           d.addEmployee(e2);
           d.addEmployee(e3);

            em.persist(d);

        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        em.getTransaction().begin();
//
//            TypedQuery<edu.mum.cs544.oneToManyBiDepartmentEmployee.Employee> query = em.createQuery("from Employee", edu.mum.cs544.oneToManyBiDepartmentEmployee.Employee.class);
//
//            List<edu.mum.cs544.oneToManyBiDepartmentEmployee.Employee> employeeList = query.getResultList();
//                    for (edu.mum.cs544.oneToManyBiDepartmentEmployee.Employee e : employeeList) {
//                        System.out.println("Name= " + e.getName());
//                    }



        em.getTransaction().commit();
        em.close();

    }

}

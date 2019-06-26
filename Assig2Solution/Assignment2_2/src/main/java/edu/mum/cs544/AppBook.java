package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppBook {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of book and set values in it
        Book book1 = new Book("love","123abc","brhane",100);
        em.persist(book1);

        Book book2 = new Book("fictious","234rty","Robel",200);
        em.persist(book2);

        Book book3 = new Book("lastSuper","456fdf","Tina",300);
        em.persist(book3);

        em.getTransaction().commit();
        em.close();



        em = emf.createEntityManager();
        //em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all books
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("title= " + book.getTitle()+ ", price= "
                    + book.getPrice() + ", author= " + book.getAuthor());
        }
        em.getTransaction().commit();
        em.close();





        em = emf.createEntityManager();

        em.getTransaction().begin();
        //Retrieve all books from the database

        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();


        //Change the title and price of one book
        Book bk1 = bookList.get(0);
        bk1.setPrice(111);
        bk1.setTitle("sport");


         //Use em.remove() to delete a different book (not the one that was just updated)
        Book bk2 = bookList.get(1);
        em.remove(bk2);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();


        for (Book book : bookList) {
            System.out.println("title= " + book.getTitle()+ ", price= "
                    + book.getPrice() + ", author= " + book.getAuthor());
        }

        em.getTransaction().commit();
        em.close();


    }
}


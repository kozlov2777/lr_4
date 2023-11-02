package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import models.Book;

public class BookService {
    private final EntityManager entityManager;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<Book> getAllBooks() {
        String jpql = "SELECT b FROM Book b";
        TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
        return query.getResultList();
    }

    public void createBook(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public void updateBook(Book updatedBook) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(updatedBook); // оновлення об'єкта
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteBook(int bookId) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Book bookToDelete = entityManager.find(Book.class, bookId);
            if (bookToDelete != null) {
                entityManager.remove(bookToDelete); // видалення об'єкта
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}



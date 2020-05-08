package pl.hibernate.orm;

import pl.hibernate.orm.dao.AuthorDao;
import pl.hibernate.orm.dao.BookDao;
import pl.hibernate.orm.embedded.Address;
import pl.hibernate.orm.entities.Author;
import pl.hibernate.orm.entities.Book;
import pl.hibernate.orm.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class OrmApplication {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();

        BookDao bookDao = new BookDao(entityManager);

        Date date = new Date();
        Book bookEntity1 = createBook(entityManager, bookDao, "Płeć mózgu", date, 9788390021010L);
        Book bookEntity2 = createBook(entityManager, bookDao, "Otoczeni przez psychopatów", date, 9788389405005L);

        List<Book> books = bookDao.findAll();
        for(Book book:books) {
            System.out.println(book);
        }

        System.out.println(bookDao.findById(1L));
        System.out.println(bookDao.findById(2L));
        bookDao.delete(bookEntity1);
        bookDao.delete(bookEntity2);
        System.out.println(bookDao.findById(1L));
        System.out.println(bookDao.findById(2L));

        AuthorDao authorDao = new AuthorDao(entityManager);

        Address address1 = new Address("Leśna", "2", "3", "33-000", "Wrocław", "Polska");
        Address address2 = new Address("Polna", "5", "17", "33-090", "Warszawa", "Polska");
        Author authorEntity1 = createAuthor(entityManager, authorDao, "David", "Jessel", date, address1);
        Author authorEntity2 = createAuthor(entityManager, authorDao, "Thomas", "Erikson", date, address2);

        List<Author> authors = authorDao.findAll();
        for(Author author:authors) {
            System.out.println(author);
        }

        System.out.println(authorDao.findById(1000L));
        System.out.println(authorDao.findById(1001L));
        authorDao.delete(authorEntity1);
        authorDao.delete(authorEntity2);
        System.out.println(authorDao.findById(1000L));
        System.out.println(authorDao.findById(1001L));

        HibernateUtil.closeEntityManager();
    }

    private static Book createBook(EntityManager entityManager, BookDao bookDao, String title, Date publicationDate, Long isbn) {
        Book bookEntity = new Book(title, publicationDate, isbn);
        entityManager.getTransaction().begin();
        bookDao.save(bookEntity);
        entityManager.getTransaction().commit();
        return bookEntity;
    }

    private static Author createAuthor(EntityManager entityManager, AuthorDao authorDao, String name, String surname, Date birthDate, Address address) {
        Author authorEntity = new Author(name, surname, birthDate, address);
        entityManager.getTransaction().begin();
        authorDao.save(authorEntity);
        entityManager.getTransaction().commit();
        return authorEntity;
    }
}

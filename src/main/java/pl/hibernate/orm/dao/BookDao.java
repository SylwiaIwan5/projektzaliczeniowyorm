package pl.hibernate.orm.dao;

import pl.hibernate.orm.entities.Book;

import javax.persistence.EntityManager;

public class BookDao extends AbstractDao<Book> {
    public BookDao(EntityManager em) {
        super(em, Book.class);
    }
}

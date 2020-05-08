package pl.hibernate.orm.dao;

import pl.hibernate.orm.entities.Author;

import javax.persistence.EntityManager;

public class AuthorDao extends AbstractDao<Author> {
    public AuthorDao(EntityManager em) {
        super(em, Author.class);
    }
}

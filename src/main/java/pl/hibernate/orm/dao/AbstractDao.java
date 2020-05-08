package pl.hibernate.orm.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class AbstractDao<T> {
    protected EntityManager em;
    private Class<T> entityClass;

    public AbstractDao(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public List<T> findAll() {
        return em.createQuery("from " + entityClass.getName()).getResultList();
    }

    public T findById(Long id) {
        return em.find(entityClass, id);
    }

    public void delete(T entity) {
        em.remove(entity);
    }
}

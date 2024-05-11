package cz.cvut.fel.dbs.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.Savepoint;
import java.util.List;

public class BaseDAO<T> {

    protected final Class<T> type;

    @PersistenceContext
    protected EntityManager entityManager;

    protected BaseDAO(Class<T> type) {
        this.type = type;
    }

    protected BaseDAO(Class<T> type, EntityManager entityManager) {
        this.type = type;
        this.entityManager = entityManager;
    }

    public void insert(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(int id) {
        T entity = entityManager.find(type, id);
        entityManager.remove(entity);
    }

    public T findById(int id) {
        return entityManager.find(type, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }
}

package com.example.goodreads.data.dao.impl;

import com.example.goodreads.data.dao.IGenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class GenericDAOImpl<E> implements IGenericDAO<E> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<E> entityType;

    GenericDAOImpl(Class<E> entityType) {
        this.entityType = entityType;
    }

    /**
     * Generic method to persist entity
     * @param e entity to be persisted
     */
    @Override
    public void persist(E e) {
        entityManager.persist(e);
    }

    /**
     * Generic method to fetch entity by primary id
     * @param id primary key of the entity
     * @return the managed instance which was fectched against the id
     * @throws @{@link NullPointerException} if entity not found
     */
    @Override
    public E fetchEntityById(Serializable id) {
        E e = entityManager.find(entityType, id);
        if (e == null) {
            throw new NullPointerException("No such entity against id " + id);
        }
        return e;
    }


    /**
     * Generic Method to delete entity against id
     * @param e entity to be removed from the database
     */
    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }
}

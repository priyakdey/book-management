package com.example.goodreads.data.dao;

import java.io.Serializable;

public interface IGenericDAO<E> {
    void persist(E e);

    E fetchEntityById(Serializable id);

    void delete(E e);
}

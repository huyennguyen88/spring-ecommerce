package com.example.springecommerce.service;

import java.io.Serializable;

public interface BaseService<PK, T> {
    public T getById(int key);

    public T saveOrUpdate(T entity);

    public boolean delete(T entity);
}

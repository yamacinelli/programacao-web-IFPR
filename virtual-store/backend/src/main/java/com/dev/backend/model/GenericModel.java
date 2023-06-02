package com.dev.backend.model;

import java.util.List;

public interface GenericModel<T> {

    T save(T model);

    List<T> saveAll(List<T> models);

    T findById(Integer id);

    List<T> findAll();

    void delete(Integer id);

    T update(T model);
}

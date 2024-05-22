package com.example.masterpiece.utils.services;

import java.util.List;

public interface ICRUD <T>{
    Boolean insert(T t);
    Boolean update(T t);
    List<T> list();
    T listById(Object id);
    void delete(Object id);
}
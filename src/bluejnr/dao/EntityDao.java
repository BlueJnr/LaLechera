/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.dao;

import java.util.List;

/**
 *
 * @author kcuadror
 * @param <T>
 * @param <V>
 */
public interface EntityDao <T,V> {
    public abstract void create(T t);
    public abstract void update(T t);
    public abstract void delete(V v);
    public abstract T find(V v);
    public abstract List<T> findAll();
}

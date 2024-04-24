package co.edu.icesi.viajes.proyectoicesiviajes.service;

import java.util.List;
import java.util.Optional;

public interface GenericService <T, ID>{

    public List<T> findAll();

    public T findById(ID id) throws Exception;

    public T save(T entity) throws Exception;

    public T update(T entity) throws Exception;

    public void deleteById(ID id) throws Exception;

    public void validate(T entity) throws Exception;

    public Long count();



}
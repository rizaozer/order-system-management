package com.example.ordermanagementsystem.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class AbstractService<ENTITY, ID, T extends JpaRepository<ENTITY, ID>> {
    protected final T repository;

    public AbstractService(T repository) {
        this.repository = repository;
    }

    public ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

    public List<ENTITY> getAll() {
        return repository.findAll();
    }
}

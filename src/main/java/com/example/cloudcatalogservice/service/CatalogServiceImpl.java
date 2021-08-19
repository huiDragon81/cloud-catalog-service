package com.example.cloudcatalogservice.service;


import com.example.cloudcatalogservice.jpa.CatalogEntity;
import com.example.cloudcatalogservice.jpa.CatalogRepository;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository repository;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return repository.findAll();
    }
}

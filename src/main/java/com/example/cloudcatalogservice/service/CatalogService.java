package com.example.cloudcatalogservice.service;


import com.example.cloudcatalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}

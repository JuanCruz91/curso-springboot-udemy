package com.juan.springboot.inyecciondependencias.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.juan.springboot.inyecciondependencias.app.springboot_di.models.Product;

public class ProductRepository {

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Peluquita", 300L),
            new Product(2L, "Maquillaje", 850L),
            new Product(3L, "Taconazo", 180L),
            new Product(4L, "Tetonas", 490L));
    }

    public List <Product> findAll() {
        return data;
    }
}

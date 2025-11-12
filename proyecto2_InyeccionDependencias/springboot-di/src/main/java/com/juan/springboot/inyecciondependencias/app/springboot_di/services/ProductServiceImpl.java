package com.juan.springboot.inyecciondependencias.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.juan.springboot.inyecciondependencias.app.springboot_di.models.Product;
import com.juan.springboot.inyecciondependencias.app.springboot_di.repositories.ProductRepositoryImpl;
// 
public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl  repository = new ProductRepositoryImpl();

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
    }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}

package com.webapp.Blossom.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.Blossom.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProductDao implements IProductDao{

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public List<Product> getProducts() {
        String query = "FROM Products";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void registerProduct(Product product) {
        em.merge(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
    @Override
    public Product getProduct(Long id) {
        Product product = em.find(Product.class, id);
        return product;
    }
}

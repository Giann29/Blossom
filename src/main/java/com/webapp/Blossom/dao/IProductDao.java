package com.webapp.Blossom.dao;
import java.util.List;

import com.webapp.Blossom.models.Product;
public interface IProductDao {

    public List<Product> getProducts();

    public Product getProduct(Long id);

    public void registerProduct(Product product);


    public void deleteProduct(Long id);
}

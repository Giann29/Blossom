package com.webapp.prueba.dao;
import com.webapp.prueba.models.Product;
import java.util.List;
public interface IProductDao {

    public List<Product> getProducts();

    public Product getProduct(Long id);

    public void registerProduct(Product product);


    public void deleteProduct(Long id);
}

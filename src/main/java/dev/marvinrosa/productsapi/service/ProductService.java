package dev.marvinrosa.productsapi.service;

import dev.marvinrosa.productsapi.model.Product;
import dev.marvinrosa.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

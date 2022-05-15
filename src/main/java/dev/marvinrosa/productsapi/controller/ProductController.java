package dev.marvinrosa.productsapi.controller;

import dev.marvinrosa.productsapi.model.Product;
import dev.marvinrosa.productsapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getListProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{idProduct}")
    public ResponseEntity<Product> getById(@PathVariable(value = "idProduct") Long idProduct){

        try{
            Product product = productService.getProductById(idProduct);
            return new ResponseEntity<Product>(product,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        try{
            productService.saveProduct(product);
            return new ResponseEntity<Product>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable(value = "id") Long id){

        try{
            Product currentProduct = productService.getProductById(id);
            currentProduct.setName(product.getName());
            currentProduct.setPrice(product.getPrice());

            productService.saveProduct(currentProduct);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }





}

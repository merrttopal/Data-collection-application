package com.rest.service;


import com.rest.configs.Rest;
import com.rest.entities.Product;
import com.rest.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService {

    final ProductRepository productRepository;
    public ResponseEntity save (  Product product){
        try {
            productRepository.save(product);
            Rest rest = new Rest(true,product);
            return new ResponseEntity(rest,HttpStatus.OK);

        }catch (Exception exception){

            Rest rest = new Rest(false,exception.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);

        }


    }

    public ResponseEntity<?> productList(){
        List<Product> ls = productRepository.findAll();
        Rest rest = new Rest(true,ls);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    public ResponseEntity deleteProduct(Long pid){
        try{
            productRepository.deleteById(pid);
            Rest rest = new Rest(true,pid);
            return new ResponseEntity(rest,HttpStatus.OK);
        }
        catch (Exception exception){
            Rest rest = new Rest(false,exception.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity update (Product product) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(product.getPid());
            if (optionalProduct.isPresent()) {
                productRepository.saveAndFlush(product);
                Rest rest = new Rest(true, product);
                return new ResponseEntity(rest, HttpStatus.OK);
            }
            Rest rest = new Rest(false, product);
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            Rest rest = new Rest(false, exception.getMessage());
            return new ResponseEntity(rest, HttpStatus.BAD_REQUEST);
        }
    }

}

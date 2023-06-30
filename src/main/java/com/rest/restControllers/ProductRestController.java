package com.rest.restControllers;

import com.rest.entities.Product;
import com.rest.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody /*de serialization*/ Product product) {

        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.productList();
    }

    @GetMapping("/deleteProduct/{pid}")
    public ResponseEntity delete(@PathVariable Long pid) {
        return productService.deleteProduct(pid);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

}

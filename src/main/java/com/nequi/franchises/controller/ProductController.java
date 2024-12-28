package com.nequi.franchises.controller;

import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    Flux<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    Mono<ProductDto> getProduct(@PathVariable("productId") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/create/{branchId}")
    Mono<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable("branchId") Long branchId) {
        return productService.createProduct(productDto, branchId);
    }

    @PutMapping("/update/{productId}/{branchId}")
    Mono<ProductDto> updateProduct(@PathVariable("productId") Long id, @RequestBody ProductDto productDto, @PathVariable("branchId") Long branchId) {
        return productService.updateProduct(id, productDto, branchId);
    }

    @DeleteMapping("/delete/{productId}")
    Mono<Void> deleteProduct(@PathVariable("productId") Long id) {
        return productService.deleteProduct(id);
    }
}

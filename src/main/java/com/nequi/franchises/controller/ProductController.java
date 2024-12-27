package com.nequi.franchises.controller;

import com.nequi.franchises.controller.dto.ProductDto;
import com.nequi.franchises.service.ProductService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/create")
    Mono<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/update/{productId}")
    Mono<ProductDto> updateProduct(@PathVariable("productId") Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/delete/{productId}")
    Mono<Void> deleteProduct(@PathVariable("productId") Long id) {
        return productService.deleteProduct(id);
    }
}

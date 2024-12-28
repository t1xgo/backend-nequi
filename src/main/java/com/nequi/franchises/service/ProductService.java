package com.nequi.franchises.service;

import com.nequi.franchises.controller.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDto> getProducts();
    Mono<ProductDto> getProduct(Long id);
    Mono<ProductDto> createProduct(ProductDto productDto, Long branchId);
    Mono<ProductDto> updateProduct(Long id, ProductDto productDto, Long branchId);
    Mono<Void> deleteProduct(Long id);
}

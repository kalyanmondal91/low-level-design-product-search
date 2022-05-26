package com.github.systemdesign;

import com.github.systemdesign.model.Product;
import com.github.systemdesign.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {

    private final ProductService productService;

    public AppRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        productService.addProduct(new Product("maggi"));
        productService.addProduct(new Product("mask"));
        productService.addProduct(new Product("macbook"));
        productService.addProduct(new Product("mamaearth"));
        productService.addProduct(new Product("mixer"));
        productService.addProduct(new Product("mouse"));
        productService.addProduct(new Product("mobile"));
        productService.addProduct(new Product("mop"));
        productService.addProduct(new Product("microwave"));
        productService.addProduct(new Product("milton"));
        productService.addProduct(new Product("magnet"));

        displayProducts(productService.searchProduct("ma"));
    }

    private void displayProducts(List<Product> productList) {
        productList.stream().forEach(product -> log.info("Product - {}", product));
    }
}

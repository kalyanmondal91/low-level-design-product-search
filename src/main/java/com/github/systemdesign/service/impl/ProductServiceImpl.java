package com.github.systemdesign.service.impl;

import com.github.systemdesign.model.Product;
import com.github.systemdesign.model.datastructure.ProductTrie;
import com.github.systemdesign.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    Map<UUID, Product> productMap;
    private final ProductTrie productTrie;

    public ProductServiceImpl(ProductTrie productTrie) {
        this.productMap = new HashMap<>();
        this.productTrie = productTrie;
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
        productTrie.addProduct(product.getId(), product.getProductName());
    }

    @Override
    public List<Product> searchProduct(String searchString) {
        List<Product> result = new ArrayList<>();
        Set<UUID> productIds = productTrie.searchProduct(searchString);
        if(Objects.nonNull(productIds) && !productIds.isEmpty()) {
            for(UUID id : productIds)
                result.add(productMap.get(id));
        }
        return result;
    }
}

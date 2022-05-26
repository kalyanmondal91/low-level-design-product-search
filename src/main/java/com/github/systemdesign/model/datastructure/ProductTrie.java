package com.github.systemdesign.model.datastructure;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Component
public class ProductTrie {
    TrieNode root;

    public ProductTrie() {
        this.root = new TrieNode();
    }

    public void addProduct(UUID productId, String productName) {
        TrieNode pCrawl = root;
        for(Character ch : productName.toLowerCase().toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null) {
                TrieNode trie = new TrieNode(ch);
                pCrawl.children[idx] = trie;
            }
            pCrawl.children[idx].allProductIds.add(productId);
            pCrawl = pCrawl.children[idx];
        }
        pCrawl.isEndOfWord = true;
        pCrawl.productId = productId;
    }

    public Set<UUID> searchProduct(String key) {
        TrieNode pCrawl = root;
        for(Character ch : key.toLowerCase().toCharArray()) {
            int idx = ch - 'a';
            if(pCrawl.children[idx] == null)
                return Collections.emptySet();
            pCrawl = pCrawl.children[idx];
        }
        return pCrawl.allProductIds;

    }

}

package com.github.systemdesign.model.datastructure;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class TrieNode {

    public static final int ALPHABET_SIZE = 26;

    TrieNode[] children;
    Character character;
    Boolean isEndOfWord;
    UUID productId;
    Set<UUID> allProductIds;

    public TrieNode() {
        isEndOfWord = false;
        allProductIds = new HashSet<>();
        children = new TrieNode[ALPHABET_SIZE];
        for(int i=0; i<ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
    public TrieNode(Character character) {
        this();
        this.character = character;
    }
}

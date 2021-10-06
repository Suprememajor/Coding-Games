package com.supremecorp.easy.mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by suprememajor on 10/6/21
 */
public class PrefixCode {
    public static void prefixCode() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxLength = 0;
        Map<String, Integer> code = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String b = in.next();
            int c = in.nextInt();
            maxLength = max(maxLength, b.length());
            code.put(b, c);
        }
        String s = in.next();
        StringBuffer out = new StringBuffer();
        String key;
        for(int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length() + 1; j++){
                key = s.substring(i, j);
                if(code.containsKey(key)){
                    int value = code.get(key);
                    out.append((char)value);
                    i = j - 1;
                    break;
                }else if(!(j - i < maxLength + 1) || j == s.length()){
                    System.out.println("DECODE FAIL AT INDEX " + i);
                    return;
                }
            }
        }
        System.out.println(out);
    }
}
class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}

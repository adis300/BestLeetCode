package Trie._No208_ImplementTrie;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Trie {

    Character content = null;
    boolean isLeaf = false;

    Map<Character, Trie> children = new HashMap<>();

    /** Initialize your data structure here. */
    public Trie() {
        // No impl
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Character thisChar;
        Trie node = this;
        for (int i = 0; i < word.length() ; i ++){
            thisChar = word.charAt(i);
            if (node.children.containsKey(thisChar)){
                node = node.children.get(thisChar);
                if(i == word.length() - 1) node.isLeaf = true;
            }
            else{
                node.addLeaf(word, i);
                break;
            }
        }
    }
    private void addLeaf(String word, int index){
        Trie node = this;
        Trie nextNode;
        while (index < word.length()){
            nextNode = new Trie();
            nextNode.content = word.charAt(index);
            node.children.put(nextNode.content, nextNode);
            node = nextNode;
            ++ index;
        }
        node.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i ++){
            node = node.children.get(word.charAt(i));
            if (node == null) return false;
        }
        return node.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        char testChar;
        for (int i = 0; i < prefix.length(); i ++){
            testChar = prefix.charAt(i);
            node = node.children.get(testChar);
            if (node == null || node.content != testChar) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
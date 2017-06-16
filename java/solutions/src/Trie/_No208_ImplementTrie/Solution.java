package Trie._No208_ImplementTrie;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Solution {

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("ab");

        boolean searchRes = trie.search("ab");
        boolean startsWith = trie.startsWith("a");

    }
}

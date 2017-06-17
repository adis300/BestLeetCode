package Trie._No211_AddAndSearchWord;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing
 only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true

 Note:
 You may assume that all words are consist of lowercase letters a-z.

 */
public class WordDictionary {

    private Trie dictionary = new Trie(null);

    private class Trie{
        private Character content;
        private Map<Character, Trie> children = new HashMap<>();
        private boolean isLeaf = false;
        private Trie(Character content){
            this.content = content;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node = dictionary; Character thisChar;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i ++){
            thisChar = charArray[i];
            if (node.children.containsKey(thisChar)){
                node = node.children.get(thisChar);
                if (i == word.length() - 1) node.isLeaf = true;
            }else{
                Trie nextNode;
                while (i < word.length()){
                    nextNode = new Trie(charArray[i]);
                    node.children.put(charArray[i], nextNode);
                    node = nextNode;
                    ++i;
                }
                node.isLeaf = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        return match(dictionary, charArray, 0);
    }

    public boolean match(Trie node, char[] array, int startIndex){
        char thisChar; Trie nextNode;
        for (int j = startIndex; j < array.length; j ++){
            thisChar = array[j];
            if (thisChar == '.'){
                for(Trie child: node.children.values()){
                    if (match(child, array, j + 1)) return true;
                }
                return  false;
            }else{
                nextNode = node.children.get(thisChar);
                if (nextNode == null) return false;
                else node = nextNode;
            }
        }
        return node.isLeaf;
    }

    public static void main(String[] args){
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        boolean search2 = dict.search("b..");
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


package DFS.No126_WordLadderII;

import java.util.*;

/**

 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation
 sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 UPDATE (2017/1/20):
 The wordList parameter had been changed to a list of strings (instead of a set of strings).
 Please reload the code definition to get the latest changes.
 */
public class SolutionSlowWithPermutation {

    List<List<String>> results = new LinkedList<>();
    List<String> wordList;
    String beginWord, endWord;
    int[] indices;
    int shortestCount = Integer.MAX_VALUE;
    HashSet<Integer> keys = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList; this.endWord = endWord; this.beginWord = beginWord;
        indices = new int[wordList.size()];
        for (int i = 0; i < wordList.size(); i ++) indices[i] = i;

        permute(0);

        int i = 0;
        while (i < results.size()){
            if (results.get(i).size() != shortestCount){
                results.remove(i);
            }else ++i;
        }
        return results;
    }

    public boolean wordCompare(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i ++){
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++count > 1) return false;
            }
        }
        return true;
    }


    public void permute(int start){
        if (start == wordList.size()){
            search(beginWord, 0, new ArrayList<>(Arrays.asList(beginWord)));
            return;
        }

        for (int i = start; i < wordList.size(); i++){
            swap(start, i); // Permute the first item in remaining sequence with all rest of the items including item itself.
            permute(start + 1);
            swap(start, i);  // Swap back to original order for backtracking.
        }
    }

    public void swap(int i, int j){
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    public void search(String begin, int nextIndex, List<String> path){
        if (path.size() > shortestCount) return;
        if (nextIndex == wordList.size()){
            if (path.get(path.size() - 1).equals(endWord)) {
                shortestCount = path.size();
                Integer key = computeHash(path);
                if (!keys.contains(key)){
                    results.add(new ArrayList<>(path));
                    keys.add(key);
                }
            }
            return;
        }
        String newWord = wordList.get(indices[nextIndex]);
        if (wordCompare(begin, newWord)){
            path.add(newWord);
            search(newWord, nextIndex + 1, path);
            path.remove(path.size() - 1);
        }
        search(begin, nextIndex + 1, path);
    }

    public static void main(String[] args){
        new SolutionSlowWithPermutation().findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public int computeHash(List<String> elements){
        final int prime = 31;
        int result = 1;
        for( String s : elements )
        {
            result = result * prime + s.hashCode();
        }
        return result;
    }

    /*

    public void permuteSearch(String begin, int start, List<String> path){
        if (path.size() > shortestCount) return;
        if (start == wordList.size()){
            if (path.get(path.size() - 1).equals(endWord)) {
                shortestCount = path.size();
                results.add(new ArrayList<>(path));
            }
            return;
        }
        String newWord = wordList.get(start);
        if (wordCompare(begin, newWord)){
            path.add(newWord);
            permuteSearch(newWord, start + 1, path);
            path.remove(path.size() - 1);
        }
        permuteSearch(begin, start + 1, path);
    }
     */


}

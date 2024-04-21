package Trie;

import java.util.Arrays;

public class LongestWordInDictionary {
    class Solution {
        public String longestWord(String[] words) {

            root = new TrieNode();

            for(String s : words)
                insert(s);

            Arrays.sort(words);
            String max = "";
            for(int i = words.length-1;i>=0;i--){
                String res = search(words[i]);
                if(res==null)
                    continue;
                if(res.length()>max.length()){
                    max = res;
                }
                if(res.length()==max.length()){
                    if(res.compareTo(max)<0)
                        max = res;
                }
            }
            return max;
        }
        class TrieNode{
            public TrieNode[] children;
            public boolean IsWordEnd;
            public TrieNode(){
                this.children = new TrieNode[26];
                this.IsWordEnd = false;
            }
        }
        TrieNode root;
        public void insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.IsWordEnd = true;
        }
        public String search(String word){
            TrieNode node = root;
            int oneCharIsDiff = 0;
            for(char c : word.toCharArray()){
                int idx = c - 'a';

                if(node.children[idx].IsWordEnd){
                    oneCharIsDiff++;
                }

                node = node.children[idx];
            }
            return oneCharIsDiff == word.length() ? word : null;
        }

    }
}

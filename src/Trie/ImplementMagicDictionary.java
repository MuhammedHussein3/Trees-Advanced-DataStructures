package Trie;

public class ImplementMagicDictionary {
    class MagicDictionary {

        class TrieNode{
            TrieNode[] childs;
            boolean end;

            public TrieNode(){
                childs = new TrieNode[26];
                end = false;
            }
        }
        TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for(String s : dictionary){
                TrieNode cur = root;
                for(char ch : s.toCharArray()){
                    int idx = ch - 'a';

                    if(cur.childs[idx] == null){
                        cur.childs[idx] = new TrieNode();
                    }
                    cur = cur.childs[idx];
                }
                cur.end = true;
            }

        }

        public boolean search(String searchWord) {
            return helper(root,searchWord);
        }
        boolean helper(TrieNode root, String prefix){

            char[] arr = prefix.toCharArray();
            for (int i =0 ;i< arr.length; i++){
                for (char a = 'a'; a <= 'z'; a++){
                    if (arr[i] == a){
                        continue;
                    }
                    char temp = arr[i];
                    arr[i] = a;
                    if (isFound(root,new String(arr)))
                        return true;
                    arr[i] = temp;
                }
            }
            return false;
        }
        boolean isFound(TrieNode root, String prefix){
            TrieNode cur = root;
            int diff = 0;
            for (char c : prefix.toCharArray()){
                int idx = c - 'a';

                if (cur.childs[idx] == null){
                    return false;
                }

                cur = cur.childs[idx];
            }
            return cur.end;

        }
    }


}

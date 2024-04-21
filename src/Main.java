import javax.swing.tree.TreeNode;

public class Main {
    public static class TrieNode{
      public TrieNode[] children;
      public int wordCount;
      public TrieNode(){
          children = new TrieNode[26];
          wordCount = 0;
      }
    }
    public static void insert(TrieNode root, String word){
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            int idx = c - 'a';
            if (cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.wordCount++;
    }
   static boolean search(TrieNode root, String prefix){
        TrieNode cur = root;
        int diff = 0;
        for (char c : prefix.toCharArray()){
            int idx = c - 'a';

            if (cur.children[idx] == null){
                return false;
            }

            cur = cur.children[idx];
        }
       return true;

    }
    static boolean helper(TrieNode root, String prefix){

        char[] arr = prefix.toCharArray();
        for (int i =0 ;i< arr.length; i++){
            for (char a = 'a'; a <= 'z'; a++){
                if (arr[i] == a){
                    continue;
                }
                char temp = arr[i];
                arr[i] = a;
                if (search(root,new String(arr)))
                    return true;
                arr[i] = temp;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        TrieNode root = new TrieNode();


        insert(root, "hello");
        insert(root, "leetcode");

        System.out.println(helper(root, "hhllo"));
    }
}
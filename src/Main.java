import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        String[] words = {"a", "b", "c", "d", "e", "f", "g", "h"};
        Arrays.sort(words);
        String s = "a";
        String b = "d";
        System.out.println(s.compareTo(b));
    }
}
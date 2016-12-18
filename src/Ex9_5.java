import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目描述
 * 编写一个方法，确定某字符串的所有排列组合。
 * 给定一个string A和一个int n,代表字符串和其长度， 请返回所有该字符串字符的排列，
 * 保证字符串长度小于等于11且字符串中字符均为大写英文字符，
 * 排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 * 测试样例：
 * "ABC"
 * 返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
public class Ex9_5 {

    public ArrayList<String> getPermutation(String A) {
        // write code here
        if (A == null)
            return null;

        //终止条件
        ArrayList<String> strings = new ArrayList<String>();
        if (A.length() == 0) {
            strings.add("");
            return strings;
        }


        char first = A.charAt(0);
        String sub = A.substring(1);//除掉
        ArrayList<String> words = getPermutation(sub);

        //f(n -1) ---> f(n) ： 在f(n) 的基础上插入字符
        for (String word : words) {
            //包含等号
            for (int i = 0; i <= word.length(); i++) {
                String newWords = istStr(word, first, i);
                strings.add(newWords);
            }
        }


        Collections.sort(strings, Collections.reverseOrder());
        return strings;
    }


    private String istStr(String word, char c, int j) {
        String pre = word.substring(0, j);
        String end = word.substring(j);
        return pre + c + end;
    }

    public static void main(String[] args) {
        String A = "ABC";
        System.out.println(new Ex9_5().getPermutation(A));
    }
}

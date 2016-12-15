import java.util.ArrayList;

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
    public static void arrangement(ArrayList<String> strings, String A, String temp) {
        if (A.length() == 1) {
            temp += A;
            strings.add(temp.toString());
        }
        //先去第i个元素， 不取第一个元素
        String str = new String();
        str += A.charAt(0);
        String AA = (String) A.subSequence(1, A.length());

        arrangement(strings, AA, str);
        //    arrangement(string);

    }

    public ArrayList<String> getPermutation(String A) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        // arrangement(list,A);
        return list;

    }

    public static void main(String[] args) {
        String A = "ABC";
        String B = (String) A.subSequence(1, A.length());
        System.out.println(A + "  " + B);
    }
}

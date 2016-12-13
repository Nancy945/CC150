/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 * Created by Nancy on 2016/12/12.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex9_6 {

    /**
     * 检查括号数量就行
     */
    public boolean chkParenthesis(String A, int n) {
        int num = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
            }

            if (num < 0) return false;
        }


        return num == 0;
    }
}

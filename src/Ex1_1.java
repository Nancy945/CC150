import java.util.Arrays;

/**
 * 题目描述
 * <p>
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 * Created by Nancy on 2016/11/4.
 */
public class Ex1_1 {

    public static void main(String[] args) {

    }


    public boolean checkDifferent(String iniString) {

        //常见的只有128个不过为了保险还是255个再返回false
        if (iniString.length() > 256) {
            return false;
        }
        for (int i = 1; i < iniString.length(); i++) {
            //比较从0到i-1 有没有和i相同的
            for (int j = 0; j <= i - 1; j++) {
                if (iniString.charAt(j) == iniString.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkDifferent1(String iniString) {
        //常见的只有128个不过为了保险还是255个再返回false
        if (iniString.length() > 256) {
            return false;
        }
        for (int i = 0; i < iniString.length() - 1; i++) {
            String c = String.valueOf(iniString.charAt(i));
            String subString = iniString.substring(i + 1, iniString.length());
            if (subString.contains(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 排序 既然题目要求不能使用额外空间，而参数列表没有const或引用，
     * 那么就可以对字符串排序，然后再判断，需要O（nlogn)排序，然后再遍历一遍O(n)。
     * 其实也没必要全都排序，只需前257个，同抽屉原理。
     */
    public boolean checkDifferent2(String iniString) {
        //常见的只有128个不过为了保险还是255个再返回false
        if (iniString.length() > 256) {
            return false;
        }

        char[] chars = iniString.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }
}

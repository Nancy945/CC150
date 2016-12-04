/**
 * Created by 余屌丝 on 2016/12/1.
 * <p>
 * 题目描述
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）
 * 给定一个int x，请返回交换后的数int。
 * 测试样例：
 * 10
 * 返回：5
 */
public class Ex5_6 {
    public static int exchangeOddEven(int x) {
        // write code here
        String str = Integer.toBinaryString(x);
        StringBuilder temp = new StringBuilder();
        System.out.println("str" + str);
        //1.先把str 凑为偶数位
        if (str.length() % 2 != 0) {
            str = "0" + str;
        }


        for (int i = 0; i < str.length() - 1; i += 2) {
            temp.append(str.charAt(i + 1));
            temp.append(str.charAt(i));
        }

        return Integer.parseInt(temp.toString(), 2);
    }

    /**
     * 考虑符号位
     * 取偶数位得 even = 1000....0
     * 取奇数位得 odd = 0000.....0
     * 因为int为整型，最高位为1的为负数，右移将在左边添1
     */

    int exchangeOddEven1(int x) {
        // write code here
        int odd = ((x & 0x55555555) << 1);
        int even = ((x & 0xAAAAAAAA) >> 1) & 0x7fffffff;
        return even | odd;
    }

    public static void main(String[] args) {
        System.out.println("result:" + exchangeOddEven(10));
    }
}

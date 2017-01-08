/**
 * 题目描述
 * 请编写一个方法，找出两个数字中最大的那个。条件是不得使用if-else等比较和判断运算符。
 * 给定两个int a和b，请返回较大的一个数。若两数相同则返回任意一个。
 * 测试样例：
 * 1，2
 * 返回：2
 */
public class Ex11_4 {
    /*思路：a和b的差的绝对值是abs(a - b)，然后差的绝对值加上a和b的和即为最大值的两倍。
             同理求两数较小的一个，a + b - abs(a - b)即可。
    */
    public int getMax(int a, int b) {
        return ((a + b + Math.abs(a - b)) / 2);

    }
}

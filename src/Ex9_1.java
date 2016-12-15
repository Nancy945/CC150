/**
 * Created by 余屌丝 on 2016/12/9.
 * 题目描述
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，
 * 计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：
 * 1
 * 返回：1
 */
public class Ex9_1 {

    public static int goUp(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        } else
            return goUp(n - 1) + goUp(n - 2) + goUp(n - 3);
    }

    public static int goUp2(int n) {
        int[] a = new int[100000];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        for (int i = 3; i < 100000; i++) {
            //取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
            a[i] = ((a[i - 1] + a[i - 2]) % 1000000007 + a[i - 3]) % 1000000007;
        }

        return a[n - 1];
    }

    public static int countWays(int n) {
        // write code here
        return goUp(n);
    }

    public static void main(String[] args) {
    }
}

/**
 * 题目描述
 * 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
 * 给定两个int A和B。请返回A＋B的值
 * 测试样例：
 * 1,2
 * 返回：3
 */
public class Ex18_1 {
    public int addAB(int A, int B) {
        int tem = 0;//代表进位位
        do {
            tem = A & B;
            A = A ^ B;
            B = tem << 1;
        }
        while (B != 0);
        return A;
    }

}

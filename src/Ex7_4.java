/**
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
 * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。
 * 请返回计算的结果，保证数据合法且结果一定在int范围内。
 * 测试样例：
 * 1,2,1
 * 返回：2
 */
public class Ex7_4 {
    public int calc(int a, int b, int type) {
        int temp = 0;
        switch (type) {
            case 1://  *
                while (b > 0) {
                    temp += a;
                    b--;
                }
                break;
            case 0://  /
                while (a > 0) {
                    a = a + (~b) + 1;
                    if (a > 0)
                        temp++;
                }
                break;
            case -1:// -
                temp = a + (~b) + 1;
                break;
        }
        return temp;
    }
}

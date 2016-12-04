/**
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
 *  给定两个整数int A，int B。请返回需要改变的数位个数。
 *  测试样例：
 *  10,5
 *  返回：4
 */
import java.util.*;
public class EX5_5 {
    private static int calcCost1(int A,int B){
        int t1 = A & B;
        int t2 = A | B;

        int count1 = 0;
        int count2 = 0;
        while (t1 != 0) {
            if(t1%2 == 1)
                count1++;
            t1 >>= 1;
        }

        while (t2 != 0) {
            if(t2%2 == 1)
                count2++;
            t2 >>= 1;
        }
        return count2-count1;
    }
//2
    private static int calcCost(int A,int B){
        int t = A ^ B;
        int count = 0;
        while (t != 0) {
            count++;
            t &= t - 1;
        }

        return count;
    }

}

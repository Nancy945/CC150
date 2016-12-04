/**
 * 有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)
 * 给定正整数int x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。
 * 测试样例：
 * 2
 * 返回：[1,4]
 * Created by Nancy on 2016/11/21.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex5_3 {

    public int[] getCloseNumber(int x) {
        int[] result = new int[2];
        result[0] = getPrev(x);
        result[1] = getNext(x);

        return result;
    }

    private int getNext(int n) {
        //规定非拖尾0的位置（从右为0开始向左数）为p
        //计算c0和c1，C0：p右边0的个数 C1:p右边1的个数 易知：p=c0+c1

        //计算c0和c1

        int c = n;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 0 && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        //错误：若n==前面连续若干个1，后面连续若干个0，那么就没有更大的数

        //此处31也行吧??
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1;//最右边非拖尾0的位置

        n |= (1 << p); //反转最右边，非拖尾0
        n &= ~((1 << p) - 1);//将p有房的所有位清0
        n |= (1 << (c1 - 1)) - 1;//在右方插入(c1-1)个1

        return n;

    }

    private int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1; //最右边，非拖尾1的位置
        n &= ((~0) << (p + 1));//将位0到p清0

        int mask = (1 << (c1 + 1)) - 1;//（c1+1）个1
        n |= mask << (c0 - 1);

        return n;
    }


}

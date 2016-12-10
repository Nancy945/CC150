/**
 * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
 * 给定一个数int k，请返回第k个数。保证k小于等于100。
 * 测试样例：
 * 3
 * 返回：7
 */
public class Ex7_7 {
    public static void main(String[] args) {
        System.out.println(findKth2(3));
    }

    private static int findKth(int k) {
        int[] res = new int[k < 3 ? 3 : k];
        res[0] = 3;
        res[1] = 5;
        res[2] = 7;
        for (int i = 3; i < k; i++) {
            res[i] = min(res, i);
        }
        return res[k - 1];
    }

    private static int min(int[] a, int i) {
        int t = a[i - 1];//获取当前最大值
        int min = a[i / 2 + 1] * a[i / 2 + 1];//需要讨论，我蒙的
        for (int j = 0; j < i; j++) {
            for (int k = j; k < i; k++) {
                if (a[j] * a[k] > t && a[j] * a[k] < min)
                    min = a[j] * a[k];
            }
        }
        return min;
    }

    //该数字一定是由3、5、7相乘得到
    private static int findKth2(int k) {
        int num = 3;//第一个数
        while (num != 0 && k != 0) {
            int temp = num;
            while (temp % 3 == 0)
                temp /= 3;
            while (temp % 5 == 0)
                temp /= 5;
            while (temp % 7 == 0)
                temp /= 7;
            if (1 == temp)
                k--;
            num++;
        }
        return --num;
    }

    //方法3
    private static int findKth3(int k) {
        int[] array = new int[101];
        array[0] = 0;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        if (k <= 3) {
            return array[k];
        }
        int index3 = 1, index5 = 1, index7 = 1;//记录当前使用3、5、7的个数，个数每增加一次，对应于结果数组的索引也增加一个
        int i = 4;
        while (i <= k) {
            while (array[index3] * 3 <= array[i - 1]) {
                index3++;
            }
            while (array[index5] * 5 <= array[i - 1]) {
                index5++;
            }
            while (array[index7] * 7 <= array[i - 1]) {
                index7++;
            }
            array[i++] = min2(array[index3] * 3, array[index5] * 5, array[index7] * 7);
        }
        return array[k];
    }

    private static int min2(int a, int b, int c) {
        return (a < b ? (a < c ? a : c) : (b < c ? b : c));
    }
}

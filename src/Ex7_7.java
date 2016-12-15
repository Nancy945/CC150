import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     * 时间复杂度O(N),按书中所讲，3个素数因子3、5、7分为三个队列
     * q3,q5,q7，其中最初存放3，5，7
     * 之后每次添加找到三个队列头中最小的数，起初为3，将3移出队列
     * q3后，在q3添加3*3，在q5添加3*5,q7中添加3*7
     * 此时可知q3{3*3},q5{5,3*5},q7{7,3*7}
     * 下一轮找到最小数为5，重复上述步骤，将5从q5移出，添加5*5到
     * q5，因为5*3已经添加过所以不需要添加到q3中
     * 将5*7添加到q7，结果q3{3*3},q5{3*5,5*5},q7{7,3*7,5*7}
     * 依次找到第k个数
     */
    public int findKth1(int k) {
        // write code here
        if (k < 0) {
            return 0;
        }
        int val = 0;
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        Queue<Integer> q7 = new LinkedList<Integer>();
        q3.add(1);
        for (int i = 0; i <= k; i++) {
            int v3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
            int v5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
            int v7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));

            if (val == v3) {
                q3.remove();
                q3.add(val * 3);
                q5.add(val * 5);
            } else if (val == v5) {
                q5.remove();
                q5.add(val * 5);
            } else if (val == v7) {
                q7.remove();
            }
            q7.add(val * 7);
        }
        return val;
    }

    private static int min2(int a, int b, int c) {
        return (a < b ? (a < c ? a : c) : (b < c ? b : c));
    }
}

import java.util.*;

/**
 * 现在我们有一个int数组，请你找出数组中每个元素的下一个比它大的元素。
 * 给定一个int数组A及数组的大小n，请返回一个int数组，代表每个元素比他大的下一个元素,若不存在则为-1。
 * 保证数组中元素均为正整数。
 * 测试样例：
 * [11,13,10,5,12,21,3],7
 * 返回：[13,21,12,12,21,-1,-1]
 */
public class Exnt6 {
    public static void main(String[] args) {
        int[] a = new int[]{118124, 179069, 58175, 243210, 39540, 245841, 55085, 150164, 133982, 129588, 15875, 49400};
        int[] r = findNext(a, 12);
        for (int i = 0; i < 12; i++) {
            System.out.println(r[i]);
        }
    }

    public static int[] findNext(int[] A, int n) {
        // write code here
        int[] res = new int[n];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {//尾部的前一个数使标志位为true，需要对尾部进行判定
                flag = false;
            }
            for (int j = i + 1; j < n; j++) {
                if (A[i] < A[j]) {
                    res[index++] = A[j];
                    flag = true;
                    break;
                } else if (j == n - 1) {//查找到数组尾部还没找到，需要改变标志位使其能够赋值-1；
                    flag = false;
                }
            }
            if (!flag) {
                res[index++] = -1;
            }
        }
        return res;
    }

    /**
     * 思路：
     * 从后向前维护一个递减栈。
     * 最右边的那个值肯定没有最大值，所以肯定是-1。初始栈为-1。
     * 从后向前计算：
     * （1）如果当前元素大于栈顶元素，则栈顶元素退出，
     * 如果还是大于栈顶元素，继续退出，一直遍历栈到-1或者小于栈顶元素。
     * 这个元素就是就是当前值的下一个比较大的元素。
     * （2）如果当前元素小于栈顶元素，栈顶元素就是当前值的下一个比较大的元素。
     */
    public int[] findNext01(int[] A, int n) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);
        List<Integer> res = new ArrayList<Integer>();
        //int t=s.peek();
        for (int i = n - 1; i >= 0; i--) {
            int t = s.peek();
            while (t != -1 && A[i] > t) {
                s.pop();
                t = s.peek();
            }
            res.add(t);
            s.push(A[i]);
        }
        int B[] = A;
        for (int i = n - 1; i >= 0; i--) {
            B[i] = res.get(n - 1 - i);
        }
        return B;
    }
}

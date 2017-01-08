import java.util.Arrays;

/**
 * 题目描述
 * 现在有一个数组，请找出数组中每个元素的后面比它大的最小的元素，若不存在则为-1。
 * 给定一个int数组A及数组的大小n，请返回每个元素所求的值组成的数组。保证A中元素为正整数，且n小于等于1000。
 * 测试样例：
 * [11,13,10,5,12,21,3],7
 * [12,21,12,12,21,-1,-1]
 */
public class Ex18_4_2 {
    public int[] findNext(int[] A, int n) {
        // write code here
        int[] ret = new int[A.length];
        Arrays.fill(ret, -1);
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < A.length; j++) {

                if (A[j] > A[i] && A[j] < min) {
                    min = A[j];
                }
            }
            ret[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = new int[]{11, 13, 10, 5, 12, 21, 3};
        System.out.println(Arrays.toString(new Ex18_4_2().findNext(a, a.length)));
    }
}

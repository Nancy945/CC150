/**
 * Created by 余屌丝 on 2016/12/10.
 * 题目描述
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：false
 */
public class Ex9_3_1 {

    public static boolean findMagicIndex(int[] A, int start, int end) {
        int center = (start + end) / 2;
        if (start >= end)
            return A[start] == start;

        if (A[center] > center)
            return findMagicIndex(A, 0, center - 1);
        else if (A[center] < center)
            return findMagicIndex(A, center + 1, end);
        else
            return true;

    }

    public static boolean findMagicIndex(int[] A, int n) {
        // write code here
        return findMagicIndex(A, 0, n - 1);
    }

    public static boolean findMagicIndex2(int[] A, int n) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > mid)
                end = mid - 1;
            else if (A[mid] < mid)
                start = start + 1;
            else
                return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3};

        System.out.println(findMagicIndex(a, 0, 4));
    }

}

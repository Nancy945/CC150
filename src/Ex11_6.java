/**
 * 有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。
 * 给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 * 请返回一个二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 * 测试样例：
 * [[1,2,3],[4,5,6]],2,3,6
 * 返回：[1,2]
 */

/**
 * 从右上角开始，每次将搜索值与右上角的值比较，如果大于右上角的值，则直接去除1行，否则，则去掉1列。
 * 最坏情况需要2n步，即从右上角开始查找，而要查找的目标值在左下角的时候。
 */
public class Ex11_6 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        if (n < 1 && m < 1)
            return null;
        int i = 0;
        int j = m - 1;
        int[] res = new int[2];
        while (i < n && j >= 0)
            if (mat[i][j] == x) {
                res[0] = i;
                res[1] = j;
                return res;
            } else if (mat[i][j] < x) {
                i += 1;
            }else{
                j -= 1;
            }
        return res;
    }
}

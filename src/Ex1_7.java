/**
 * 题目描述
 * <p>
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * 给定一个N阶方阵int[][](C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
 * 测试样例：
 * [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 * Created by Nancy on 2016/11/4.
 */
public class Ex1_7 {

    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[] rowArray = new boolean[n];
        boolean[] columnArray = new boolean[n];
        //记录为0的位置，把相应的行列位置设为true
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }
        //遍历找到之前记录的位置，把相应行列赋值为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowArray[i] || columnArray[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}

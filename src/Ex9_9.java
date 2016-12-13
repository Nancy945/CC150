import java.util.ArrayList;
import java.util.Arrays;

/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
 * 给定一个int n，请返回方法数，保证n小于等于10
 * 测试样例：
 * 1
 * 返回：1
 * Created by Nancy on 2016/12/12.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex9_9 {
    public int nQueens(int n) {

        int[] cols = new int[n];
        ArrayList<int[]> results = new ArrayList<>();

        //可以用int[] num = {0};来包装int num;效果相当于&num 这里用list保存结果，便于拓展
        placeQueues(cols, 0, results);

        results.forEach(ints -> System.out.println(Arrays.toString(ints)));
        return results.size();
    }

    private void placeQueues(int[] cols, int row, ArrayList<int[]> results) {
        if (row == cols.length) {
            results.add(cols.clone());
            return;
        }

        for (int i = 0; i < cols.length; i++) {
            if (checkValid(cols, row, i)) {
                cols[row] = i;
                placeQueues(cols, row + 1, results);
            }
        }


    }

    private boolean checkValid(int[] cols, int row, int column) {
        for (int tempRow = 0; tempRow < row; tempRow++) {
            //tempRow < row 是关键的一句，否则就算回溯了之后cols还有效！！因为我们没有每次找到一个答案就清空cols

            if (cols[tempRow] == column) {
                //列相同
                return false;
            }
            //行不可能相同，因为是一行一行放置的

            //斜线相同
            if (Math.abs(row - tempRow) == Math.abs(cols[tempRow] - column)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Ex9_9().nQueens(5));
    }
}


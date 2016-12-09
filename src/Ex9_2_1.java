/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * Created by Nancy on 2016/12/9.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex9_2_1 {

    public int countWays(int x, int y) {
        //方法1
//        return combination(x + y - 2, x - 1);

        //方法2
        //已经到目的地了
        if (x == 0 || y == 0) return 0;
        //还差一格子到目的地
        if (x == 1 || y == 1) return 1;
        return countWays(x - 1, y) + countWays(x, y - 1);
    }


    /**
     * 排列组合的方式求解。总共需要向下走 (宽-1)，向右走(长-1).需要做的就是求出他们的C排列有多少种。答案就是有多少种路线可以到达右下角。
     */
    private int combination(int x, int y) {

        int result = 1;

        for (int i = x; i > x - y; i--) {
            result *= i;
        }

        int div = 1;
        for (int i = 1; i <= y; i++) {
            div *= i;
        }

        return result / div;
    }


}

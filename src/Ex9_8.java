/**
 * Created by 余屌丝 on 2016/12/18.
 * 题目描述
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 * 测试样例：
 * 6
 * 返回：2
 */
public class Ex9_8 {

    //n为100的时候正确输出242，但是题目数据量到了10w级别运行出现超时。
    private int countWays(int n, int interval) {
        int nextInterval = 0;
        switch (interval) {
            case 1:
                return 1;
            case 5:
                nextInterval = 1;
                break;
            case 10:
                nextInterval = 5;
                break;
            case 25:
                nextInterval = 10;
                break;
            default:
                break;
        }

        int count = 0;
        for (int i = 0; i * interval < n; i++) {
            count += countWays(n - interval * i, nextInterval);
        }
        return count;

    }


    public int countWays2(int n) {
        int interval = 1;
        if (n >= 25) {
            interval = 25;
        } else if (n >= 10) {
            interval = 10;
        } else if (n >= 5) {
            interval = 5;
        }
        return countWays(n, interval);
    }

    public int countWays(int n) {
        // 方法二 二维的dp
        int coins[] = {1, 5, 10, 25};
        int[][] dp = new int[coins.length + 1][n + 1];
        for (int i = 1; i <= coins.length; i++) {
            //初始条件： dp[i][0] = 1; 总数为0的硬币用i种货币表示  只有一种情况：所有的系数为0
            //           dp[0][j] = 0; 总数为j的硬币用i种货币表示  为0

            dp[i][0] = 1;

            for (int j = 1; j <= n; j++) {

                for (int k = 0; k <= j / coins[i - 1]; ++k)
                    //    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];

                    if (j < coins[i - 1])
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
            }
        }
        return dp[coins.length][n];

    }


    public int countWays1(int n) {
        int coins[] = {1, 5, 10, 25};
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++)
            for (int j = coins[i]; j <= n; j++)
                //dp[i]=旧dp[i] + 新dp[i- coin]
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Ex9_8().countWays1(100));
    }

}


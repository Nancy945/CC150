import java.util.Arrays;

/**
 * 题目描述
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。
 * 同时我们应该让下面的人比上面的人更高一点。已知参加游戏的每
 * 个人的身高，请编写代码计算通过选择参与游戏的人，我们多能叠多
 * 少个人。注意这里的人都是先后到的，意味着参加游戏的人的先后顺序
 * 与原序列中的顺序应该一致。
 * 给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，
 * 请返回最多能叠的人数。保证n小于等于500。
 * 测试样例：
 * [1,6,2,5,3,4],6
 * 返回：4
 */
public class Ex11_7 {
    //1 动态规划
    public static int getHeight1(int[] men, int n) {
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;//没有 自身1个
            for (int j = 0; j < i; j++) {
                //dp[j] 当前最大的子序列树  dp[i] 为包含自己的最大子序列  dp[i] - 1 除掉自己
                //dp[j] > dp[i] - 1  在加入第j个位置时  dp[j] 比 dp[i] -1大
                if (men[j] < men[i] && dp[j] > dp[i] - 1) {
                    dp[i] += 1;
                }
            }

            if (max < dp[i])
                max = dp[i];

        }
        return max;
    }

    //2 最长公共子序列
    public int getHeight(int[] men, int n) {
        int[] newMen = Arrays.copyOf(men, men.length);
        Arrays.sort(men);
        LCS(men, newMen);

        //   getLCS(int [] a,int [] b);

        return nums[men.length][newMen.length];
    }


    private void getLCS(int[] a, int[] b) {
        int[] ret = new int[a.length < b.length ? a.length : b.length];
        int i = a.length;
        int j = b.length;
        int k = 0;

        while (i > 0 && j > 0) {
            if (flgs[i][j] == 1)   ///如果是斜向下标记
            {
                ret[k] = a[i - 1];
                k++;
                i--;
                j--;
            } else if (flgs[i][j] == 2)  ///如果是斜向右标记
                j--;
            else if (flgs[i][j] == 3)  ///如果是斜向下标记
                i--;
        }

        for (i = k - 1; i >= 0; i--)
            System.out.println(ret[i]);


    }

    private int[][] nums = new int[501][501];
    private int[][] flgs = new int[501][501];

    private void LCS(int[] a, int[] b) {
        for (int i = 1; i <= a.length; i++)
            for (int j = 1; j <= b.length; j++) {
                if (a[j - 1] == b[i - 1]) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                    flgs[i][j] = 1;

                    //   System.out.println(a[j - 1] +" ");
                    //上面的大于左边的
                } else if (nums[i][j - 1] > nums[i - 1][j]) {
                    nums[i][j] = nums[i][j - 1];
                    //从上面
                    flgs[i][j] = 2;
                } else {
                    nums[i][j] = nums[i - 1][j];
                    //向右边
                    flgs[i][j] = 3;
                }


            }

    }


    //以n结尾
    public int getHeight3(int[] men, int n) {
        // write code here
        int[] dp = new int[n];// 到 i位置时候的最长递增子序列的长度
        dp[0] = 1;
        int longest = 0;
        for (int i = 1; i < n; i++) {
            int sublongest = 0;
            int subindex = 0;
            // 找出 i 前面的 0-i-1个元素中 以 i个元素结束的递增子序列的最长的值
            while (subindex < i) {
                if (men[subindex] <= men[i])
                    sublongest = sublongest > dp[subindex] ? sublongest : dp[subindex];
                subindex++;
            }
            dp[i] = sublongest + 1;
            longest = longest > dp[i] ? longest : dp[i];
        }
        return longest;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 5, 3, 4};
        System.out.println(new Ex11_7().getHeight(a, a.length));
    }
}

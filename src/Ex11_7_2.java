import java.util.Arrays;
import java.util.Comparator;

/**
 * 叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，我们应该让上面的人比下面的人更轻一点。现在一个马戏团要表演这个节目，为了视觉效果，我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。
 * 给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
 * 测试样例：
 * [[1,2],[3,4],[5,6],[7,8]],4
 * 返回：4
 * Created by Nancy on 2016/12/14.
 * Url:https://github.com/Nancy945/CC150
 */
public class Ex11_7_2 {
    public int getHeight(int[][] men, int n) {
        class myComparator implements Comparator<int[]> {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        Arrays.sort(men, new myComparator());

        int[] dp = new int[men.length];
        Arrays.fill(dp, 1);//不能少，否则会错
        int maxLen = 1;

        for (int i = 1; i < men.length; i++) {
            for (int j = 0; j < i; j++) {
                if (men[i][1] > men[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLen = Math.max(dp[i], maxLen);

        }

        return maxLen;
    }
}

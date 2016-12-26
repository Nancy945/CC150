import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
 * 给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 * 测试样例：
 * 5 3
 * 返回：4
 */
public class Ex9_10_1 {
    public int getResult(int n, int m) {
        // write code here
        Queue<Integer> queue = new LinkedList<Integer>();
        //存
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int ret = -1;
        int count = 0;
        //取
        while (!queue.isEmpty()) {
            count++;
            ret = queue.poll();
            if (count != m) {
                queue.offer(ret);
            } else
                count = 0;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Ex9_10_1().getResult(385, 248));
        ;
    }
}
